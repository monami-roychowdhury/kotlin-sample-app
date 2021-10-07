package com.example.sampleapp.api

import com.example.sampleapp.data.Data
import com.example.sampleapp.data.Meta

data class ApiResponse(
    val data: List<Data>,
    val meta: Meta
)