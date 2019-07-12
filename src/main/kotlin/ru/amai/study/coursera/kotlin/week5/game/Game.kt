package ru.amai.study.coursera.kotlin.week5.game

import ru.amai.study.coursera.kotlin.week4.board.Direction

interface Game {
    fun initialize()
    fun canMove(): Boolean
    fun hasWon(): Boolean
    fun processMove(direction: Direction)
    operator fun get(i: Int, j: Int): Int?
}
