package c.m.storyapp.list_story.presentation.utils

import androidx.recyclerview.widget.DiffUtil
import c.m.storyapp.list_story.domain.model.Story

object StoryComparator : DiffUtil.ItemCallback<Story>() {
    override fun areItemsTheSame(oldItem: Story, newItem: Story): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Story, newItem: Story): Boolean {
        return oldItem.id == newItem.id
    }
}