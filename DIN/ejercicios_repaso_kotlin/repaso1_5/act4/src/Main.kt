fun main () {
    fun calcularPagoHorasExtra(horasExtra : Int, precioHora : Double): Double{
        val precioHorasExtra = horasExtra * (precioHora * 1.5)
        return precioHorasExtra
    }
    fun porcentajeRetencion(salarioBruto : Double): Double{
        when(salarioBruto){
            in Double.MIN_VALUE..500.0 -> {return salarioBruto * 0.05}
            in 501.0..999.99 -> {return salarioBruto * 0.1}
            in 1000.00..Double.MAX_VALUE -> {return salarioBruto * 0.15}
            else -> {return 0.0}
        }

    }
    fun mostrarNomina(horasTrabajadas : Int, horasExtras : Int?, salarioBruto : Double, salarioRetenido : Double){
        println("......Nomina......")
        println("Horas trabajadas: $horasTrabajadas")
        println("Horas extra: $horasExtras")
        println("Salario bruto: $salarioBruto")
        println("Porcentaje retenido: ${if (salarioBruto < 500.0){"5%"} else if (salarioBruto < 999.99){"10%"} else {"15%"}}")
        println("Salario devengado: $salarioRetenido")
        println("Salario neto: ${salarioBruto - salarioRetenido}")
    }

    var salarioBruto : Double
    var horasExtra : Int = 0

    println("Nombre empleado:")
    val nombreEmpleado : String = readln()

    println("Horas trabajadas:")
    val horasTrabajadas : Int = readln().ifBlank { 0 }.toString().toInt()

    println("Precio hora:")
    val precioHora : Double = readln().toDouble()


    if (horasTrabajadas > 40){
        horasExtra = horasTrabajadas - 40
        salarioBruto = ((horasTrabajadas - horasExtra)*precioHora) + (calcularPagoHorasExtra(horasExtra, precioHora))
        mostrarNomina(horasTrabajadas, horasExtra, salarioBruto,porcentajeRetencion(salarioBruto))
    } else {
        salarioBruto = horasTrabajadas * precioHora
        mostrarNomina(horasTrabajadas, horasExtra, salarioBruto,porcentajeRetencion(salarioBruto))
    }
}