package ru.amai.study.coursera.kotlin.week3

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Condition
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource
import java.util.function.Predicate

internal class NiceStringKtTest {

    @ParameterizedTest
    @CsvSource(
        "baaa",
        "aaab",
        "geaa",
        "ynzz",
        "ijao",
        "nn",
        "zuu",
        "uaa",
        "upui",
        "oouh",
        "wddf",
        "baii",
        "obee",
        "beiuu",
        "uyyxqptkvbtz",
        "limseelx",
        "zwhueqe",
        "iwuvevd",
        "qcdpogyeti",
        "ygmuuyuj",
        "cuimjyyakh",
        "eufalmmwwbnid",
        "kbzstzwhjeestb",
        "rdfieknqrwxx",
        "mzhevzkmmz",
        "jootdvhbesdns",
        "crncuotgburrcv",
        "burppqqeivsrw"
    )
    fun isNice(s: String) {
        assertThat(s).matches(String::isNice, "isNice")
    }

    @ParameterizedTest
    @ValueSource(strings = [
        "bac",
        "aza",
        "abaca",
        "",
        "hfrcnykh",
        "qc",
        "ymsetecw",
        "bei",
        "mbalqw",
        "bekqe",
        "luosbaqzdh",
        "zcgsdbuxeo",
        "bukipcmju",
        "sisxxjwlkbu",
        "bawbxffum",
        "bbau",
        "ax",
        "baa",
        "aebe",
        "bbau",
        "uibe",
        "srxn",
        "wvad"
    ])
    fun notNice(s: String) {
        assertThat(s).isNot(Condition(Predicate { it.isNice() }, "isNice"))
    }
}