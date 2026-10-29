package com.example.prueba_desktop

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform