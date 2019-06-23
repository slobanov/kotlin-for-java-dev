package ru.amai.study.coursera.kotlin.week2

/**
 * Sum as an extension function
 */
fun List<Int>.sum(): Int {
    var result = 0
    for (i in this) {
        result += i
    }
    return result
}