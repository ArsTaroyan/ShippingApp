package com.example.shipping.domain.module

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("products")
data class Product(
    @PrimaryKey(autoGenerate = true) val product_id: Long,
    @ColumnInfo("product_img") var product_img: String,
    @ColumnInfo("product_description") var product_description: String,
    @ColumnInfo("product_price") var product_price: Long,
    @ColumnInfo("product_count") var product_count: Int
)
