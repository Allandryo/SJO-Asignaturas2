package com.example.prueba_desktop

import androidx.compose.material.Text
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Util.println

fun main() = application {
    Window(
        onCloseRequest = {
            println("Hola mundo")
                         },
        title = "prueba_desktop",
    ) {
        App()
        Text("hola")
    }
}