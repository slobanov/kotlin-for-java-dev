package ru.amai.study.coursera.kotlin.week2

import kotlin.math.min

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {
    val rightPosition = secret.zip(guess).count { it.first == it.second }
    val wrongPosition = guess.toSet().sumBy { ch ->
        min( secret.count { it == ch }, guess.count { it == ch})
    } - rightPosition

    return Evaluation(rightPosition, wrongPosition)
}