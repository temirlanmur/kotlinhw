fun main(args: Array<String>) {
    val v1 = Point(1, 2)
    val v2 = Point(3, 4)
    val v3 = Point(5, 9)

    val triangle = Triangle(v1, v2, v3)
    triangle.print()

    println("Периметр треугольника равен ${triangle.perimeter()}")
    println("Площадь треугольника равна ${triangle.area()}")

    triangle.vertex2 = Point(1, 4)
    triangle.print()

    println("Периметр треугольника равен ${triangle.perimeter()}")
    println("Площадь треугольника равна ${triangle.area()}")

    // triangle.vertex3 = Point(1, 9)
}