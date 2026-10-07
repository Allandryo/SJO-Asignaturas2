fun main() {
    fun calcularSubtotal(precio : Double, unidades : Int): Double {
        val subtotal = precio * unidades
        return subtotal
    }

    fun calcularDescuento(subtotal : Double, esHabitual : Boolean, porcentaje : Double = 0.10): Double{
        return if (esHabitual){
            subtotal * (1 - porcentaje)
        } else {
            subtotal
        }

    }

    fun mostrarVenta(nameProduct : String, subtotal : Double, precioFinal : Double, esHabitual : Boolean){
        println("Nombre producto: $nameProduct")
        println("Importe sin descuento: $subtotal")
        println("Descuento: ${if (esHabitual) "10%" else "0%"}")
        println("Precio Final: $precioFinal")

        print("Presiona Enter para continuar...")
        readln()
    }

    fun ventasTotales(numeroVentas : Int, numeroVentasDescuento : Int, sumVentas : Double){
        println("Recaudacion Total: $sumVentas")
        println("Ventas con descuento: $numeroVentasDescuento")
        println("Precio medio de venta ${sumVentas / numeroVentas}")
    }

    var nameProduct : String
    var unitPrice : Double
    var unitNumbers : Int
    var esHabitual : Boolean

    var countVentas : Int = 0
    var countVentasDescuento : Int = 0
    var sumVentas : Double = 0.0

    print("Cuantas ventas se introduciran?")
    val numeroVentas: Int = readln().toInt()

    repeat(numeroVentas){
        print("Nombre del producto: ")
        nameProduct = readln()

        print("Precio por unidad: ")
        unitPrice = readln().toDouble()

        print("Numero de unidades: ")
        unitNumbers = readln().toInt()

        println("Es cliente habitual?")
        esHabitual = false
        val habitual : String = readln().lowercase()
        if (habitual == "si" || habitual == "s"){esHabitual = true}

        val subtotal : Double = calcularSubtotal(unitPrice, unitNumbers)
        val precioFinal : Double = calcularDescuento(subtotal, esHabitual)

        countVentas++
        sumVentas += precioFinal
        if (esHabitual){
            countVentasDescuento++
        }

        mostrarVenta(nameProduct, subtotal, precioFinal, esHabitual)
    }
    ventasTotales(countVentas, countVentasDescuento, sumVentas)
}