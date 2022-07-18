package com.spoton.interview

import android.app.Application
import com.spoton.interview.data.di.dataModule
import com.spoton.interview.data.repository.OrderRepository
import com.spoton.interview.presentation.order.di.orderScreenModule
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin

class InterviewApplication : Application() {

    private val orderRepository: OrderRepository by inject()

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@InterviewApplication)

            loadKoinModules(orderScreenModule + dataModule)

            loadTestData()
        }
    }

    //region Demo
    // This is only for demo purposes.
    private fun loadTestData() {
        GlobalScope.launch {
            orderRepository.loadTestData()
        }
    }
    //endregion
}