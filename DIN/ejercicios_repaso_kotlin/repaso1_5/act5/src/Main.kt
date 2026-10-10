fun main() {
    fun textoValoacion(valoracion : Int): String {
        when (valoracion) {
            0 -> { return "¡Bye!"}
            1 -> { return "Muy mala"}
            2 -> { return "Mala"}
            3 -> { return "Correct"}
            4 -> { return "Buena"}
            5 -> { return "Excellent"}
            else -> { return "Valoracion no valida"}
        }
    }
    fun esPositiva(valoracion : Int): Boolean{
        return if (valoracion in 4..5) true else false
    }

    var numeroValoraciones: Int = 0
    var sumaTotal: Int = 0
    var numeroValoracionesPositivas: Int = 0

    do {
        println("Valoracion: ")
        val valoracion: Int = readln().toInt()

        if (valoracion !in 0..5) continue
        println(textoValoacion(valoracion))

        if (esPositiva(valoracion)) numeroValoracionesPositivas++

        numeroValoraciones++
        sumaTotal += valoracion

    } while (valoracion != 0)
    println("Valoraciones totales: $numeroValoraciones")
    println("Suma de valoraciones: $sumaTotal")
    println("Valoraciones positivas: $numeroValoracionesPositivas")
    if (numeroValoraciones < 2){
        println("No hay valoraciones suficientes")
    } else {
        println("Media de valoraciones: ${sumaTotal / numeroValoraciones}")
    }

}
