package com.mpfcoding.ecommerce_challenge.repository

import com.mpfcoding.ecommerce_challenge.model.Product
import io.reactivex.Single

class ProductsRepository {

    fun getAllProducts(): Single<List<Product>> {
        return Single.create {
            it.onSuccess(fetchProducts())
        }
    }

    fun getProductByName(name: String): Single<Product> {
        return Single.create {
            val product = fetchProducts().first { it.title == name }
            it.onSuccess(product)
        }
    }

    private fun fetchProducts(): List<Product> {
        // TODO(room)
        return emptyList()
    }
}
