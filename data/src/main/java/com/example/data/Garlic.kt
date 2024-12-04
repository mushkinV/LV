package com.example.data

import com.example.domain.Product

data class Garlic(
    override val name: String = "Garlic",
    override val count: Int
): Product

