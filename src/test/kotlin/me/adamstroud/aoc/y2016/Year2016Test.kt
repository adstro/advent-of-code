package me.adamstroud.aoc.y2016

import com.sun.org.apache.xml.internal.security.algorithms.MessageDigestAlgorithm
import me.adamstroud.aoc.y2016.d01.Position
import me.adamstroud.aoc.y2016.d02.Keypad
import me.adamstroud.aoc.y2016.d04.Day4
import org.assertj.core.api.Assertions
import org.hamcrest.CoreMatchers.equalTo
import org.junit.Assert.assertThat
import org.junit.Test
import java.nio.file.Files
import java.nio.file.Paths
import java.security.MessageDigest
import java.util.stream.IntStream
import javax.xml.bind.DatatypeConverter
import kotlin.coroutines.experimental.EmptyCoroutineContext.plus

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
                .map { DatatypeConverter.printHexBinary(md.digest((input + it).toByteArray())) }
                .filter { it.startsWith("00000") }
                .map { it[5] }
                .take(8)
                .toList()
                .toCharArray())
                .toLowerCase()

        Assertions.assertThat(code).isEqualTo("d4cd2ee1")
    }
}