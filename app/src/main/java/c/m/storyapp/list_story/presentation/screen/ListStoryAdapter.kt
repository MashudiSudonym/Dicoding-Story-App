package c.m.storyapp.list_story.presentation.screen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import c.m.storyapp.R
import c.m.storyapp.databinding.ItemStoryBinding
import c.m.storyapp.list_story.domain.model.ListStory
import coil.load

class ListStoryAdapter(private val onClick: (ListStory) -> Unit) :
    ListAdapter<ListStory, ListStoryAdapter.ListStoryViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListStoryViewHolder {
        val view = ItemStoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListStoryViewHolder(view, onClick)
    }

    override fun onBindViewHolder(holder: ListStoryViewHolder, position: Int) {
        val contents = getItem(position)
        holder.bind(contents)
    }

    class ListStoryViewHolder(
        itemView: ItemStoryBinding, onClick: (ListStory) -> Unit,
    ) : RecyclerView.ViewHolder(itemView.root) {
        private val titleStoryLayout = itemView.tvTitle
        private val imageStoryLayout = itemView.imgStory
        private val descriptionStoryLayout = itemView.tvDescription
        private val itemStoryLayout = itemView.itemStoryLayout
        private var thisListStory: ListStory? = null

        init {
            itemStoryLayout.setOnClickListener {
                thisListStory?.let {
                    onClick(it)
                }
            }
        }

        fun bind(listStory: ListStory) {
            thisListStory = listStory
            titleStoryLayout.text = listStory.name
            descriptionStoryLayout.text = listStory.description
            imageStoryLayout.load(listStory.photoUrl) {
                placeholder(R.drawable.ic_baseline_image_24)
                error(R.drawable.ic_baseline_broken_image_24)
            }
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<ListStory>() {
        override fun areItemsTheSame(oldItem: ListStory, newItem: ListStory): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: ListStory, newItem: ListStory): Boolean {
            return oldItem.id == newItem.id
        }
    }
}