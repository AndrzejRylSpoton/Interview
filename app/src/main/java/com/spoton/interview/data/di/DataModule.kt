package com.spoton.interview.data.di

import androidx.room.Room
import com.spoton.interview.data.InterviewDatabase
import com.spoton.interview.data.InterviewDatabase.Companion.NAME
import com.spoton.interview.data.repository.OrderRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module {

    single {
        Room.databaseBuilder(androidContext(), InterviewDatabase::class.java, NAME)
            .build()
    }

    factory {
        OrderRepository(
            orderDao = get<InterviewDatabase>().orderDao()
        )
    }
}