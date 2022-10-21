package c.m.storyapp.list_story.presentation.screen

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import c.m.storyapp.R
import c.m.storyapp.add_story.presentation.screen.AddStoryActivity
import c.m.storyapp.common.util.Constants
import c.m.storyapp.databinding.ActivityListStoryBinding
import c.m.storyapp.detail_story.presentation.screen.DetailStoryActivity
import c.m.storyapp.list_story.domain.model.ListStory
import c.m.storyapp.list_story.presentation.view_model.ListStoryViewModel
import c.m.storyapp.login.presentation.screen.LoginActivity
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ListStoryActivity : AppCompatActivity() {
    private val listStoryViewModel: ListStoryViewModel by viewModels()
    private lateinit var activityListStoryBinding: ActivityListStoryBinding
    private lateinit var listStoryAdapter: ListStoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityListStoryBinding = ActivityListStoryBinding.inflate(layoutInflater)
        val view = activityListStoryBinding.root
        setContentView(view)

        activityListStoryBinding.fabAddStory.setOnClickListener { openAddStoryActivity() }

        activityListStoryBinding.btnLogout.setOnClickListener { listStoryViewModel.logout() }

        listStoryAdapter = ListStoryAdapter()

        lifecycleScope.launch {
            listStoryViewModel.listStoryUIState.collect { listStoryUIState ->
                if (listStoryUIState.isLoading) {
                    activityListStoryBinding.loadingIndicator.visibility = View.VISIBLE
                } else {
                    activityListStoryBinding.loadingIndicator.visibility = View.GONE
                }

                if (listStoryUIState.isError) {
                    Snackbar.make(view,
                        listStoryUIState.errorMessage?.asString(this@ListStoryActivity)
                            .toString(),
                        Snackbar.LENGTH_SHORT).show()
                    openLoginActivity()
                }

                if (listStoryUIState.isSuccess) {
                    if (listStoryUIState.listStory.isEmpty()) {
                        activityListStoryBinding.tvNoData.visibility = View.VISIBLE
                        Snackbar.make(view,
                            R.string.error_no_story_data,
                            Snackbar.LENGTH_LONG).show()
                    }

                    activityListStoryBinding.tvNoData.visibility = View.GONE
                    listStoryAdapter.submitList(listStoryUIState.listStory)
                    activityListStoryBinding.rvListStory.adapter = listStoryAdapter
                    activityListStoryBinding.rvListStory.setHasFixedSize(true)

                    // If user logout status success
                    if (listStoryUIState.isLogout) {
                        openLoginActivity()
                    }
                }
            }
        }
    }

    private fun openAddStoryActivity() {
        startActivity(Intent(this, AddStoryActivity::class.java),
            ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
    }

    private fun openLoginActivity() {
        startActivity(Intent(this, LoginActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        },
            ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        finish()
    }
}