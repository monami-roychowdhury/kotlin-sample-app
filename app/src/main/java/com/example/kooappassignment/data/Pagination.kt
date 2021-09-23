package com.example.kooappassignment.data

import com.example.kooappassignment.data.Links

data class Pagination(
    val limit: Int,
    val links: Links,
    val page: Int,
    val pages: Int,
    val total: Int
)