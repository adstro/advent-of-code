package me.adamstroud.aoc.y2016.d01

import me.adamstroud.aoc.y2016.d01.Heading
import org.hamcrest.CoreMatchers.equalTo
import org.junit.Assert.assertThat
import org.junit.Test

/**
 * TODO
 *
 * @author Adam Stroud &#60;[adam.stroud@gmail.com](mailto:adam.stroud@gmail.com)&#62;
 */
class HeadingTest {
    @Test
    fun testNorthToLeft() {
        assertThat(Heading.NORTH.toLeft(), equalTo(Heading.WEST))
    }

    @Test
    fun testNorthToRight() {
        assertThat(Heading.NORTH.toRight(), equalTo(Heading.EAST))
    }

    @Test
    fun testSouthToLeft() {
        assertThat(Heading.SOUTH.toLeft(), equalTo(Heading.EAST))
    }

    @Test
    fun testSouthToRight() {
        assertThat(Heading.SOUTH.toRight(), equalTo(Heading.WEST))
    }

    @Test
    fun testEastToLeft() {
        assertThat(Heading.EAST.toLeft(), equalTo(Heading.NORTH))
    }

    @Test
    fun testEastToRight() {
        assertThat(Heading.EAST.toRight(), equalTo(Heading.SOUTH))
    }

    @Test
    fun testWestToLeft() {
        assertThat(Heading.WEST.toLeft(), equalTo(Heading.SOUTH))
    }

    @Test
    fun testWestToRight() {
        assertThat(Heading.WEST.toRight(), equalTo(Heading.NORTH))
    }
}