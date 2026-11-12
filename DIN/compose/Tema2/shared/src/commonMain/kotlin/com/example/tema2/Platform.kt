package com.example.tema2

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform