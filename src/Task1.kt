fun main() {
    for (i in 1..100) {
        val result = when {
            i % 15 == 0 -> "FizzBuz!"
            i % 3 == 0 -> "Fizz"
            i % 5 == 0 -> "Buzz"
            else
            -> "$i"
        }
        println(result)
    }
    ticketByPlane()
    println(newCar("X7",Car("BMW","X5")))
}

fun ticketByPlane(cityOne: String = "Москва", cityTwo: String = "Санкт-Петербург", time: Float = 15.00f) {
    println("Запланирован полет из $cityOne в $cityTwo в $time часов")
}

/*создать класс Машина с двумя полями - марка и модель.
Создать функцию, которая принимала бы на вход аргументы Машина и Модель - и возвращала бы новый объект Машины с измененной моделью.
Выводить сообщение об ошибке если Модель совпадает с текущей моделью Машины
throw IllegalArgumentException("___")

Привет. Так тоже можно, но давай усложним.
Убери дефолтные значения из дата класса и внутри функции используй copy()
Тебе так же нужно передать Car в функцию, чтобы было из чего копировать*/
data class Car(
    val brand: String,
    val model: String
)

fun newCar(newModel: String, car: Car): Car {
    if (newModel == "X5") {
        throw  IllegalArgumentException("Модели равны")
    }
    return car.copy(model = newModel)

}
