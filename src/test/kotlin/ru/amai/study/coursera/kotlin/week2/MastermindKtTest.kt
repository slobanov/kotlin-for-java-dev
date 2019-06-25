package ru.amai.study.coursera.kotlin.week2

import org.assertj.core.api.SoftAssertions.assertSoftly
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class MastermindKtTest {

    @ParameterizedTest
    @CsvSource(
            "AABC, ADFE, 1, 0",
            "AABC, ADFA, 1, 1",
            "AABC, DFAA, 0, 2",
            "AABC, DEFA, 0, 1",
            "ABCD, EAAA, 0, 1",
            "AABC, ADFA, 1, 1",
            "AABC, DEFA, 0, 1",
            "EDEB, CBFE, 0, 2",
            "CFDF, FCCD, 0, 3",
            "AABC, AEFD, 1, 0",
            "DCFC, ABEC, 1, 0",
            "FDCD, FBAD, 2, 0",
            "DEFA, AABC, 0, 1",
            "DAAE, AABC, 1, 1",
            "BBDC, DFBB, 0, 3",
            "DBFF, FFDD, 0, 3",
            "BDAD, AAAE, 1, 0",
            "FDDB, CABB, 1, 0",
            "BDBC, DDFC, 2, 0",
            "ECDE, CEEE, 1, 2",
            "AAAF, ABCA, 1, 1",
            "BCDA, AFEA, 1, 0",
            "EEEE, AFEA, 1, 0",
            "EEBE, AFEA, 0, 1",
            "EEAD, EEEE, 2, 0",
            "BACD, EAFF, 1, 0",
            "ABCD, ABCD, 4, 0",
            "ABCD, CDBA, 0, 4",
            "ABCD, ABDC, 2, 2",
            "ABCD, ABCF, 3, 0",
            "DAEF, FECA, 0, 3",
            "ACEB, BCDF, 1, 1",
            "FBAE, ABCD, 1, 1",
            "FBAE, AFDC, 0, 2",
            "FBAE, CBAE, 3, 0",
            "FBAE, CBFE, 2, 1",
            "FBAE, FBAE, 4, 0",
            "EBAC, ABCD, 1, 2",
            "EBAC, AFCB, 0, 3",
            "EBAC, CBDF, 1, 1",
            "EBAC, EBAC, 4, 0"
    )
    fun evaluateGuess(secret: String, guess: String, rightPosition: Int, wrongPosition: Int) {
        val evaluation = evaluateGuess(secret, guess)
        assertSoftly {
            it.assertThat(evaluation.rightPosition)
                .`as`("rightPosition").isEqualTo(rightPosition)
            it.assertThat(evaluation.wrongPosition)
                .`as`("wrongPosition").isEqualTo(wrongPosition)
        }
    }
}