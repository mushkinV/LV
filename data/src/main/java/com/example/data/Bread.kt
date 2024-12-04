package com.example.data

import com.example.domain.Product

data class Bread(
    override val name: String = "Bread",
    override val count: Int
): Product
