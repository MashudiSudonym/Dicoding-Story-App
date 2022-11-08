package c.m.storyapp.location_story.presentation.screen

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import androidx.lifecycle.lifecycleScope
import c.m.storyapp.R
import c.m.storyapp.common.util.Constants
import c.m.storyapp.databinding.ActivityLocationStoryBinding
import c.m.storyapp.detail_story.presentation.screen.DetailStoryActivity
import c.m.storyapp.location_story.presentation.view_model.LocationStoryViewModel
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.*
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LocationStoryActivity : AppCompatActivity() {
    private lateinit var activityLocationStoryBinding: ActivityLocationStoryBinding
    private val locationStoryViewModel: LocationStoryViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityLocationStoryBinding = ActivityLocationStoryBinding.inflate(layoutInflater)

        val view = activityLocationStoryBinding.root
        setContentView(view)

        activityLocationStoryBinding.mvLocationStory.onCreate(savedInstanceState)

        lifecycleScope.launch {
            locationStoryViewModel.locationStoryUIState.collect { locationStoryUIState ->
                if (locationStoryUIState.isLoading) {
                    activityLocationStoryBinding.loadingIndicator.visibility = View.VISIBLE
                } else {
                    activityLocationStoryBinding.loadingIndicator.visibility = View.GONE
                }

                if (locationStoryUIState.isError) {
                    activityLocationStoryBinding.tvNoData.visibility = View.VISIBLE

                    Snackbar.make(view,
                        locationStoryUIState.errorMessage?.asString(this@LocationStoryActivity)
                            .toString(),
                        Snackbar.LENGTH_SHORT).show()
                }

                if (locationStoryUIState.isSuccess) {
                    if (locationStoryUIState.locationStory.isEmpty()) {
                        activityLocationStoryBinding.tvNoData.visibility = View.VISIBLE

                        Snackbar.make(view,
                            R.string.error_no_story_data,
                            Snackbar.LENGTH_LONG).show()
                    }

                    activityLocationStoryBinding.mvLocationStory.getMapAsync { googleMap ->
                        googleMap.run {
                            mapType = GoogleMap.MAP_TYPE_NORMAL

                            uiSettings.isCompassEnabled = true
                            uiSettings.isZoomControlsEnabled = true
                            setPadding(16, 16, 16, 128)

                            animateCamera(
                                CameraUpdateFactory.newCameraPosition(
                                    CameraPosition.Builder()
                                        .target(
                                            LatLng(
                                                -6.200000,
                                                106.816666
                                            )
                                        )
                                        .zoom(10f).build()
                                )
                            )
                        }

                        locationStoryUIState.locationStory.forEach { data ->
                            googleMap.run {
                                val marker = MarkerOptions().position(LatLng(
                                    data.latitude, data.longitude
                                )).title(data.name)
                                    .snippet(data.description)

                                addMarker(marker)?.tag = data.id

                                setOnMarkerClickListener { markerOnClick ->
                                    markerOnClick.showInfoWindow()
                                    false
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        activityLocationStoryBinding.mvLocationStory.onDestroy()
    }

    override fun onResume() {
        super.onResume()

        activityLocationStoryBinding.mvLocationStory.onResume()
    }

    override fun onPause() {
        super.onPause()

        activityLocationStoryBinding.mvLocationStory.onPause()
    }

    override fun onStart() {
        super.onStart()

        activityLocationStoryBinding.mvLocationStory.onStart()
    }

    override fun onStop() {
        super.onStop()

        activityLocationStoryBinding.mvLocationStory.onStop()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        activityLocationStoryBinding.mvLocationStory.onSaveInstanceState(outState)
    }

    override fun onLowMemory() {
        super.onLowMemory()

        activityLocationStoryBinding.mvLocationStory.onLowMemory()
    }
}