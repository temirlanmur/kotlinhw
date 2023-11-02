import kotlin.reflect.typeOf

fun main() {
    println("2 to the power 6 is ${2.power(6)}")
    println("5 to the power -2 is ${5.power(-2)}")
    println("7 to the power 0 is ${7.power(0)}")

    2.power(2) { a -> println("2 to the power 2 is $a") }


    3.displayTypeInfo()
    "a".displayTypeInfo()
    true.displayTypeInfo()
    DataType.DoubleType(1.4).displayTypeInfo()
    DataType.UnitType().displayTypeInfo()
}

fun Int.power(i: Int): Double {
    if (i == 0) {
        return 1.0;
    }

    val isPositivePower = i > 0
    var x = if (isPositivePower) i else -i
    var p = 1.0
    while (x > 0) {
        p *= this
        x--
    }

    return if (isPositivePower) p else 1 / p;
}

fun Int.power(i: Int, op: (Double) -> Unit) {
    op(this.power(i))
}

fun <T> T.displayTypeInfo() {
    when (this) {
        is Int -> println("это Int")
        is String -> println("это String")
        is DataType.DoubleType -> println("это DoubleType со значением ${this.value}")
        is DataType.UnitType -> println("это Unit")
        else -> println("тип у ${this} неизвестен")
    }
}