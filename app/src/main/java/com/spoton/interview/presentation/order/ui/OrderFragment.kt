package com.spoton.interview.presentation.order.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.spoton.interview.R
import com.spoton.interview.databinding.FragmentOrderBinding
import com.spoton.interview.domain.OrderEntity
import com.spoton.interview.presentation.order.adapter.OrderItemsAdapter
import com.spoton.interview.presentation.order.viewmodel.OrderViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class OrderFragment : Fragment(R.layout.fragment_order) {

    private lateinit var binding: FragmentOrderBinding
    private val viewModel by viewModel<OrderViewModel>()

    private val adapter: OrderItemsAdapter by lazy {
        OrderItemsAdapter(layoutInflater)
    }

    private val redColor: Int by lazy {
        ContextCompat.getColor(requireContext(), R.color.red)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOrderBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.orderItemsRecyclerView.adapter = adapter
        viewModel.order.observe(viewLifecycleOwner) {
            showOrder(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.orderItemsRecyclerView.adapter = null
    }

    private fun showOrder(order: OrderEntity) {
        val total = order.items.sumOf { it.price }
        binding.run {
            orderNameTextView.text = getString(R.string.order_details_name, order.id)
            orderItemsCountTextView.text =
                getString(R.string.order_details_item_count, order.items.size)
            orderTotalTextView.text = getString(R.string.order_details_total, total)

            if (total > HIGH_TOTAL_TRESHOLD) {
                orderTotalTextView.setTextColor(redColor)
            }
        }
        adapter.submitList(order.items)
    }

    companion object {

        private const val HIGH_TOTAL_TRESHOLD = 200.0
    }
}