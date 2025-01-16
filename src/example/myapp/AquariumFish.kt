package example.myapp

// Интерфейс FishAction с методом eat()
interface FishAction {
    fun eat()
}

// Интерфейс FishColor с абстрактным свойством color
interface FishColor {
    val color: String
}

// Класс-синглтон для GoldColor, реализующий интерфейс FishColor
object GoldColor : FishColor {
    override val color = "gold"
}

// Класс для действия рыбы, который выводит информацию о том, что она ест
class PrintingFishAction(val food: String) : FishAction {
    override fun eat() {
        println(food)
    }
}

// Класс Plecostomus, который использует делегирование интерфейсов FishAction и FishColor
class Plecostomus(fishColor: FishColor = GoldColor) :
    FishAction by PrintingFishAction("eat algae"),
    FishColor by fishColor

// Класс Shark, который также реализует оба интерфейса FishAction и FishColor
class Shark : FishAction, FishColor {
    override val color = "grey"

    override fun eat() {
        println("hunt and eat fish")
    }
}
