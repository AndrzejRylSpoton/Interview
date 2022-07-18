package com.spoton.interview.domain

data class OrderEntity(
    val id: String,
    val createdAtTimestamp: Long,
    val items: List<ItemEntity>,
)
