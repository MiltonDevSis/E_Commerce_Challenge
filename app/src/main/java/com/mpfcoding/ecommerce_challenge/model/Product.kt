package com.mpfcoding.ecommerce_challenge.model

data class Product(
    val title: String,
    val photoUrl: String,
    val price: Double,
    val isOnSale: Boolean
)