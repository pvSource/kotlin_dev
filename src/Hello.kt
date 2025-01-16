fun main() {
    // Шаг 1: Список украшений
    val decorations = listOf("rock", "pagoda", "plastic plant", "alligator", "flowerpot")

    // Жадный фильтр
    val eager = decorations.filter { it[0] == 'p' }
    println("eager: $eager")

    // Ленивый фильтр с Sequence
    val filtered = decorations.asSequence().filter { it[0] == 'p' }
    println("filtered: $filtered")

    // Принудительная оценка ленивой последовательности
    val newList = filtered.toList()
    println("new list: $newList")

    // Ленивое преобразование с map
    val lazyMap = decorations.asSequence().map {
        println("access: $it")
        it
    }
    println("lazy: $lazyMap")
    println("-----")
    println("first: ${lazyMap.first()}")
    println("-----")
    println("all: ${lazyMap.toList()}")

    // Последовательность с фильтром перед map
    val lazyMap2 = decorations.asSequence().filter { it[0] == 'p' }.map {
        println("access: $it")
        it
    }
    println("-----")
    println("filtered: ${lazyMap2.toList()}")

    // Пример flatten
    val mysports = listOf("basketball", "fishing", "running")
    val myplayers = listOf("LeBron James", "Ernest Hemingway", "Usain Bolt")
    val mycities = listOf("Los Angeles", "Chicago", "Jamaica")
    val mylist = listOf(mysports, myplayers, mycities) // Список списков

    println("-----")
    println("Flat: ${mylist.flatten()}")
}
