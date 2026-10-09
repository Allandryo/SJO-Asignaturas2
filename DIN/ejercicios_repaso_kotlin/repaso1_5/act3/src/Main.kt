fun main() {
    fun tarifaMinuto(tipo : Int): Double{
        val tarifa : Double = when (tipo){
            1 -> 0.02
            2 -> 0.035
            3 -> 0.05
            else -> 0.0
        }
        return tarifa
    }

    fun clasificarEstancia(minutos : Int): String{
        val estancia : String = when (minutos){
            in 0..60 -> "Corta"
            in 61..180 -> "Media"
            in 181..360 -> "Larga"
            in 361..Int.MAX_VALUE -> "Muy larga"
            else -> "Estancia erronea"
        }
        return estancia
    }
    fun calcularImporte(minutos: Int, tarifa: Double): Double{
        var subtotal : Double
        if (minutos < 240) {
            subtotal = (minutos * tarifa) + 0.50
        } else {
            subtotal = (minutos * tarifa) + 2
        }
        return subtotal
    }

    var vehiculosProcesados : Int = 0
    var recaudacionTotal : Double = 0.0

    while (true){
        print("Matricula: ")
        val matricula : String = readln().lowercase()
        if(matricula == "fin") break

        print("Minutos estacionado: ")
        val minutosEstacionado : Int = readln().toInt()

        print("Tipo de vehiculo: ")
        val tipoVehiculo : Int = readln().toInt()
        val precioFinal : Double = calcularImporte(minutosEstacionado, tarifaMinuto(tipoVehiculo))

        println("Matricula: $matricula | Estancia: ${clasificarEstancia(minutosEstacionado)} | Precio: $precioFinal")
        print("Pulse enter para continuar...")
        readln()
        recaudacionTotal += precioFinal
        vehiculosProcesados++
    }
    println("Vehiculos procesados: $vehiculosProcesados | Recaudacion total: $recaudacionTotal")
}