package com.example.data

import com.example.data.api.ProductClient
import com.example.domain.Product
import com.example.domain.Repository

class RepositoryImpl : Repository {
    override suspend fun getProducts() : List<Product> {
        return ProductClient.client.tefchProductList()
    }
}