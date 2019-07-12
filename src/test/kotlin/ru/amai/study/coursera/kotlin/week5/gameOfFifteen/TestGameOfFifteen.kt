package ru.amai.study.coursera.kotlin.week5.gameOfFifteen

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import ru.amai.study.coursera.kotlin.week4.board.Direction
import ru.amai.study.coursera.kotlin.week4.board.Direction.*
import ru.amai.study.coursera.kotlin.week5.game.Game

class TestGameOfFifteen {
    private fun Game.asString() =
            (1..4).joinToString("\n") { i ->
                (1..4).joinToString(" ") { j ->
                    get(i, j)?.let { "%2d".format(it) } ?: " -"
                }
            }

    class TestGameInitializer(
            override val initialPermutation: List<Int>
    ) : GameOfFifteenInitializer

    private fun testGame(initialPermutation: List<Int>, moves: List<Move>) {
        val game = newGameOfFifteen(TestGameInitializer(initialPermutation))
        game.initialize()

        for ((index, move) in moves.withIndex()) {
            if (move.direction == null) continue
            // checking the state after each move
            assertTrue(game.canMove(), "The move for game of fifteen should be always possible")
            game.processMove(move.direction)
            val prev = moves[index - 1].board
            assertEquals(move.board, game.asString(),
                "Wrong result after pressing ${move.direction} " + "for\n$prev\n"
            )
        }
    }

    data class Move(
        val direction: Direction?,
        val initialBoard: String
    ) {
        val board: String = initialBoard.trimMargin()
    }

    @Test
    fun testMoves() {
        testGame(listOf(3, 6, 13, 15, 7, 5, 8, 4, 14, 11, 12, 1, 10, 9, 2),
                listOf(
                        Move(null, """
            | 3  6 13 15
            | 7  5  8  4
            |14 11 12  1
            |10  9  2  -"""),
                        Move(RIGHT, """
            | 3  6 13 15
            | 7  5  8  4
            |14 11 12  1
            |10  9  -  2"""),
                        Move(DOWN, """
            | 3  6 13 15
            | 7  5  8  4
            |14 11  -  1
            |10  9 12  2"""),
                        Move(LEFT, """
            | 3  6 13 15
            | 7  5  8  4
            |14 11  1  -
            |10  9 12  2"""),
                        Move(UP, """
            | 3  6 13 15
            | 7  5  8  4
            |14 11  1  2
            |10  9 12  -"""),
                        Move(RIGHT, """
            | 3  6 13 15
            | 7  5  8  4
            |14 11  1  2
            |10  9  - 12""")
                ))
    }

    @Test
    fun testWinning() {
        val game = newGameOfFifteen(
            TestGameInitializer(
                (1..15).toList())
        )
        game.initialize()
        println(game.hasWon())
        assertTrue(game.hasWon(), "The player should win when the numbers are in order")
    }
}