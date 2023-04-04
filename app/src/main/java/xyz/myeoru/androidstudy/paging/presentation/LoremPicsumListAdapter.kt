package xyz.myeoru.androidstudy.paging.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import xyz.myeoru.androidstudy.databinding.ListItemImageBinding
import xyz.myeoru.androidstudy.paging.domain.ImageModel

class LoremPicsumListAdapter :
    PagingDataAdapter<ImageModel, LoremPicsumListAdapter.ImageViewHolder>(object :
        DiffUtil.ItemCallback<ImageModel>() {
        override fun areItemsTheSame(oldItem: ImageModel, newItem: ImageModel): Boolean {
            return oldItem.id == newItem.id && oldItem.author == newItem.author
        }

        override fun areContentsTheSame(oldItem: ImageModel, newItem: ImageModel): Boolean {
            return oldItem.id == newItem.id && oldItem == newItem
        }
    }) {
    override fun onBindViewHolder(holder: LoremPicsumListAdapter.ImageViewHolder, position: Int) {
        val item = getItem(position) ?: return
        holder.onBind(item)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LoremPicsumListAdapter.ImageViewHolder {
        return ImageViewHolder(
            ListItemImageBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    inner class ImageViewHolder(private val binding: ListItemImageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: ImageModel) {
            binding.item = item
        }
    }
}