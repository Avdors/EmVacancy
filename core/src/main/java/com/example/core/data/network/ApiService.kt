package com.example.core.data.network

import com.example.core.domain.model.ResponseData

interface ApiService {

    suspend fun getData(): List<ResponseData>

}