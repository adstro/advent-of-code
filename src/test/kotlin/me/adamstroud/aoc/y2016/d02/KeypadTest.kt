package me.adamstroud.aoc.y2016.d02

import org.hamcrest.CoreMatchers.equalTo
import org.junit.Assert.assertThat
import org.junit.Test

/**
 * TODO
 *
 * @author Adam Stroud &#60;[adam.stroud@gmail.com](mailto:adam.stroud@gmail.com)&#62;
 */
class KeypadTest {
    @Test
    fun testMove_U_L_L() {
        val keypad = Keypad(3, 3, 1, 1)

        keypad.move(Direction.UP, Direction.LEFT, Direction.LEFT)
        assertThat(keypad.computeValue(), equalTo(1))
    }

    @Test
    fun testMove_R_R_D_D_D() {
        val keypad = Keypad(3, 3, 1, 1)

        keypad.move(Direction.RIGHT, Direction.RIGHT, Direction.DOWN, Direction.DOWN, Direction.DOWN)
        assertThat(keypad.computeValue(), equalTo(9))
    }

    @Test
    fun testMove_L_U_R_D_L() {
        val keypad = Keypad(3, 3, 2, 2)

        keypad.move(Direction.LEFT, Direction.UP, Direction.RIGHT, Direction.DOWN, Direction.LEFT)
        assertThat(keypad.computeValue(), equalTo(8))
    }

    @Test
    fun testMove_U_U_U_U_D() {
        val keypad = Keypad(3, 3, 1, 2)

        keypad.move(Direction.UP, Direction.UP, Direction.UP, Direction.UP, Direction.DOWN)
        assertThat(keypad.computeValue(), equalTo(5))
    }

    @Test
    fun testMove_1985() {
        val keypad = Keypad(3, 3, 1, 1)
        var passcode = ""

        with(keypad) {
            move("ULL")
            passcode += computeValue()
            move("RRDDD")
            passcode += computeValue()
            move("LURDL")
            passcode += computeValue()
            move("UUUUD")
            passcode += computeValue()
        }

        assertThat(passcode, equalTo("1985"))
    }
}