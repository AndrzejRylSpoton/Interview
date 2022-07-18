package com.spoton.interview.presentation.order.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.spoton.interview.databinding.ItemOrderItemBinding
import com.spoton.interview.domain.ItemEntity

class OrderItemsAdapter(
    private val layoutInflater: LayoutInflater
) : ListAdapter<ItemEntity, OrderItemViewHolder>(OrderItemDiffer()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderItemViewHolder {
        val binding: ItemOrderItemBinding = ItemOrderItemBinding.inflate(layoutInflater, parent, false)

        return OrderItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OrderItemViewHolder, position: Int) =
        holder.bind(getItem(position))

    private class OrderItemDiffer : DiffUtil.ItemCallback<ItemEntity>() {

        override fun areItemsTheSame(oldItem: ItemEntity, newItem: ItemEntity): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: ItemEntity, newItem: ItemEntity): Boolean =
            oldItem == newItem
    }
}