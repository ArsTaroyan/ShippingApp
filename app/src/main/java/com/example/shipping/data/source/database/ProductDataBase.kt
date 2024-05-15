package com.example.shipping.data.source.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.shipping.data.source.dao.ProductDao
import com.example.shipping.domain.module.Product

@Database(
    entities = [
        Product::class
    ],
    version = 1,
    exportSchema = false
)
abstract class ProductDataBase : RoomDatabase() {
    abstract fun productDao(): ProductDao
}