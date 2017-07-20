package me.adamstroud.aoc.y2016.d04

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

/**
 * TODO
 *
 * @author Adam Stroud &#60;[adam.stroud@gmail.com](mailto:adam.stroud@gmail.com)&#62;
 */
class Day4Test {
    @Test
    fun testDecode_multiple() {
        val result = Day4().decode("aaaaa-bbb-z-y-x-123[abxyz]")

        assertThat(result.real).isTrue()
        assertThat(result.sectorId).isEqualTo(123)
        assertThat(result.checksum).isEqualTo("abxyz")
    }

    @Test
    fun testDecode_single() {
        val result = Day4().decode("a-b-c-d-e-f-g-h-987[abcde]")

        assertThat(result.real).isTrue()
        assertThat(result.sectorId).isEqualTo(987)
        assertThat(result.checksum).isEqualTo("abcde")
    }

    @Test
    fun testDecode_mixed() {
        val result = Day4().decode("not-a-real-room-404[oarel]")

        assertThat(result.real).isTrue()
        assertThat(result.sectorId).isEqualTo(404)
        assertThat(result.checksum).isEqualTo("oarel")
    }

    @Test
    fun testDecode_not_real() {
        val result = Day4().decode("totally-real-room-200[decoy]")

        assertThat(result.real).isFalse()
        assertThat(result.sectorId).isEqualTo(200)
        assertThat(result.checksum).isEqualTo("decoy")
    }
}