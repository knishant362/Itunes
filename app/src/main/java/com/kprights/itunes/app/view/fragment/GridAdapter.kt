package com.kprights.itunes.app.view.fragment

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.kprights.itunes.app.model.Entry
import com.kprights.itunes.app.view.customview.GridItem


/**
 * Copyright (c) 2020 for KPrights
 *
 * User : Kiran Pande
 * Date : 29/04/20
 * Time : 11:03 PM
 */

class GridAdapter(private val onClickListener: OnClickListener) :
    ListAdapter<Entry, GridItem>(EntryDiffCallback()) {
    // To create Feed List Item View
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = GridItem.from(parent)

    // Bind Single Entry to NewsListItem
    override fun onBindViewHolder(holder: GridItem, position: Int) {
        val entry = getItem(position)
        holder.bind(entry, onClickListener)
    }

    // New Difference Callback : To check differences between old list and new list.
    class EntryDiffCallback : DiffUtil.ItemCallback<Entry>() {
        override fun areItemsTheSame(oldItem: Entry, newItem: Entry): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Entry, newItem: Entry): Boolean {
            return oldItem == newItem
        }
    }

    class OnClickListener(val clickListener: (entry: Entry) -> Unit) {
        fun onClick(entry: Entry) = clickListener(entry)
    }
}