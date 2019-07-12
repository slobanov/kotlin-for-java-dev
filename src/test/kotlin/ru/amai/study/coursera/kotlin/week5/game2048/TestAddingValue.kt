package ru.amai.study.coursera.kotlin.week5.game2048

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TestAddingValue : AbstractTestGameWithSmallNumbers() {
    @Test
    fun test1() = testAddingOneNumber("---- ---- -2-- ----")

    @Test
    fun test2() = testAddingOneNumber("2222 ---- ---- ----")

    @Test
    fun test3() = testAddingOneNumber("2--- 4--- -2-- ---8")

    @Test
    fun test4() = testAddingOneNumber("-248 2-2- -2-8 4442")

    private fun testAddingOneNumber(input: String) {
        val inputBoard = TestBoard(input)
        val board = createBoard(inputBoard)
        board.addNewValue(RandomGame2048Initializer)
        val result = board.toTestBoard()
        assertEquals(1, inputBoard.board.indices.count { input[it] != result.board[it] },
            buildString {
                appendln("Only one element should be different after adding a new element.")
                appendln("Input:")
                appendln("$inputBoard")
                appendln("Result:")
                appendln("$result")
            })
    }
}