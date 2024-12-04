package com.example.data

import com.example.domain.Product

data class Cabage(
    override val name: String = "Cabage",
    override val count: Int
): Product
