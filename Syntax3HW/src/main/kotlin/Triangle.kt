import java.lang.Exception
import kotlin.math.pow
import kotlin.math.sqrt

class Triangle(v1: Point, v2: Point, v3: Point) {
    init {
        if (v1.isCollinear(v2, v3)) {
            throw InvalidVerticesLocationException()
        }
    }

    var vertex1: Point = v1
        set(value) {
            if (value.isCollinear(vertex2, vertex3)) {
                throw InvalidVerticesLocationException()
            }
            field = value
            recalculateSides()
        }

    var vertex2: Point = v2
        set(value) {
            if (value.isCollinear(vertex1, vertex3)) {
                throw InvalidVerticesLocationException()
            }
            field = value
            recalculateSides()
        }

    var vertex3: Point = v3
        set(value) {
            if (value.isCollinear(vertex1, vertex2)) {
                throw InvalidVerticesLocationException()
            }
            field = value
            recalculateSides()
        }

    private var a: Float = sqrt((v1.x - v2.x).toFloat().pow(2) + (v1.y - v2.y).toFloat().pow(2))
    private var b: Float = sqrt((v2.x - v3.x).toFloat().pow(2) + (v2.y - v3.y).toFloat().pow(2))
    private var c: Float = sqrt((v1.x - v3.x).toFloat().pow(2) + (v1.y - v3.y).toFloat().pow(2))

    private fun recalculateSides() {
        a = sqrt((vertex1.x - vertex2.x).toFloat().pow(2) + (vertex1.y - vertex2.y).toFloat().pow(2))
        b = sqrt((vertex2.x - vertex3.x).toFloat().pow(2) + (vertex2.y - vertex3.y).toFloat().pow(2))
        c = sqrt((vertex1.x - vertex3.x).toFloat().pow(2) + (vertex1.y - vertex3.y).toFloat().pow(2))
    }

    fun perimeter(): Float {
        return a + b + c
    }

    fun area(): Float {
        val p = perimeter()
        return sqrt(p * (p - a) * (p - b) * (p - c))
    }

    fun print() {
        println("Треугольник с вершинами в точках $vertex1, $vertex2, $vertex3")
    }

    class InvalidVerticesLocationException : Exception("Точки лежат на одной прямой")
}