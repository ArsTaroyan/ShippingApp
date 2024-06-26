package com.example.shipping.presentation.shippingscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shipping.domain.module.Product
import com.example.shipping.domain.repo.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShippingViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    val getAllProducts = MutableSharedFlow<Flow<List<Product>>>(1)

    fun getAllProducts() {
        viewModelScope.launch {
            getAllProducts.emit(repository.getAllProducts())
        }
    }

    fun addProduct(product: Product) {
        viewModelScope.launch {
            repository.addProduct(product)
        }
    }

    fun removeProduct(product: Product) {
        viewModelScope.launch {
            repository.removeProduct(product)
        }
    }

    fun removeAllProducts() {
        viewModelScope.launch {
            repository.removeAllProducts()
        }
    }

    fun updateProduct(product: Product) {
        viewModelScope.launch {
            repository.updateProduct(product)
        }
    }
}