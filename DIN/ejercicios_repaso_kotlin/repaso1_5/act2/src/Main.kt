//Actividad 2
fun main() {

    fun nombreAcreditacion(tipo : Int): String{
        val nameAcreditacion = when (tipo) {
            1 -> "Visitante"
            2 -> "Profesional"
            3 -> "Organizacion"
            else -> "Sin acreditacion"
        }
        return nameAcreditacion
    }

    fun puedeAcceder(edad : Int, tipo : Int, invitacion : Boolean): Boolean{
        return if (edad in 18..120 && tipo in 2..3 || invitacion){
            true
        } else {
            false
        }
    }

    var countAutorizado : Int = 0
    var countDenegado : Int = 0

    print("Indica el numero de entradas a revisar: ")
    val numAsistentes : Int = readln().toInt()


    for (i in 1..numAsistentes){
        print("Nombre asistente $i: ")
        val nameAsistente : String = readln()

        print("Edad asistente: ")
        val edadAsistente : Int = readln().toInt()

        if (edadAsistente !in 0..120){
            println("Edad no valida")
            continue
        }

        println("Invitacion especial: (true/false)")
        val invitacion : Boolean = readln().toBoolean()

        print("Tipo de acreditacion: ")
        val tipoAcreditacion : Int = readln().toInt()

        println(nombreAcreditacion(tipoAcreditacion))

        if (puedeAcceder(edadAsistente, tipoAcreditacion, invitacion)){
            println("AUTORIZADO")
            countAutorizado++
        } else {
            println("DENEGADO")
            countDenegado++
        }
    }
    println("Autorizados: $countAutorizado | Denegados: $countDenegado")
}