package src

fun reto1(){
    println("=========Reto 1==========")
    val gastos = doubleArrayOf(15000.0, 8000.0, 22000.0, 5000.0, 17000.0,
        9500.0, 31000.0, 4000.0, 12000.0, 25000.0,
        7000.0, 18000.0, 11000.0, 6000.0, 20000.0)
    var menor = gastos[0]
    var mayor = gastos[0]
    var total = 0.0

    for (gasto in gastos) {
        total = total + gasto
        if (gasto > mayor) mayor = gasto
        else if (gasto < menor) menor = gasto
    }

    val promedio = total / gastos.size
    println("Total: $total")
    println("Promedio diario: $promedio")
    println("Gasto más alto: $mayor")
    println("Gasto más bajo: $menor")
}

fun reto2(){
    println("=========Reto 2==========")
    val empleados = listOf(
        Pair("carlos", 28), Pair("lucía", 35), Pair("jorge", 42),
        Pair("ana", 25), Pair("sofía", 31))
        .filter { it.second > 30 }
        .map { it.first.uppercase() }
    println("Los empleados con más de 30 años son: $empleados")
}

fun reto3() {
    println("=========Reto 3==========")
    val numeros = listOf(
        "3105202558", "3105202558", "3144585100", "3215275683", "3136045753",
        "3117239003", "3215275683", "1234567890", "1234567890", "3124345812",
        "3491203918", "3491203918", "3581029398", "3214567890", "3677789711",
        "3147474811", "3124678912", "3112453123", "3147474811", "3147474811"
    ).toSortedSet()
    println("La lista ordenada y sin repetir es: $numeros")
}

fun reto4() {
    println("=========Reto 4==========")
    val carrito = listOf(
        "Arroz", "Huevo", "Coca-cola", "Huevo",
        "Arroz", "Cilantro", "Huevo", "Arroz"
    )
    val productos = mutableMapOf<String, Int>()
    for (producto in carrito) {
        productos[producto] = (productos[producto] ?: 0) + 1
    }
    for ((key, value) in productos) {
        println("Hay $value unidades de $key en el carrito")
    }
}
fun reto5() {
    println("=========Reto 5==========")
    val urls = arrayOf("inicio.com", "noticias.com", "tienda.com", "perfil.com", "contacto.com")
    val invertido = Array(urls.size) { "" }
    for (i in urls.indices) {
        invertido[i] = urls[urls.size - 1 - i]
    }
    println("Historial invertido:")
    invertido.forEach { println("  → $it") }
}

fun reto6() {
    println("=========Reto 6==========")
    val persona1 = setOf("fútbol", "lectura", "cocina", "viajes")
    val persona2 = setOf("música", "lectura", "viajes", "cine")
    val comunes = persona1.intersect(persona2)
    val exclusivos = persona1.subtract(persona2)
    println("Pasatiempos en común: $comunes")
    println("Exclusivos de persona1: $exclusivos")
}
fun reto7() {
    println("=========Reto 7==========")
    val despensa = mutableMapOf("Arroz" to 5, "Aceite" to 2, "Sal" to 1)

    fun consumir(producto: String, cantidad: Int) {
        val actual = despensa[producto] ?: return println("$producto no existe")
        val restante = actual - cantidad
        if (restante <= 0) {
            despensa.remove(producto)
            println("⚠ $producto agotado y eliminado")
        } else {
            despensa[producto] = restante
            println("$producto: quedan $restante unidades")
        }
    }

    consumir("Arroz", 3)
    consumir("Sal", 2)
    println("Despensa: $despensa")
}



fun reto8() {
    println("=========Reto 8==========")
    val notas = listOf(
        Pair(4.5, 0.30), Pair(3.8, 0.40), Pair(4.2, 0.30)
    )
    val definitiva = notas.sumOf { (nota, porcentaje) -> nota * porcentaje }
    println("Nota final definitiva: ${"%.2f".format(definitiva)}")
}

