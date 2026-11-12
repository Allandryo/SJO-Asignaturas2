package com.example.tema2

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = {println("hola mundo")},
        title = "tema2",
    ) {
        App()
    }
}