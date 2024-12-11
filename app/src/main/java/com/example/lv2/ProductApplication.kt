package com.example.lv2

import android.app.Application
import com.example.data.db.AppDatabase
import com.example.data.preferences.ProductsSharedPreferences

class ProductApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        AppDatabase.initDB(applicationContext)
        ProductsSharedPreferences.initPreferences(applicationContext)
    }
}