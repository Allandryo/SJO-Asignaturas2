fun clasificarProduccion(unidades: Int): String {
    if (unidades < 50) {
        return "BAJA"
    } else if (unidades <= 100) {
        return "NORMAL"
    } else {
        return "ALTA"
    }
}

fun mediaProduccion(total: Int, franjas: Int): Double {
    return total.toDouble() / franjas
}

fun main() {
    var totalUnidades: Int = 0
    var franjasRegistradas: Int = 0

    for (hora in 8..20 step 2) {
        println("Introduce las unidades producidas a las $hora:00:")
        val unidades: Int = readln().toInt()

        if (unidades == -1) {
            println("Lectura no disponible")
            continue
        }

        if (unidades == -99) {
            println("Línea detenida")
            break
        }

        totalUnidades += unidades
        franjasRegistradas += 1

        val clasificacion: String = clasificarProduccion(unidades)
        println("Clasificacion de la franja: $clasificacion")
    }

    println("Produccion acumulada: $totalUnidades")

    val media: Double = mediaProduccion(totalUnidades, franjasRegistradas)
    println("Produccion media por franja registrada: $media")
}