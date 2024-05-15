package com.example.shipping.domain.repo

import com.example.shipping.domain.module.Product
import kotlinx.coroutines.flow.Flow

interface Repository {
    fun getAllProducts(): Flow<List<Product>>
    suspend fun addProduct(product: Product)
    suspend fun removeProduct(product: Product)
    suspend fun removeAllProducts()
    suspend fun updateProduct(product: Product)
}