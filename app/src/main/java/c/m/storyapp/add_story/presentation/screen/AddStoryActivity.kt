package c.m.storyapp.add_story.presentation.screen

import android.Manifest
import android.app.ActivityOptions
import android.content.Intent
import android.content.Intent.ACTION_GET_CONTENT
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import c.m.storyapp.R
import c.m.storyapp.add_story.presentation.view_model.AddStoryViewModel
import c.m.storyapp.common.presentation.custom_view.camera_view.CameraActivity
import c.m.storyapp.common.util.Constants
import c.m.storyapp.common.util.reduceFileImage
import c.m.storyapp.common.util.rotateBitmap
import c.m.storyapp.common.util.uriToFile
import c.m.storyapp.databinding.ActivityAddStoryBinding
import c.m.storyapp.list_story.presentation.screen.ListStoryActivity
import coil.load
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.io.File

@AndroidEntryPoint
class AddStoryActivity : AppCompatActivity() {
    private val addStoryViewModel: AddStoryViewModel by viewModels()
    private lateinit var activityAddStoryBinding: ActivityAddStoryBinding
    private var getFile: File? = null

    companion object {
        private val REQUIRED_PERMISSIONS = arrayOf(Manifest.permission.CAMERA)
    }

    @Suppress("DEPRECATION")
    private val launcherIntentCamera =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Constants.CAMERA_X_RESULT) {
                val myFile = result.data?.getSerializableExtra(Constants.PICTURE) as File
                val isBackCamera =
                    result.data?.getBooleanExtra(Constants.IS_BACK_CAMERA, true) as Boolean
                val resultBitmap = rotateBitmap(BitmapFactory.decodeFile(myFile.path), isBackCamera)

                getFile = myFile

                activityAddStoryBinding.imgPhoto.load(resultBitmap) {
                    placeholder(R.drawable.ic_baseline_image_24)
                    error(R.drawable.ic_baseline_broken_image_24)
                }
            }
        }

    private val launcherIntentGallery =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val selectedImage: Uri = result.data?.data as Uri
                val myFile = uriToFile(selectedImage, this@AddStoryActivity)

                getFile = myFile

                activityAddStoryBinding.imgPhoto.load(selectedImage) {
                    placeholder(R.drawable.ic_baseline_image_24)
                    error(R.drawable.ic_baseline_broken_image_24)
                }
            }
        }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray,
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == Constants.REQUEST_CODE_PERMISSIONS) {
            if (!allPermissionGranted()) {
                Snackbar.make(activityAddStoryBinding.root,
                    R.string.error_permission_not_allowed,
                    Snackbar.LENGTH_SHORT).show()
            }
        }
    }

    private fun allPermissionGranted() = REQUIRED_PERMISSIONS.all {
        ContextCompat.checkSelfPermission(baseContext, it) == PackageManager.PERMISSION_GRANTED
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityAddStoryBinding = ActivityAddStoryBinding.inflate(layoutInflater)
        val view = activityAddStoryBinding.root
        setContentView(view)

        if (!allPermissionGranted()) {
            ActivityCompat.requestPermissions(this,
                REQUIRED_PERMISSIONS,
                Constants.REQUEST_CODE_PERMISSIONS)
        }

        activityAddStoryBinding.btnOpenCamera.setOnClickListener { startCamera() }
        activityAddStoryBinding.btnOpenGallery.setOnClickListener { startGallery() }
        activityAddStoryBinding.btnAddStory.setOnClickListener {
            if (getFile != null) {
                val file = reduceFileImage(getFile as File)

                addStoryViewModel.postStory(
                    file,
                    activityAddStoryBinding.edtDescriptionField.text.toString()
                )
            } else {
                noPhotoError(view)
            }

            lifecycleScope.launch {
                addStoryViewModel.addStoryUIState.collect { addStoryUIState ->
                    if (addStoryUIState.isLoading) {
                        activityAddStoryBinding.loadingIndicator.visibility = View.VISIBLE
                    } else {
                        activityAddStoryBinding.loadingIndicator.visibility = View.GONE
                    }

                    when {
                        addStoryUIState.isSuccess -> {
                            openListStoryActivity()
                        }
                        addStoryUIState.isError -> {
                            Snackbar.make(view,
                                addStoryUIState.errorMessage?.asString(this@AddStoryActivity)
                                    .toString(),
                                Snackbar.LENGTH_SHORT).show()
                        }
                    }

                    when {
                        addStoryUIState.descriptionFieldError != null -> {
                            activityAddStoryBinding.tilDescriptionField.apply {
                                isErrorEnabled = true
                                error =
                                    addStoryUIState.descriptionFieldError.asString(this@AddStoryActivity)
                            }
                        }
                        else -> {
                            activityAddStoryBinding.tilDescriptionField.isErrorEnabled = false
                        }
                    }

                    when {
                        addStoryUIState.photoFieldError != null -> {
                            noPhotoError(view)
                        }
                    }
                }
            }
        }
    }

    private fun openListStoryActivity() {
        startActivity(Intent(this, ListStoryActivity::class.java),
            ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        finish()
    }

    private fun noPhotoError(view: CoordinatorLayout) {
        Snackbar.make(view, R.string.please_take_a_photo, Snackbar.LENGTH_LONG).show()
    }

    private fun startCamera() {
        launcherIntentCamera.launch(Intent(this, CameraActivity::class.java))
    }

    private fun startGallery() {
        val intent = Intent().apply {
            action = ACTION_GET_CONTENT
            type = Constants.INTENT_TYPE
        }
        val chooser = Intent.createChooser(intent, Constants.CHOOSE_A_PICTURE)

        launcherIntentGallery.launch(chooser)
    }
}