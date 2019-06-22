package ru.amai.study.coursera.kotlin.week2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class CheckingIdentifiersKtTest {

    @ParameterizedTest
    @CsvSource(
            "name, true",
            "_name, true",
            "_12, true",
            "'', false",
            "012, false",
            "no$, false"
    )
    fun isValidIdentifier(identifier: String, isValid: Boolean) {
        assertThat(isValidIdentifier(identifier)).isEqualTo(isValid)
    }
}