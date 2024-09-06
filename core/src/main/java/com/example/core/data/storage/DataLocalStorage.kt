package com.example.core.data.storage

import android.content.SharedPreferences

class DataLocalStorage(private val sharedPreferences: SharedPreferences) {

    fun saveData(json: String) {
        sharedPreferences.edit().putString("saved_data", json).apply()
    }

    fun loadData(): String? {
        return sharedPreferences.getString("saved_data", null)
    }
}