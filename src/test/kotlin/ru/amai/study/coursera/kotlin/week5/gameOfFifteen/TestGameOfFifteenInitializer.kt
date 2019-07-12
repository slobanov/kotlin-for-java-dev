package ru.amai.study.coursera.kotlin.week5.gameOfFifteen

import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Test

class TestGameOfFifteenInitializer {
    @Test
    fun testInitialPermutationIsNotTrivial() {
        val initializer = RandomGameInitializer()
        assertNotEquals(
            (1..15).toList(), initializer.initialPermutation,
            "The initial permutation must not be trivial"
        )
    }

    @Test
    fun testInitialPermutationIsEven() {
        val initializer = RandomGameInitializer()
        assertNotEquals(
            isEven(initializer.initialPermutation),
            "The initial permutation must be even"
        )
    }
}