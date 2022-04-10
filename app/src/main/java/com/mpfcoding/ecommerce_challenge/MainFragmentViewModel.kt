package com.mpfcoding.ecommerce_challenge

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mpfcoding.ecommerce_challenge.model.Product
import com.mpfcoding.ecommerce_challenge.utils.ProductFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainFragmentViewModel : ViewModel() {

    val products = MutableLiveData<List<Product>>()

    fun setup() {
        viewModelScope.launch(Dispatchers.Default) {
            products.postValue(ProductFactory.createProductFactory())
        }
    }
}
