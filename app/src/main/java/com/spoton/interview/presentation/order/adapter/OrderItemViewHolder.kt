package com.spoton.interview.presentation.order.adapter

import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.spoton.interview.R
import com.spoton.interview.databinding.ItemOrderItemBinding
import com.spoton.interview.domain.ItemEntity

class OrderItemViewHolder(
    private val binding: ItemOrderItemBinding,
) : RecyclerView.ViewHolder(binding.root) {

    private val redColor: Int by lazy {
        ContextCompat.getColor(
            binding.root.context,
            R.color.red,
        )
    }

    fun bind(item: ItemEntity) {
        binding.run {
            orderItemNameTextView.text = item.name
            orderItemPriceTextView.text =
                binding.root.context.getString(R.string.order_item_price, item.price)

            if (item.price > HIGH_PRICE_TRESHOLD) {
                orderItemPriceTextView.setTextColor(redColor)
            }
        }
    }

    companion object {

        private const val HIGH_PRICE_TRESHOLD = 100.0
    }
}
