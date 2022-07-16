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
        assertFalse(OptimalStop(1).accept(5))
        assertTrue(OptimalStop(1).accept(10))
    }

    @Test
    fun `accept n=2, not found`() {
        assertFalse(OptimalStop(1).accept(10))
        assertTrue(OptimalStop(1).accept(5))
    }

    @Test
    fun `accept n=10, found`() {
        assertFalse(OptimalStop(1).accept(5))
        assertTrue(OptimalStop(1).accept(10))
    }

    @Test
    fun `accept n=10, not found`() {
        assertFalse(OptimalStop(1).accept(5))
        assertTrue(OptimalStop(1).accept(10))
    }
}