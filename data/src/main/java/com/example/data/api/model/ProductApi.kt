package com.example.data.api.model

import com.example.data.db.entities.ProductEntity
import com.example.domain.Product
import com.squareup.moshi.Json

data class ProductApi(
    @Json(name = "id")
    override val id: Int,

    @Json(name = "title")
    override val title: String,

    @Json(name = "price")
    override val price: Double
) : Product {
    fun toProductEntity() : ProductEntity{
        return ProductEntity(id, title, price)
    }
}
