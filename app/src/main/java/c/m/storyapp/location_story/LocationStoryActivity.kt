package c.m.storyapp.location_story

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import c.m.storyapp.R
import c.m.storyapp.databinding.ActivityLocationStoryBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LocationStoryActivity : AppCompatActivity() {
    private lateinit var activityLocationStoryBinding: ActivityLocationStoryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityLocationStoryBinding = ActivityLocationStoryBinding.inflate(layoutInflater)
        val view = activityLocationStoryBinding.root
        setContentView(view)
    }
}