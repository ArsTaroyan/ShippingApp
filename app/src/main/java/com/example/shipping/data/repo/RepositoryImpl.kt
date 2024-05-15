package com.example.shipping.data.repo

import com.example.shipping.data.source.dao.ProductDao
import com.example.shipping.domain.module.Product
import com.example.shipping.domain.repo.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val productDao: ProductDao
) : Repository {
    override fun getAllProducts(): Flow<List<Product>> = productDao.getAllProducts()

    override suspend fun addProduct(product: Product) {
        productDao.addProduct(product)
    }

    override suspend fun removeProduct(product: Product) {
        productDao.removeProduct(product)
    }

    override suspend fun removeAllProducts() {
        productDao.removeAllProduct()
    }

    override suspend fun updateProduct(product: Product) {
        productDao.updateProduct(product)
    }
}