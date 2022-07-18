package com.spoton.interview.data.model

import androidx.room.*

@Entity(
    tableName = "order_items",
    primaryKeys = ["orderItemId"],
    indices = [Index("orderItemId"), Index("orderId")],
    foreignKeys = [ForeignKey(
        entity = OrderDto::class,
        parentColumns = arrayOf("orderId"),
        childColumns = arrayOf("orderId"),
        onDelete = ForeignKey.CASCADE
    )]
)
data class OrderItemDto(
    val orderItemId: String,
    val orderId: String,
    val name: String,
    val price: Double,
)