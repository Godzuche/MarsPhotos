package com.example.android.marsphotos.overview

import android.text.Layout
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.marsphotos.databinding.GridViewItemBinding
import com.example.android.marsphotos.network.MarsPhoto

class PhotoGridAdapter: ListAdapter<MarsPhoto, PhotoGridAdapter.MarsPhotoViewHolder>(DiffCallBack) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarsPhotoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = GridViewItemBinding.inflate(inflater)
        return MarsPhotoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MarsPhotoViewHolder, position: Int) {
        val marsPhoto = getItem(position)
        holder.bind(marsPhoto)
    }

    inner class MarsPhotoViewHolder(private var binding: GridViewItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(MarsPhoto: MarsPhoto) {
            binding.photos = MarsPhoto
            // this line causes the update to execute immediately
            binding.executePendingBindings()
        }
    }

    companion object DiffCallBack: DiffUtil.ItemCallback<MarsPhoto>() {
        override fun areItemsTheSame(oldItem: MarsPhoto, newItem: MarsPhoto): Boolean {
            // Compare the IDs since they are unique
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MarsPhoto, newItem: MarsPhoto): Boolean {
            // Checking if they have the same data
            return oldItem.imgSrcUrl == newItem.imgSrcUrl
        }
    }
}