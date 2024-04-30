package com.example.shipping.data.source.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.shipping.domain.module.Product
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addProduct(product: Product)

    @Delete
    suspend fun removeProduct(product: Product)

    @Delete
    suspend fun removeAllProduct(products: List<Product>)

    @Update
    suspend fun updateProduct(product: Product)

    @Query("SELECT * FROM products")
    fun getAllProducts(): Flow<List<Product>>

    @Query("SELECT * FROM products WHERE product_id = :id")
    suspend fun getProduct(id: Long): Product?
}