package me.adamstroud.aoc.y2016.d06

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Day6Test {
    @Test
    fun testRun() {
        val input = """eedadn
                       drvtee
                       eandsr
                       raavrd
                       atevrs
                       tsrnev
                       sdttsa
                       rasrtv
                       nssdts
                       ntnada
                       svetve
                       tesnvt
                       vntsnd
                       vrdear
                       dvrsen
                       enarar"""

        assertThat(Day6().run(input)).isEqualTo("easter")
    }
}