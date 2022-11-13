package c.m.storyapp.list_story.presentation.screen

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import c.m.storyapp.add_story.presentation.screen.AddStoryActivity
import c.m.storyapp.databinding.ActivityListStoryBinding
import c.m.storyapp.list_story.presentation.adapter.ListStoryAdapter
import c.m.storyapp.list_story.presentation.adapter.ListStoryLoadingStateAdapter
import c.m.storyapp.list_story.presentation.view_model.ListStoryViewModel
import c.m.storyapp.location_story.presentation.screen.LocationStoryActivity
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

        listStoryAdapter = ListStoryAdapter()

        activityListStoryBinding.fabMaps.setOnClickListener { openLocationStoryActivity() }

        activityListStoryBinding.fabAddStory.setOnClickListener { openAddStoryActivity() }

        activityListStoryBinding.btnLogout.setOnClickListener { listStoryViewModel.logout() }

        lifecycleScope.launch {
            listStoryViewModel.listStoryUIState.collect { listStoryUIState ->
                if (listStoryUIState.isLoading) {
                    activityListStoryBinding.loadingIndicator.visibility = View.VISIBLE
                } else {
                    activityListStoryBinding.loadingIndicator.visibility = View.GONE
                }

                if (listStoryUIState.isError) {
                    activityListStoryBinding.tvNoData.visibility = View.VISIBLE

                    Snackbar.make(view,
                        listStoryUIState.errorMessage?.asString(this@ListStoryActivity)
                            .toString(),
                        Snackbar.LENGTH_SHORT).show()
                    openLoginActivity()
                }

                if (listStoryUIState.isSuccess) {
                    // initialize recyclerview with adapters
                    listStoryAdapter.submitData(listStoryUIState.story)
                    activityListStoryBinding.tvNoData.visibility = View.GONE
                    activityListStoryBinding.rvListStory.adapter =
                        listStoryAdapter.withLoadStateFooter(
                            footer = ListStoryLoadingStateAdapter {
                                listStoryAdapter.retry()
                            }
                        )
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

    private fun openLocationStoryActivity() {
        startActivity(Intent(this, LocationStoryActivity::class.java),
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