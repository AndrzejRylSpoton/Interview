package com.spoton.interview.presentation.order.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.spoton.interview.data.repository.OrderRepository
import com.spoton.interview.domain.OrderEntity
import kotlinx.coroutines.launch
import java.util.*

class OrderViewModel(
    private val orderRepository: OrderRepository,
): ViewModel() {

    private val _order = MutableLiveData<OrderEntity>()
    val order: LiveData<OrderEntity> = _order

    init {
        viewModelScope.launch {
            val currentOrder = orderRepository.getOrder()
            if (currentOrder.createdAtTimestamp < Date().time) {
                _order.value = currentOrder
            }
        }
    }
}