package com.example.shipping.domain.module

data class ItemProduct(
    val id: Long,
    val img: String,
    val description: String,
    val price: Double,
    val count: Int
)