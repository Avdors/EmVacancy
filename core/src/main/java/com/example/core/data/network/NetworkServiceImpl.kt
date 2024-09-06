package com.example.core.data.network

import com.example.core.domain.model.ResponseData
import com.example.core.domain.repository.ApiResponseRepository
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.url
import io.ktor.client.statement.bodyAsText
import kotlinx.serialization.json.Json

class NetworkServiceImpl(private val client: HttpClient) : ApiService {


    override suspend fun getData(): List<ResponseData> {
        val json = client.get {
            url("https://drive.usercontent.google.com/u/0/uc?id=1z4TbeDkbfXkvgpoJprXbN85uCcD7f00r&export=download")
        }.bodyAsText()
        return Json.decodeFromString<ResponseData>(json) as List<ResponseData>
    }

}