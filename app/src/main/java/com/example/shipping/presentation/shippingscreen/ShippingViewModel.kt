package com.example.shipping.presentation.shippingscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shipping.domain.module.Product
import com.example.shipping.domain.repo.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShippingViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    val getAllProducts = MutableSharedFlow<Flow<List<Product>>>(1)

    private val _getProduct: MutableStateFlow<Product?> = MutableStateFlow(null)
    val getProduct = _getProduct.asSharedFlow()

    fun getAllProducts() {
        viewModelScope.launch {
            getAllProducts.emit(repository.getAllProducts())
        }
    }

    fun getProduct(id: Long) {
        viewModelScope.launch {
            _getProduct.emit(repository.getProduct(id))
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

    fun removeAllProducts(products: List<Product>) {
        viewModelScope.launch {
            repository.removeAllProducts(products)
        }
    }

    fun updateProduct(product: Product) {
        viewModelScope.launch {
            repository.updateProduct(product)
        }
    }
}