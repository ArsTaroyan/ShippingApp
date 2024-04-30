package com.example.shipping.extension

import com.google.gson.Gson

fun <T> T.convertGsonToString(): String = Gson().toJson(this)

inline fun <reified T> String.convertStringToGson(): T = Gson().fromJson(this, T::class.java)