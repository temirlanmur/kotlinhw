class Point(val x: Int, val y: Int) {
    fun isCollinear(a: Point, b: Point): Boolean {
        return (a.y - b.y) * (a.x - x) == (a.y - y) * (a.x - b.x)
    }

    override fun toString(): String {
        return "($x, $y)"
    }
}