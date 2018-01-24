package me.adamstroud.aoc.y2016.d07

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.data.Index
import org.junit.Test

class Day7Test {
    @Test
    fun testHasAbba() {

        assertThat(Day7().hasAbba("abba")).isTrue()
        assertThat(Day7().hasAbba("baab")).isTrue()
        assertThat(Day7().hasAbba("abaabg")).isTrue()
        assertThat(Day7().hasAbba("abcd")).isFalse()
        assertThat(Day7().hasAbba("aaaa")).isFalse()
    }

    @Test
    fun testSupportsTls_1() {
        assertThat(Day7().supportsTls("abba[mnop]qrst")).isTrue()
    }

    @Test
    fun testSupportsTls_2() {
        assertThat(Day7().supportsTls("abcd[bddb]xyyx")).isFalse()
    }

    @Test
    fun testSupportsTls_3() {
        assertThat(Day7().supportsTls("aaaa[qwer]tyui")).isFalse()
    }

    @Test
    fun testSupportsTls_4() {
        assertThat(Day7().supportsTls("ioxxoj[asdfgh]zxcvbn")).isTrue()
    }

    @Test
    fun testMultipleHypertexts() {
        val hyperTexts = Day7().getHyperTexts("adf[hypertext1]adsafadsfads[hypertext2]adfdasfdas")
        assertThat(hyperTexts)
                .hasSize(2)
                .contains("hypertext1", Index.atIndex(0))
                .contains("hypertext2", Index.atIndex(1))
    }
}