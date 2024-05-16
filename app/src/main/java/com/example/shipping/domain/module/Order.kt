package com.example.shipping.domain.module

data class Order(
    val id: Long,
    val date: String,
    val total: Int,
    val status: String,
    val products: List<Product>
)
