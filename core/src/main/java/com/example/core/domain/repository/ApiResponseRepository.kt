package com.example.core.domain.repository

import com.example.core.domain.model.ResponseData

interface ApiResponseRepository {

    suspend fun getData(): List<ResponseData>

    suspend fun saveData(data: Any)

}