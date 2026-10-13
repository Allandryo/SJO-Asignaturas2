fun main(){

    fun tarifaZona(zona: Int): Double{
        when(zona){
            1 -> return 1.20
            2 -> return 2.50
            3 -> return 5.00
            else -> return 0.0
        }
    }

    fun calcularEnvio(peso: Double, tafifaKg: Double, urgente: Boolean, seguro: Boolean = false): Double {
        var precioTotal : Double = peso * tafifaKg

        if (urgente && !seguro){
            precioTotal = (precioTotal * 1.30)
        }else if (urgente && seguro){
            precioTotal = (precioTotal * 1.30) + 4.0
        }
        return precioTotal
    }

    println("Numero de envios")
    val numeroEnvios : Int = readln().ifBlank { "0" }.toInt()

    var facturacion : Double = 0.0
    var envioInternacional : Int = 0

    repeat(numeroEnvios){

        println("Codigo del envio:")
        val codigoEnvio : String = readln()

        println("Peso del envio:")
        val peso : Double = readln().ifBlank { "0.0" }.toDouble()

        var zonaEnvio : Int
        println("Zona de envio")
        do {
            zonaEnvio = readln().ifBlank{ "0" }.toInt()
        } while (zonaEnvio !in 1..3)
        if (zonaEnvio == 3) envioInternacional++

        println("Urgente: (S/N)")
        var urgente : Boolean = false
        val esUrgente : String = readln()
        if (esUrgente == "S" || esUrgente == "s"){
            urgente = true
        }

        println("Seguro: (S/N)")
        var seguro : Boolean = false
        val esSeguro : String = readln()
        if (esUrgente == "S" || esUrgente == "s"){
            seguro = true
        }

        val precioFinal : Double = calcularEnvio(peso, tarifaZona(zonaEnvio), urgente, seguro)
        facturacion += precioFinal

        println(".....Datos de envio.....")
        println("Codigo del envio: $codigoEnvio")
        println("Peso del envio: $peso")
        println("Zona de envio: ${when(zonaEnvio) {1 -> "Local" 2 -> "Nacional" 3 -> "Internacional" else -> "Zona erronea"}}")
        println("Precio del envio: $precioFinal")

    }
}