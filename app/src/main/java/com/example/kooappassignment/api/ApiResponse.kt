package com.example.kooappassignment.api

import com.example.kooappassignment.data.Data
import com.example.kooappassignment.data.Meta

data class ApiResponse(
    val data: List<Data>,
    val meta: Meta
)