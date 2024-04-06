package com.example.kotlin63.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlin63.data.remote.models.Data
import com.example.kotlin63.databinding.ItemAnimeMangaBinding

class MangaAdapter(private val onItemClick: (id: String) -> Unit) :
    PagingDataAdapter<Data, MangaAdapter.MangaViewHolder>(DiffUtilCallback()) {

    inner class MangaViewHolder(private val binding: ItemAnimeMangaBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                getItem(absoluteAdapterPosition)?.let {
                    onItemClick(it.id)
                }
            }
        }

        fun onBind(mangaModule: Data) {
            Glide.with(binding.ivItemAnimeManga.context).load(
                mangaModule.attributes.posterImage.medium
            ).into(binding.ivItemAnimeManga)
            binding.tvItemAnimeManga.text = mangaModule.attributes.titles?.en ?: "data missing"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MangaViewHolder {
        return MangaViewHolder(
            ItemAnimeMangaBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MangaViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }

    class DiffUtilCallback : DiffUtil.ItemCallback<Data>() {

        override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem == newItem
        }
    }
}