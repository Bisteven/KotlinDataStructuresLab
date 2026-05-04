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
fun reto19() {
    println("=========Reto 19==========")
    val apps = mutableListOf(
        Pair("WhatsApp", 4.3), Pair("TikTok", 4.7),
        Pair("Maps", 4.5), Pair("Gmail", 4.1)
    )
    for (i in apps.indices) {
        for (j in 0 until apps.size - 1 - i) {
            if (apps[j].second < apps[j + 1].second) {
                val temp = apps[j]; apps[j] = apps[j + 1]; apps[j + 1] = temp
            }
        }
    }
    println("Top 10 apps:")
    apps.take(10).forEachIndexed { i, (app, stars) -> println("${i+1}. $app ★$stars") }
}
fun reto20() {
    println("=========Reto 20==========")
    val agenda1 = listOf("Ana", "Carlos", "Elena")
    val agenda2 = listOf("Beatriz", "Diana", "Fernando")
    val resultado = mutableListOf<String>()
    var i = 0; var j = 0
    while (i < agenda1.size && j < agenda2.size) {
        if (agenda1[i] <= agenda2[j]) resultado.add(agenda1[i++])
        else resultado.add(agenda2[j++])
    }
    while (i < agenda1.size) resultado.add(agenda1[i++])
    while (j < agenda2.size) resultado.add(agenda2[j++])
    println("Agenda maestra: $resultado")
}
fun reto21() {
    println("=========Reto 21==========")
    fun esPrimo(n: Int): Boolean {
        if (n < 2) return false
        for (i in 2..Math.sqrt(n.toDouble()).toInt()) if (n % i == 0) return false
        return true
    }
    val pisos = Array(100) { it + 1 }.filter { esPrimo(it) }
    println("Pisos con mantenimiento especial: $pisos")
}
fun reto22() {
    println("=========Reto 22==========")
    val pila = mutableListOf<String>()
    fun push(plato: String) { pila.add(plato); println("Agregado: $plato") }
    fun pop() = if (pila.isNotEmpty()) pila.removeLast().also { println("Lavado: $it") }
    else println("No hay platos")
    push("Plato1"); push("Plato2"); push("Plato3")
    pop(); pop()
    println("Pila restante: $pila")
}
fun reto23() {
    println("=========Reto 23==========")
    val calorias = listOf(1800, 2100, 1950, 2200, 1700)
    val hoy = calorias.last()
    val anteriores = calorias.dropLast(1)
    val promedio = anteriores.average()
    val diferencia = hoy - promedio
    println("Hoy: $hoy cal | Promedio anterior: ${"%.1f".format(promedio)} cal")
    println("Diferencia: ${if (diferencia >= 0) "+" else ""}${"%.1f".format(diferencia)} cal")
}
fun reto24() {
    println("=========Reto 24==========")
    val manifiesto = "(())(())"
    val pila = mutableListOf<Char>()
    var balanceado = true
    for (c in manifiesto) {
        when (c) {
            '(' -> pila.add(c)
            ')' -> if (pila.isEmpty()) { balanceado = false; break } else pila.removeLast()
        }
    }
    if (pila.isNotEmpty()) balanceado = false
    println("Contenedores balanceados: $balanceado")
}
fun reto25() {
    println("=========Reto 25==========")
    val tiempos = listOf(180, 210, 195, 165, 220, 200, 188)
    val sinOutliers = tiempos.filter { it != tiempos.min() && it != tiempos.max() }
    println("Promedio real: ${"%.2f".format(sinOutliers.average())} min")
}

fun reto26() {
    println("=========Reto 26==========")
    val logs = listOf("UP", "UP", "DOWN", "DOWN", "DOWN", "UP")
    val comprimido = mutableListOf<Pair<String, Int>>()
    for (estado in logs) {
        if (comprimido.isNotEmpty() && comprimido.last().first == estado) {
            val ultimo = comprimido.removeLast()
            comprimido.add(Pair(ultimo.first, ultimo.second + 1))
        } else { comprimido.add(Pair(estado, 1)) }
    }
    comprimido.forEach { (e, c) -> println("$e aparece $c veces") }
}
fun reto27() {
    println("=========Reto 27==========")
    val ventas = mapOf("Pedro" to 12000, "Ana" to 8500, "Luis" to 15000, "María" to 9000)
    val promedio = ventas.values.average()
    println("Promedio del equipo: ${"%.0f".format(promedio)}")
    println("Vendedores con bono:")
    ventas.filter { it.value > promedio }
        .forEach { (nombre, venta) -> println("  ✓ $nombre: $$venta") }
}

fun reto28() {
    println("=========Reto 28==========")
    val tarifas = mapOf(
        1 to 2000, 2 to 3500, 3 to 5000, 4 to 6000, 5 to 7000,
        6 to 8000, 7 to 9000, 8 to 10000, 9 to 11000, 10 to 12000
    )
    fun consultarCosto(horas: Int): Int = tarifas[horas] ?: error("Horas fuera de rango (1..10)")
    for (h in 1..10) { println("$h hora(s): $${consultarCosto(h)}") }
}

fun reto29() {
    println("=========Reto 29==========")
    val maletas = listOf(10, 25, 35, 15, 40, 20)
    val target = 50
    var encontrado = false
    for (i in maletas.indices) {
        for (j in i + 1 until maletas.size) {
            if (maletas[i] + maletas[j] == target) {
                println("Par encontrado: ${maletas[i]} kg y ${maletas[j]} kg (suman $target kg)")
                encontrado = true
            }
        }
    }
    if (!encontrado) println("No se encontró ningún par que sume $target kg")
}
fun reto30() {
    println("=========Reto 30==========")
    val plano = arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6))
    val filas = plano.size; val cols = plano[0].size
    val transpuesto = Array(cols) { IntArray(filas) }
    for (i in 0 until filas) {
        for (j in 0 until cols) { transpuesto[j][i] = plano[i][j] }
    }
    println("Plano original (2x3):")
    plano.forEach { println(it.toList()) }
    println("Plano transpuesto (3x2):")
    transpuesto.forEach { println(it.toList()) }
}