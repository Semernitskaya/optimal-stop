package com.github.semernitskaya

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class OptimalStopTest {

    @Test
    fun `accept n=1`() {
        assertTrue(OptimalStop(1).accept(10))
    }

    @Test
    fun `accept n=2, found`() {
        val optimalStop = OptimalStop(2)
        assertFalse(optimalStop.accept(5))
        assertTrue(optimalStop.accept(10))
    }

    @Test
    fun `accept n=2, not found`() {
        val optimalStop = OptimalStop(2)
        assertFalse(optimalStop.accept(10))
        assertFalse(optimalStop.accept(5))
    }

    @Test
    fun `accept n=10, {1, 2, 7, 3, 5, 6, 8, 4, 9, 10} found 8`() {
        val optimalStop = OptimalStop(10)
        for (i in listOf(1, 2, 7, 3, 5, 6))
            assertFalse(optimalStop.accept(i))
        assertTrue(optimalStop.accept(8))
    }

    @Test
    fun `accept n=10, {1, 2, 3, 10, 4, 5, 6, 7, 8, 9} not found`() {
        val optimalStop = OptimalStop(10)
        for (i in listOf(1, 2, 3, 10, 4, 5, 6, 7, 8, 9))
            assertFalse(optimalStop.accept(i))
    }

    @Test
    fun `process stopped exception`() {
        val optimalStop = OptimalStop(10)
        for (i in listOf(1, 2, 7, 3, 5, 6, 8))
            optimalStop.accept(i)
        assertThrows(IllegalStateException::class.java) {
            optimalStop.accept(9)
        }
    }

    @Test
    fun `duplicated score exception`() {
        val optimalStop = OptimalStop(2)
        optimalStop.accept(5)
        assertThrows(IllegalArgumentException::class.java) {
            optimalStop.accept(5)
        }
    }

    @Test
    fun `illegal score exception`() {
        val optimalStop = OptimalStop(1)
        assertThrows(IllegalArgumentException::class.java) {
            optimalStop.accept(MAX_SCORE + 1)
        }
    }

    @Test
    fun `illegal index exception`() {
        val optimalStop = OptimalStop(2)
        optimalStop.accept(10)
        optimalStop.accept(5)
        assertThrows(IndexOutOfBoundsException::class.java) {
            optimalStop.accept(4)
        }
    }
}