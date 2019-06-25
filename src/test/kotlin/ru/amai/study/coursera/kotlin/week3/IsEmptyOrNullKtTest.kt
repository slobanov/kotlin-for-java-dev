package ru.amai.study.coursera.kotlin.week3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class IsEmptyOrNullKtTest {

    @ParameterizedTest
    @CsvSource(
            ", true",
            "'', true",
            "'    ', false",
            "non empty, false"
    )
    fun isEmptyOrNull(s: String?, isNullOrEmpty: Boolean) {
        assertThat(s.isEmptyOrNull()).isEqualTo(isNullOrEmpty)
    }
}