package com.example.data

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.data.api.ProductClient
import com.example.data.db.AppDatabase
import com.example.data.preferences.ProductsSharedPreferences
import com.example.domain.Product
import com.example.domain.Repository
import java.time.LocalDate

class RepositoryImpl : Repository {
    private val db = AppDatabase.db
    private val productsSharedPreferences = ProductsSharedPreferences()

    private suspend fun updateProductsFromApi(): List<Product> {
        val data = ProductClient.client.fetchProductList()
        val converterData = data.map { it.toProductEntity() }
        db.productDao().insertAll(converterData)
        return converterData
    }
    @RequiresApi(Build.VERSION_CODES.O)
    private fun getCurrentDay0fMonth(): String{
        return  LocalDate.now().dayOfMonth.toString()
    }
    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getProducts(): List<Product> {
        val currentDayOfMonth = getCurrentDay0fMonth()
        val lastUpdateDay = productsSharedPreferences.getLastDate()

        return if (lastUpdateDay == currentDayOfMonth){
            db.productDao().getAll()
        } else {
            productsSharedPreferences.saveDate(currentDayOfMonth)
            updateProductsFromApi()
        }

    }



}