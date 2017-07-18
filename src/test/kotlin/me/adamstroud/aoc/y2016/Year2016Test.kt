package me.adamstroud.aoc.y2016

import me.adamstroud.aoc.y2016.d01.Position
import me.adamstroud.aoc.y2016.d02.Keypad
import org.hamcrest.CoreMatchers.equalTo
import org.junit.Assert.assertThat
import org.junit.Test
import java.nio.file.Files
import java.nio.file.Paths

/**
 * TODO
 *
 * @author Adam Stroud &#60;<a href="mailto:adam.stroud@gmail.com">adam.stroud@gmail.com</a>&#62;
 */
class Year2016Test {
    @Test
    fun testDay1() {
        val position = Position()
        
        Files.newBufferedReader(Paths.get("input", "2016.1.txt")).use {
            with(position) {
                it.readLines()
                        .flatMap { it.split(",") }
                        .map { it.trim() }
                        .forEach { move(it) }
            }
        }

        assertThat(position.distanceTo(Position()), equalTo(287))
    }

    @Test
    fun testDay2() {
        val keypad = Keypad(3, 3, 1, 1)
        var passcode = ""

        Files.newBufferedReader(Paths.get("input", "2016.2.txt")).use {
            with(keypad) {
                it.readLines()
                        .map { it.trim() }
                        .forEach {
                            println("line = $it")
                            move(it)
                            passcode += computeValue()
                        }

                assertThat(passcode, equalTo("56983"))
            }
        }
    }
}