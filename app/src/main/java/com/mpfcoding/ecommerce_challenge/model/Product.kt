package com.mpfcoding.ecommerce_challenge.model

import java.io.Serializable

data class Product(
    var title: String,
    val photoUrl: String,
    val price: Double,
    val isOnSale: Boolean
): Serializable