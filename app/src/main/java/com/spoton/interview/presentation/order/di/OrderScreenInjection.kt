package com.spoton.interview.presentation.order.di

import com.spoton.interview.presentation.order.viewmodel.OrderViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val orderScreenModule = module {

    viewModel {
        OrderViewModel(
            orderRepository = get(),
        )
    }
}