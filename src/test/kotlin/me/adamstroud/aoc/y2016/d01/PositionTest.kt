package me.adamstroud.aoc.y2016.d01

import org.hamcrest.CoreMatchers.equalTo
import org.junit.Assert.assertThat
import org.junit.Test

/**
 * TODO
 *
 * @author Adam Stroud &#60;[adam.stroud@gmail.com](mailto:adam.stroud@gmail.com)&#62;
 */
class PositionTest {
    @Test
    fun testConstructor() {
        val position = Position()

        assertThat(position.heading, equalTo(Heading.NORTH))
        assertThat(position.location.x, equalTo(0))
        assertThat(position.location.y, equalTo(0))
    }

    @Test
    fun testMove_r2_l3() {
        val position = Position()

        with(position) {
            move("R", 2)
            move("L", 3)
        }

        assertThat(position.heading, equalTo(Heading.NORTH))
        assertThat(position.location.x, equalTo(2))
        assertThat(position.location.y, equalTo(3))

        assertThat(position.distanceTo(Position()), equalTo(5))
    }

    @Test
    fun testMove_r2_r2_r2() {
        val position = Position()

        with(position) {
            move("R", 2)
            move("R", 2)
            move("R", 2)
        }

        assertThat(position.heading, equalTo(Heading.WEST))
        assertThat(position.location.x, equalTo(0))
        assertThat(position.location.y, equalTo(-2))

        assertThat(position.distanceTo(Position()), equalTo(2))
    }

    @Test
    fun testMove_r5_l5_r5_r3() {
        val position = Position()

        with(position) {
            move("R", 5)
            move("L", 5)
            move("R", 5)
            move("R", 3)
        }

        assertThat(position.distanceTo(Position()), equalTo(12))
    }

    @Test
    fun testMove_code_r5_l5_r5_r3() {
        val position = Position()

        with(position) {
            move("R5")
            move("L5")
            move("R5")
            move("R3")
        }

        assertThat(position.distanceTo(Position()), equalTo(12))
    }

    @Test
    fun testMove_code_r10() {
        val position = Position()

        position.move("R10")

        assertThat(position.distanceTo(Position()), equalTo(10))
    }

    @Test
    fun testMove_code_l100() {
        val position = Position()

        position.move("L100")

        assertThat(position.distanceTo(Position()), equalTo(100))
    }

    @Test
    fun testMove_day_1() {
        val input = """R5, L2, L1, R1, R3, R3, L3, R3, R4, L2, R4, L4, R4, R3, L2, L1, L1, R2, R4,
                       R4, L4, R3, L2, R1, L4, R1, R3, L5, L4, L5, R3, L3, L1, L1, R4, R2, R2, L1,
                       L4, R191, R5, L2, R46, R3, L1, R74, L2, R2, R187, R3, R4, R1, L4, L4, L2,
                       R4, L5, R4, R3, L2, L1, R3, R3, R3, R1, R1, L4, R4, R1, R5, R2, R1, R3, L4,
                       L2, L2, R1, L3, R1, R3, L5, L3, R5, R3, R4, L1, R3, R2, R1, R2, L4, L1, L1,
                       R3, L3, R4, L2, L4, L5, L5, L4, R2, R5, L4, R4, L2, R3, L4, L3, L5, R5, L4,
                       L2, R3, R5, R5, L1, L4, R3, L1, R2, L5, L1, R4, L1, R5, R1, L4, L4, L4, R4,
                       R3, L5, R1, L3, R4, R3, L2, L1, R1, R2, R2, R2, L1, L1, L2, L5, L3, L1"""

        val position = Position()

        with(position) {
            input.split(",").map { it.trim() }.forEach { move(it) }
        }

        assertThat(position.distanceTo(Position()), equalTo(287))
    }
}