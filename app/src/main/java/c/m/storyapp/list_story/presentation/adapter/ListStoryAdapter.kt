package c.m.storyapp.list_story.presentation.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import c.m.storyapp.R
import c.m.storyapp.common.util.Constants
import c.m.storyapp.databinding.ItemStoryBinding
import c.m.storyapp.detail_story.presentation.screen.DetailStoryActivity
import c.m.storyapp.list_story.domain.model.Story
import coil.load

class ListStoryAdapter(diffCallback: DiffUtil.ItemCallback<Story>) :
    PagingDataAdapter<Story, ListStoryAdapter.ListStoryViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListStoryViewHolder {
        val view = ItemStoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListStoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListStoryViewHolder, position: Int) {
        val contents = getItem(position)

        if (contents != null) {
            holder.bind(contents)
        }
    }

    class ListStoryViewHolder(itemStoryBinding: ItemStoryBinding) :
        RecyclerView.ViewHolder(itemStoryBinding.root) {
        private val titleStoryLayout = itemStoryBinding.tvTitle
        private val imageStoryLayout = itemStoryBinding.imgStory
        private val descriptionStoryLayout = itemStoryBinding.tvDescription
        private val itemStoryLayout = itemStoryBinding.itemStoryLayout
        private var thisStory: Story? = null

        fun bind(story: Story) {
            thisStory = story
            titleStoryLayout.text = story.name
            descriptionStoryLayout.text = story.description
            imageStoryLayout.load(story.photoUrl) {
                placeholder(R.drawable.ic_baseline_image_24)
                error(R.drawable.ic_baseline_broken_image_24)
            }
            itemStoryLayout.setOnClickListener {
                val intent = Intent(itemView.context, DetailStoryActivity::class.java).apply {
                    putExtra(Constants.STORY_ID, story)
                }
                itemView.context.startActivity(intent,
                    ActivityOptionsCompat.makeSceneTransitionAnimation(
                        itemView.context as Activity,
                        Pair(imageStoryLayout, Constants.IMAGE),
                        Pair(titleStoryLayout, Constants.TITLE),
                        Pair(descriptionStoryLayout, Constants.DESCRIPTION),
                    ).toBundle())
            }
        }
    }
}