package me.adamstroud.aoc.y2016.d01

/**
 * TODO
 *
 * @author Adam Stroud &#60;[adam.stroud@gmail.com](mailto:adam.stroud@gmail.com)&#62;
 */
data class Position(var heading: Heading = Heading.NORTH, val location: Location = Location()) {
    fun move(direction:String, count:Int) {
        heading = when (direction) {
            "L" -> heading.toLeft()
            else -> heading.toRight()
        }

        when (heading) {
            Heading.NORTH -> location.y += count
            Heading.SOUTH -> location.y -= count
            Heading.EAST -> location.x += count
            Heading.WEST -> location.x -= count
        }
    }

    fun move(code: String) = move(code.first().toString(), code.substring(1).toInt())

    fun distanceTo(position: Position) = (Math.abs(location.x - position.location.x) + Math.abs(location.y - position.location.y))
}