fun main() {
    firstBuyer(list)
    secondBuyer(list)
    thirdBuyer(list)
    fourtBuyer(list)
    fiviesBuyer(list)
    rotozey(list)
    securityAgency(list)
    crazyShopper(list)

}

data class Cars(
    val kind: String,
    val model: String,
    val engine: String, // electro, diesel, ecto
    val color: String, // red, green, blue, yellow,
    var price: Int,
    val power: Int, // лошадиные силы
    val maxSpeed: Int// макс скорость
)

val list = listOf(
    Cars("BMW", "X5", "diesel", "black", 15000, 350, maxSpeed = 250),
    Cars("BMW", "X3", "diesel", "blue", 123000, 300, maxSpeed = 240),
    Cars("BMW", "X7", "diesel", "black", 234000, 300, maxSpeed = 220),
    Cars("BMW", "X8", "ecto", "red", 300000, 310, maxSpeed = 240),
    Cars("Mercedes", "Class C", "ecto", "white", 150000, 250, maxSpeed = 210),
    Cars("Mercedes", "Class E", "diesel", "blue", 120000, 250, maxSpeed = 210),
    Cars("Mercedes", "Class B", "ecto", "black", 300000, 320, maxSpeed = 200),
    Cars("Audi", "A3", "electro", "red", 160000, 160, maxSpeed = 200),
    Cars("Audi", "A4", "electro", "blue", 30000, 180, maxSpeed = 180),
    Cars("Audi", "A5", "electro", "yellow", 50000, 120, maxSpeed = 200),
    Cars("Audi", "A6", "electro", "black", 75000, 180, maxSpeed = 280),
    Cars("volkswagen", "Polo", "electro", "blue", 125000, 180, maxSpeed = 215),
    Cars("volkswagen", "Passat", "ecto", "red", 125000, 125, maxSpeed = 250),
    Cars("volkswagen", "Jetta", "ecto", "yellow", 185000, 160, maxSpeed = 200),
    Cars("volkswagen", "Tiguan", "diesel", "white", 225000, 200, maxSpeed = 220)
)

//- Денег у меня немного, хочу самую дешевую красную машину, но только не Ваг!
fun firstBuyer(list: List<Cars>) {
    val first = list.asSequence()
        .filter { it.color == "red" }
        .minOf { it.price }
    println("Самая дешевая красная машина стоит:$first")
}

/* пока не знаю чего хочу, покажите мне по одной модели
каждой марки на электромоторе, но обязательно чтобы больше 150 лошадиных сил*/
fun secondBuyer(list: List<Cars>) {
    val second = list.asSequence()
        .sortedBy { it.engine == "electro" }
        .takeWhile { it.power > 150 }
        .toList()
    println("Электрокары,с мощностью больше 150 лсч:$second")
}

// открываю премиум такси, мне нужны все черные машины на дизеле
fun thirdBuyer(list: List<Cars>) {
    val third = list.asSequence()
        .filter { it.color == "black" }
        .sortedBy { it.engine == "disel" }
        .toList()
    println("Все черные машины на дизеле:$third")
}

// 3 самых мощных автомобиля!
fun fourtBuyer(list: List<Cars>) {
    val four = list.asSequence()
        .sortedByDescending { it.power }
        .take(3)
        .toList()
    println("Три самых мощных автомобиля: $four")

}

//у меня ограниченный бюджет, пожалуйста, самую быструю, но до 200к рублей
fun fiviesBuyer(list: List<Cars>) {
    val fives = list.asSequence()
        .filter { it.price <= 200000 }
        .sortedBy { it.maxSpeed }
        .take(1)
        .toList()
    println("Самая быстрая машина с бюджетом ДО 200 000:$fives")

}

// а скажите, сколько стоят все автомобили в этом салоне?
fun rotozey(list: List<Cars>) {
    val sumOfPriceCars = list.sumOf { it.price }
    println("Сумма стоимости всех машин:$sumOfPriceCars")
}

//скажите, а сколько у вас белых автомобилей на бензине?
fun securityAgency(list: List<Cars>) {
    val sumOfWhikteCars = list.asSequence()
        .filter { it.engine == "ecto" }
        .count { it.color == "white" }
    println("Количество белых машин на бензине:$sumOfWhikteCars")
}

/*- у меня 10000к рублей, я хочу купить столько машин,
 сколько получится, но начать с дешевых, и я не люблю не черный*/
fun crazyShopper(list: List<Cars>) {
    val crazy = list.asSequence()
        .filter { it.price < 100000 }
        .sortedBy { it.price }
        .takeWhile { it.color == "black" }
        .toList()
    println("Машины с бюджетом ДО 100 000, начиная с дешёвых:$crazy")
}















