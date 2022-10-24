package c.m.storyapp.detail_story.presentation.screen

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import c.m.storyapp.R
import c.m.storyapp.common.util.Constants
import c.m.storyapp.common.util.setLocalDateFormat
import c.m.storyapp.databinding.ActivityDetailStoryBinding
import c.m.storyapp.list_story.domain.model.ListStory
import coil.load

class DetailStoryActivity : AppCompatActivity() {
    private lateinit var activityDetailStoryBinding: ActivityDetailStoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityDetailStoryBinding = ActivityDetailStoryBinding.inflate(layoutInflater)
        val view = activityDetailStoryBinding.root
        setContentView(view)

        @Suppress("DEPRECATION") val intentData = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(Constants.STORY_ID, ListStory::class.java)
        } else {
            intent.getParcelableExtra(Constants.STORY_ID)
        }

        activityDetailStoryBinding.tvTitle.text = intentData?.name ?: ""
        activityDetailStoryBinding.imgStory.load(intentData?.photoUrl ?: "") {
            placeholder(R.drawable.ic_baseline_image_24)
            error(R.drawable.ic_baseline_broken_image_24)
        }
        activityDetailStoryBinding.tvDescription.text = intentData?.description ?: ""
        activityDetailStoryBinding.tvCreatedAt.text =
            "${resources.getString(R.string.created_at)}${setLocalDateFormat(intentData?.createdAt ?: "-")}"
    }
}