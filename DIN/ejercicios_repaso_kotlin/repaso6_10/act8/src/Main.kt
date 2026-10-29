fun ingresar(saldo: Double, cantidad: Double): Double {
    if (cantidad > 0.0) {
        val nuevoSaldo: Double = saldo + cantidad
        mostrarSaldo(nuevoSaldo)
        return nuevoSaldo
    } else {
        println("Error: La cantidad a ingresar debe ser positiva.")
        return saldo
    }
}

fun retirar(saldo: Double, cantidad: Double): Double {
    if (cantidad <= 0.0) {
        println("No se puede realizar la retirada: la cantidad debe ser positiva.")
        return saldo
    } else if (cantidad > saldo) {
        println("No se puede realizar la retirada: la cantidad supera el saldo disponible.")
        return saldo
    } else {
        val nuevoSaldo: Double = saldo - cantidad
        mostrarSaldo(nuevoSaldo)
        return nuevoSaldo
    }
}

fun mostrarSaldo(saldo: Double) {
    println("Saldo actual: $saldo")
}

fun main() {
    println("Introduce el saldo inicial:")
    var saldo: Double = readln().toDouble()

    var opcion: Int

    do {
        println("--- MENU BANCARIO ---")
        println("1 = Consultar saldo")
        println("2 = Ingresar")
        println("3 = Retirar")
        println("0 = Salir")
        println("Elige una opcion:")

        opcion = readln().toInt()

        when (opcion) {
            1 -> {
                mostrarSaldo(saldo)
            }
            2 -> {
                println("Introduce la cantidad a ingresar:")
                val cantidadIngreso: Double = readln().toDouble()
                saldo = ingresar(saldo, cantidadIngreso)
            }
            3 -> {
                println("Introduce la cantidad a retirar:")
                val cantidadRetirada: Double = readln().toDouble()
                saldo = retirar(saldo, cantidadRetirada)
            }
            0 -> {
                println("Cerrando el programa. Saldo final: $saldo")
            }
            else -> {
                println("Error: Opcion desconocida. Intentalo de nuevo.")
            }
        }
    } while (opcion != 0)
}