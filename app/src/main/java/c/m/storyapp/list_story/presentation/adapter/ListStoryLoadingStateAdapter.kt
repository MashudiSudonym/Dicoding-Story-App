package c.m.storyapp.list_story.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import c.m.storyapp.databinding.ItemLoadingBinding
import javax.inject.Inject

class ListStoryLoadingStateAdapter @Inject constructor(private val retry: () -> Unit) :
    LoadStateAdapter<ListStoryLoadingStateAdapter.ListStoryLoadingStateViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        loadState: LoadState,
    ): ListStoryLoadingStateViewHolder {
        val itemLoadingBinding =
            ItemLoadingBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ListStoryLoadingStateViewHolder(itemLoadingBinding, retry)
    }

    override fun onBindViewHolder(holder: ListStoryLoadingStateViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    class ListStoryLoadingStateViewHolder(
        private val itemLoadingBinding: ItemLoadingBinding,
        retry: () -> Unit,
    ) : RecyclerView.ViewHolder(itemLoadingBinding.root) {
        init {
            itemLoadingBinding.btnRetry.setOnClickListener { retry() }
        }

        fun bind(loadState: LoadState) {
            if (loadState is LoadState.Error) {
                itemLoadingBinding.tvNoData.text = loadState.error.localizedMessage
            }

            itemLoadingBinding.loadingIndicator.isVisible = loadState is LoadState.Loading
            itemLoadingBinding.tvNoData.isVisible = loadState is LoadState.Error
            itemLoadingBinding.btnRetry.isVisible = loadState is LoadState.Error
        }
    }
}