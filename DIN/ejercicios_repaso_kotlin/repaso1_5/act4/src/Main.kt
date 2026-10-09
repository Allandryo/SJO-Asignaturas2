fun main () {
    fun calcularPagoHorasExtra(horasExtra : Int, precioHora : Double): Double{
        val precioHorasExtra = horasExtra * (precioHora * 1.5)
        return precioHorasExtra
    }
    fun porcentajeRetencion(salarioBruto : Double): Double{
        when(salarioBruto){
            in Int.MIN_VALUE..500 -> {
                println("hola")
            }
        }
    }
    fun mostrarNomina(){

    }

    var salarioBruto : Double

    println("Nombre empleado:")
    val nombreEmpleado : String = readln()

    println("Horas trabajadas:")
    val horasTrabajadas : Int = readln().toInt()

    println("Precio hora:")
    val precioHora : Double = readln().toDouble()

    if (horasTrabajadas > 40){
        val horasExtra : Int = horasTrabajadas - 40
        salarioBruto = ((horasTrabajadas - horasExtra)*precioHora) + (calcularPagoHorasExtra(horasExtra, precioHora))
        println(salarioBruto)
    } else {
        salarioBruto = horasTrabajadas * precioHora
    }
}