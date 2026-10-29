fun calcularSubtotal(cantidad: Int, precio: Double): Double {
    return cantidad * precio
}

fun porcentajeIva(tipo: Int): Double {
    val porcentaje: Double = when (tipo) {
        1 -> 0.04
        2 -> 0.10
        3 -> 0.21
        else -> 0.0
    }
    return porcentaje
}

fun calcularTotalLinea(subtotal: Double, iva: Double): Double {
    return subtotal + iva
}

fun main() {
    println("Introduce el numero de mesa:")
    val numeroMesa: Int = readln().toInt()

    println("Introduce cuantas lineas tendra el pedido:")
    val numeroLineas: Int = readln().toInt()

    var totalPedido: Double = 0.0

    for (indice in 0 until numeroLineas) {
        println("--- Linea $indice ---")

        println("Descripcion del producto:")
        val descripcion: String = readln()

        println("Cantidad:")
        val cantidad: Int = readln().toInt()

        println("Precio unitario:")
        val precio: Double = readln().toDouble()

        println("Tipo de IVA (1 = 4 %, 2 = 10 %, 3 = 21 %):")
        val tipoIva: Int = readln().toInt()

        val subtotal: Double = calcularSubtotal(cantidad, precio)
        val porcentaje: Double = porcentajeIva(tipoIva)
        val importeIva: Double = subtotal * porcentaje
        val totalLinea: Double = calcularTotalLinea(subtotal, importeIva)

        println("Detalle de la linea: $descripcion")
        println("Subtotal: $subtotal")
        println("IVA: $importeIva")
        println("Total de la linea: $totalLinea")

        totalPedido += totalLinea
    }

    println("La mesa dispone de un vale de descuento? (S/N):")
    val respuestaVale: String = readln().lowercase()
    val tieneVale: Boolean = respuestaVale == "s"

    val descuento: Double = if (tieneVale && totalPedido > 50.0) {
        totalPedido * 0.05
    } else {
        0.0
    }

    val totalFinal: Double = totalPedido - descuento

    println("--- RESUMEN DEL PEDIDO ---")
    println("Numero de mesa: $numeroMesa")
    println("Total antes del descuento: $totalPedido")
    println("Descuento: $descuento")
    println("Total final: $totalFinal")

    for (i in 3 downTo 1) {
        println(i)
    }
    println("Pedido enviado a cocina")
}