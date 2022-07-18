package com.spoton.interview.data.dao

import androidx.room.*
import com.spoton.interview.data.model.OrderDto
import com.spoton.interview.data.model.OrderItemDto
import com.spoton.interview.data.model.OrderWithItemsJoined

@Dao
interface OrderDao {


    @Transaction
    @Query(
        """
        SELECT * FROM orders o LIMIT 1
        """
    )
    suspend fun getOrder(): OrderWithItemsJoined

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addOrder(order: OrderDto)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addOrderItem(orderItem: OrderItemDto)
}