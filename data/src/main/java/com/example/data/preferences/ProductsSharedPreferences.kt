package com.example.data.preferences

import android.content.Context
import android.content.SharedPreferences

class ProductsSharedPreferences {
    private val DATE_KEY = "data"

    companion object{
        private lateinit var preferences: SharedPreferences
        private lateinit var editor: SharedPreferences. Editor

        fun initPreferences(context: Context) {
            preferences = context.getSharedPreferences("Products", Context.MODE_PRIVATE)
            editor = preferences.edit()
        }
    }

    fun saveDate(date: String) {
        editor.putString(DATE_KEY, date)
        editor.apply()
    }

    fun getLastDate(): String {
        return preferences.getString(DATE_KEY, "") ?: ""
    }
}