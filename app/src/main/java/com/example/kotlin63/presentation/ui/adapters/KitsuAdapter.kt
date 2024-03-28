package com.example.kotlin63.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlin62.ui.model.Data
import com.example.kotlin63.databinding.ItemAnimeMangaBinding


class KitsuAdapter : PagingDataAdapter<Data, KitsuAdapter.ViewHolder>(diffUtil) {

    inner class ViewHolder(private val binding: ItemAnimeMangaBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(animeData: Data) = with(binding) {
            Glide.with(ivItemAnimeManga.context)
                .load(animeData.attributes.posterImage.original)
                .into(ivItemAnimeManga)
            tvItemAnimeManga.text = animeData.attributes.titles?.en ?: ""

        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let {
            holder.onBind(it)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemAnimeMangaBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Data>() {
            override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
                return oldItem == newItem
            }
        }
    }
}