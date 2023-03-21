package com.zelyder.recyclemap.domain.util

sealed class OrderType {
    object Ascending: OrderType()
    object Descending: OrderType()
}
