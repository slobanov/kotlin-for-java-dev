package ru.amai.study.coursera.kotlin.week3

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Condition
import org.junit.jupiter.api.Test
import java.util.function.Predicate

internal class InterchangeablePredicatesKtTest {

    private val listWithoutZero = listOf(1, 2, 3)
    private val listWithZero = listOf(1, 0, 3)

    @Test
    fun allNonZeroListWithoutZero () {
        assertThat(listWithoutZero).matches(List<Int>::allNonZero, "allNonZero")
    }

    @Test
    fun allNonZeroListWithZero() {
        assertThat(listWithZero).isNot(Condition( Predicate { it.allNonZero() }, "allNonZero"))
    }

    @Test
    fun allNonZero1ListWithoutZero () {
        assertThat(listWithoutZero).matches(List<Int>::allNonZero1, "allNonZero1")
    }

    @Test
    fun allNonZero1ListWithZero() {
        assertThat(listWithZero).isNot(Condition( Predicate { it.allNonZero1() }, "allNonZero1"))
    }

    @Test
    fun allNonZero2ListWithoutZero () {
        assertThat(listWithoutZero).matches(List<Int>::allNonZero2, "allNonZero2")
    }

    @Test
    fun allNonZero2ListWithZero() {
        assertThat(listWithZero).isNot(Condition( Predicate { it.allNonZero2() }, "allNonZero2"))
    }

    @Test
    fun containsZeroListWithoutZero() {
        assertThat(listWithoutZero).isNot(Condition( Predicate { it.containsZero() }, "containsZero"))
    }

    @Test
    fun containsZeroListWithZero() {
        assertThat(listWithZero).matches(List<Int>::containsZero, "containsZero")
    }


    @Test
    fun containsZero1ListWithoutZero() {
        assertThat(listWithoutZero).isNot(Condition( Predicate { it.containsZero1() }, "containsZero1"))
    }

    @Test
    fun containsZero1ListWithZero() {
        assertThat(listWithZero).matches(List<Int>::containsZero1, "containsZero1")
    }


    @Test
    fun containsZero2ListWithoutZero() {
        assertThat(listWithoutZero).isNot(Condition( Predicate { it.containsZero2() }, "containsZero2"))
    }

    @Test
    fun containsZero2ListWithZero() {
        assertThat(listWithZero).matches(List<Int>::containsZero2, "containsZero2")
    }

}