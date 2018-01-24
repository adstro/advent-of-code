package me.adamstroud.aoc.y2016

import com.google.common.hash.HashCode
import me.adamstroud.aoc.y2016.d01.Position
import me.adamstroud.aoc.y2016.d02.Keypad
import me.adamstroud.aoc.y2016.d04.Day4
import me.adamstroud.aoc.y2016.d06.Day6
import me.adamstroud.aoc.y2016.d07.Day7
import org.assertj.core.api.Assertions.assertThat
import org.hamcrest.CoreMatchers.equalTo
import org.junit.Assert.assertThat
import org.junit.Test
import java.nio.file.Files
import java.nio.file.Paths
import java.security.MessageDigest

/**
 * TODO
 *
 * @author Adam Stroud &#60;<a href="mailto:adam.stroud@gmail.com">adam.stroud@gmail.com</a>&#62;
 */
class Year2016Test {
    @Test
    fun testDay01() {
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
    fun testDay02() {
        val keypad = Keypad(3, 3, 1, 1)
        var passcode = ""

        Files.newBufferedReader(Paths.get("input", "2016.2.txt")).use {
            with(keypad) {
                it.readLines()
                        .map { it.trim() }
                        .forEach {
                            move(it)
                            passcode += computeValue()
                        }

                assertThat(passcode, equalTo("56983"))
            }
        }
    }

    @Test
    fun testDay03() {
        Files.newBufferedReader(Paths.get("input", "2016.3.txt")).use {
            val count = it.readLines()
                    .map { it.trim().split("\\s+".toRegex())}
                    .map { listOf(it[0].toInt(), it[1].toInt(), it[2].toInt()).sorted() }
                    .count { it[2] < it[0] + it[1] }

            assertThat(count, equalTo(1032))
        }
    }

    @Test
    fun testDay04() {
        val day4 = Day4()

        Files.newBufferedReader(Paths.get("input", "2016.4.txt")).use {
            val sum = it.readLines()
                    .map { day4.decode(it.trim()) }
                    .filter { it.real }
                    .sumBy { it.sectorId }

            assertThat(sum, equalTo(158835))
        }
    }

    @Test
    fun testDay05() {
        val md = MessageDigest.getInstance("MD5")
        val input = "ugkcyxxp"

        val code = String(IntRange(0, Int.MAX_VALUE).asSequence()
                .map { HashCode.fromBytes(md.digest((input + it).toByteArray())).toString() }
                .filter { it.startsWith("00000") }
                .map { it[5] }
                .take(8)
                .toList()
                .toCharArray())
                .toLowerCase()

        assertThat(code).isEqualTo("d4cd2ee1")
    }

    @Test
    fun testDay06() {
        val day6 = Day6()

        Files.newBufferedReader(Paths.get("input", "2016.6.txt")).use {
            assertThat(day6.run(it.readText())).isEqualTo("qqqluigu")
        }
    }

    @Test
    fun testDay07() {
        val day7 = Day7()

        Files.newBufferedReader(Paths.get("input", "2016.7.txt")).use {
            assertThat(it.readLines().count { day7.supportsTls(it) }).isEqualTo(118)
        }
    }
}