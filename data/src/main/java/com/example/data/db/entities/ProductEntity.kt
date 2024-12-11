package com.example.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domain.Product


@Entity(tableName = "product")
data class ProductEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    override val id: Int,

    @ColumnInfo(name = "titly")
    override val title: String,

    @ColumnInfo(name = "price")
    override val price: Double
) : Product
