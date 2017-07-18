package me.adamstroud.aoc.y2016.d02

/**
 * TODO
 *
 * @author Adam Stroud &#60;<a href="mailto:adam.stroud@gmail.com">adam.stroud@gmail.com</a>&#62;
 */
data class Keypad(val rows: Int, val columns: Int, var currentX: Int, var currentY:Int) {
    fun move(vararg moves: Direction) {
        moves.forEach {
            println("CurrentX = $currentX, CurrentY = $currentY, value = ${computeValue()}")
            println("Moving $it")

            when (it) {
                Direction.LEFT -> currentX = Math.max(0, currentX - 1)
                Direction.RIGHT -> currentX = Math.min(columns - 1, currentX + 1)
                Direction.UP -> currentY = Math.max(0, currentY - 1)
                Direction.DOWN -> currentY = Math.min(rows - 1, currentY + 1)
            }

            println("CurrentX = $currentX, CurrentY = $currentY, value = ${computeValue()}")
        }
    }

    fun move(input: String) {
        input.map {
            move(when (it.toString()) {
                "U" -> Direction.UP
                "D" -> Direction.DOWN
                "L" -> Direction.LEFT
                else -> Direction.RIGHT
            })
        }
    }

    fun computeValue(): Int = (currentX + 1) + (currentY * rows)
}