package me.adamstroud.aoc.y2016.d01

/**
 * TODO
 *
 * @author Adam Stroud &#60;[adam.stroud@gmail.com](mailto:adam.stroud@gmail.com)&#62;
 */
enum class Heading {
    NORTH {
        override fun toLeft() = WEST
        override fun toRight() = EAST
    },
    SOUTH {
        override fun toLeft() = EAST
        override fun toRight() = WEST
    },
    EAST {
        override fun toLeft() = NORTH
        override fun toRight() = SOUTH
    },
    WEST {
        override fun toLeft() = SOUTH
        override fun toRight() = NORTH
    };

    abstract fun toLeft(): Heading
    abstract fun toRight(): Heading
}