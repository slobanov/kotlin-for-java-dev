package ru.amai.study.coursera.kotlin.week3

fun String.isNice(): Boolean = listOf(
    setOf("bu", "ba", "be").none { it in this },
    count { it in "aeiou" } >= 3,
    zipWithNext().any { it.first == it.second }
).count { it } >= 2
