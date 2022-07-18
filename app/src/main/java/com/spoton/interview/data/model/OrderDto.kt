package com.spoton.interview.data.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation

@Entity(
    tableName = "orders",
    primaryKeys = ["orderId"]
)
data class OrderDto(
    val orderId: String,
    val createdAtTimestamp: Long,
)

data class OrderWithItemsJoined(
    @Embedded val order: OrderDto,

    @Relation(
        entity = OrderItemDto::class,
        parentColumn = "orderId",
        entityColumn = "orderId"
    )
    val orderItems: List<OrderItemDto>,
)