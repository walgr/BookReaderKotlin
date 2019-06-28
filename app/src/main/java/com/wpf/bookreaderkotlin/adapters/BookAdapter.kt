/**
 * Copyright (C), 2015-2019
 * Author: zhongtaizu-wangpengfei
 * Date: 2019-06-24 15:35
 * Description: 主页书架Adapter
 */
package com.wpf.bookreaderkotlin.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.wpf.bookreaderkotlin.data.BookInfo
import com.wpf.bookreaderkotlin.databinding.ItemBookLayoutBinding

class BookAdapter : ListAdapter<BookInfo, BookAdapter.HomeViewHolder>(BookDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(
            ItemBookLayoutBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val book = getItem(position)
        holder.apply {
            bind(createOnClickListener(),book)
            itemView.tag = book
        }
    }

    private fun createOnClickListener(): View.OnClickListener {
        return View.OnClickListener {

        }
    }

    class HomeViewHolder(private val binding: ItemBookLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(listener: View.OnClickListener, item: BookInfo) {
            binding.apply {
                clickListener = listener
                bookInfo = item
                executePendingBindings()
            }
        }
    }
}

private class BookDiffCallback : DiffUtil.ItemCallback<BookInfo>() {

    override fun areItemsTheSame(oldItem: BookInfo, newItem: BookInfo): Boolean {
        return oldItem.bookUrl == newItem.bookUrl
    }

    override fun areContentsTheSame(oldItem: BookInfo, newItem: BookInfo): Boolean {
        return oldItem == newItem
    }

}