package com.spoton.interview.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.spoton.interview.data.InterviewDatabase.Companion.VERSION
import com.spoton.interview.data.dao.OrderDao
import com.spoton.interview.data.model.OrderDto
import com.spoton.interview.data.model.OrderItemDto

@Database(
    entities = [
        OrderDto::class,
        OrderItemDto::class,
    ],
    version = VERSION,
    exportSchema = true,
)
abstract class InterviewDatabase : RoomDatabase() {

    abstract fun orderDao(): OrderDao

    companion object {

        const val NAME = "Interview.db"
        const val VERSION = 1
    }
}