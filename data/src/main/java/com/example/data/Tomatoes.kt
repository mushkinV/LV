package com.example.data

import com.example.domain.Product

data class Tomatoes(
    override val name: String = "Tomatoes",
    override val count: Int
): Product

