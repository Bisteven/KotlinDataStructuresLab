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

fun reto9() {
    println("=========Reto 9==========")
    val paises = mapOf("CO" to "Colombia", "MX" to "México", "US" to "Estados Unidos")
    for ((iso, nombre) in paises) {
        println("El código [$iso] pertenece a [$nombre]")
    }
}


fun reto10() {
    println("=========Reto 10==========")
    val empleados = mutableListOf("Ana", "Luis", "María", "Juan", "Sofía", "Pedro", "Valeria")
    val k = 2
    val rotado = empleados.drop(k) + empleados.take(k)
    println("Turno original: $empleados")
    println("Turno rotado $k posiciones: $rotado")
}

fun reto11() {
    println("=========Reto 11==========")
    val objetos = listOf("Zapatos" to 2, "Camisa" to 1, "Pantaloneta" to 1, "Libro" to 2)
    val agrupados = mutableMapOf<Int, MutableList<String>>()
    for ((nombre, peso) in objetos) {
        agrupados.getOrPut(peso) { mutableListOf() }.add(nombre)
    }
    agrupados.forEach { (peso, items) -> println("$peso kg: $items") }
}
fun reto12() {
    println("=========Reto 12==========")
    val ruta = listOf(1, 2, 3, 2, 1)
    var esPalindromo = true
    for (i in ruta.indices) {
        if (ruta[i] != ruta[ruta.size - 1 - i]) { esPalindromo = false; break }
    }
    println("La ruta es espejo: $esPalindromo")
}
fun reto13() {
    println("=========Reto 13==========")
    val paquetes = (1..50).toList()
    val lotes = paquetes.chunked(10)
    lotes.forEachIndexed { i, lote -> println("Camión ${i + 1}: $lote") }
}
fun reto14() {
    println("=========Reto 14==========")
    val tickets = listOf(101, 202, 101, 303, 202, 404, 303)
    val unico = tickets.groupingBy { it }.eachCount().filter { it.value == 1 }.keys.first()
    println("Primer ticket único: $unico")
}
fun reto15() {
    println("=========Reto 15==========")
    val precios = mapOf("Leche" to 3200, "TV" to 1500000, "Pan" to 2500, "Laptop" to 3200000)
    val conIva = precios.mapValues { (_, precio) ->
        if (precio > 50000) (precio * 1.19).toInt() else precio
    }
    conIva.forEach { (p, v) -> println("$p: $$v") }
}
fun reto16() {
    println("=========Reto 16==========")
    val sensores = mutableListOf(1, 3, 5, 6, 9, 12, 15, 7, 18)
    sensores.removeIf { it % 3 == 0 }
    println("Sensores activos: $sensores")
}
fun reto17() {
    println("=========Reto 17==========")
    val almacen = arrayOf(
        intArrayOf(1, 2, 3, 4), intArrayOf(5, 6, 7, 8),
        intArrayOf(9, 10, 11, 12), intArrayOf(13, 14, 15, 16)
    )
    var sumaPrincipal = 0; var sumaSecundaria = 0; val n = 4
    for (i in 0 until n) {
        sumaPrincipal += almacen[i][i]
        sumaSecundaria += almacen[i][n - 1 - i]
    }
    println("Diagonal principal: $sumaPrincipal")
    println("Diagonal secundaria: $sumaSecundaria")
}
fun reto18() {
    println("=========Reto 18==========")
    val chef1 = mapOf("harina" to 2.0, "sal" to 0.5, "azúcar" to 1.0)
    val chef2 = mapOf("harina" to 1.5, "mantequilla" to 0.3, "sal" to 0.2)
    val fusion = (chef1.keys + chef2.keys).toSet().associateWith { ing ->
        (chef1[ing] ?: 0.0) + (chef2[ing] ?: 0.0)
    }
    fusion.forEach { (ing, cant) -> println("$ing: $cant tazas") }
}
