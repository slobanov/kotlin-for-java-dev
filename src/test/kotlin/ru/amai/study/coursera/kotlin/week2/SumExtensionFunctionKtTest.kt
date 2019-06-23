package ru.amai.study.coursera.kotlin.week2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SumExtensionFunctionKtTest {

    @Test
    fun sum() {
        assertThat(listOf(1, 2, 3).sum()).isEqualTo(6)
    }
}