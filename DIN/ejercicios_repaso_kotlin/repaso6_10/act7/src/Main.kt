fun calcularMedia(nota1: Double, nota2: Double, nota3: Double): Double {
    return (nota1 + nota2 + nota3) / 3.0
}

fun calificacion(media: Double): String {
    if (media < 5.0) {
        return "Suspenso"
    } else if (media < 7.0) {
        return "Aprobado"
    } else if (media < 9.0) {
        return "Notable"
    } else {
        return "Sobresaliente"
    }
}

fun estaAprobado(media: Double): Boolean = media >= 5.0

fun main() {
    println("Introduce el numero de alumnos: ")
    val numeroAlumnos: Int = readln().trim().toInt()

    var sumaMedias: Double = 0.0
    var contadorAprobados: Int = 0

    var mejorMedia: Double = -1.0
    var mejorAlumno: String = ""

    for (i in 1..numeroAlumnos) {
        println("Nombre: ")
        val nombre: String = readln().trim()

        println("Nota 1: ")
        val nota1: Double = readln().toDouble()

        println("Nota 2: ")
        val nota2: Double = readln().toDouble()

        println("Nota 3: ")
        val nota3: Double = readln().toDouble()

        val mediaAlumno: Double = calcularMedia(nota1, nota2, nota3)
        val estadoCalificacion: String = calificacion(mediaAlumno)

        println("Nombre: $nombre")
        println("Media: $mediaAlumno")
        println("Calificacion: $estadoCalificacion")

        sumaMedias += mediaAlumno

        if (estaAprobado(mediaAlumno)) {
            contadorAprobados++
        }

        if (mediaAlumno > mejorMedia) {
            mejorMedia = mediaAlumno
            mejorAlumno = nombre
        }
    }

    val mediaGrupo: Double = sumaMedias / numeroAlumnos

    println("RESUMEN DEL GRUPO")
    println("Media del grupo: $mediaGrupo")
    println("Numero de aprobados: $contadorAprobados")
    println("Mejor alumno: $mejorAlumno con una media de $mejorMedia")

}