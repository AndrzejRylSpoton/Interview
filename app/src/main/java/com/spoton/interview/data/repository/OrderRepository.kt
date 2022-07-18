package com.spoton.interview.data.repository

import com.spoton.interview.data.dao.OrderDao
import com.spoton.interview.data.model.OrderDto
import com.spoton.interview.data.model.OrderItemDto
import com.spoton.interview.domain.ItemEntity
import com.spoton.interview.domain.OrderEntity
import java.util.*

class OrderRepository(
    private val orderDao: OrderDao,
) {

    suspend fun getOrder(): OrderEntity {
        val orderDto = orderDao.getOrder()
        return OrderEntity(
            id = orderDto.order.orderId,
            createdAtTimestamp = orderDto.order.createdAtTimestamp,
            items = orderDto.orderItems.map
            { orderItemDto ->
                ItemEntity(
                    id = orderItemDto.orderItemId,
                    name = orderItemDto.name,
                    price = orderItemDto.price,
                )
            }
        )
    }

    //region Demo
    // This is only for demo purposes.
    suspend fun loadTestData() {
        val orderId = "34567"
        val testOrder = OrderDto(
            orderId = orderId,
            createdAtTimestamp = Date().time - 10_000
        )

        val testItems = listOf(
            OrderItemDto(
                orderId = orderId,
                orderItemId = "333",
                name = "item1",
                price = 10.00,
            ),
            OrderItemDto(
                orderId = orderId,
                orderItemId = "334",
                name = "item2",
                price = 15.00,
            ),OrderItemDto(
                orderId = orderId,
                orderItemId = "335",
                name = "item3",
                price = 123.12,
            ),OrderItemDto(
                orderId = orderId,
                orderItemId = "336",
                name = "item4",
                price = 1.23,
            ),
        )
        orderDao.addOrder(testOrder)
        testItems.forEach {
            orderDao.addOrderItem(it)
        }
    }
    //endregion
}
