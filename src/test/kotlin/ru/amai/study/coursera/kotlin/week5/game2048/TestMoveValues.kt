package ru.amai.study.coursera.kotlin.week5.game2048

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import ru.amai.study.coursera.kotlin.week4.board.Direction
import ru.amai.study.coursera.kotlin.week4.board.Direction.DOWN
import ru.amai.study.coursera.kotlin.week4.board.Direction.RIGHT

class TestMoveValues : AbstractTestGameWithSmallNumbers() {
    @Test
    fun testSimpleMove() = testAllDirections("---- ---- -2-- ----", "---- ---- ---2 ----")

    @Test
    fun testNoMove() = testAllDirections("---- ---- ---- 2424", "---- ---- ---- 2424", move = false)

    @Test
    fun testSeveralMoves() = testAllDirections("2--- -2-- --2- ---2", "---2 ---2 ---2 ---2")

    @Test
    fun testMovesInSomeRows() = testAllDirections("2--- ---- --2- 2424", "---2 ---- ---2 2424")

    @Test
    fun testMoveAndMerge() = testAllDirections("2-2- -2-2 --2- ---2", "---4 ---4 ---2 ---2")

    @Test
    fun testMerge() = testAllDirections("2-22 2-42 22-2 ----", "--24 -242 --24 ----")

    private fun testAllDirections(inputString: String, expectedString: String, move: Boolean = true) {
        val input = TestBoard(inputString)
        val expected = TestBoard(expectedString)
        testRegularAndReversedDirections(RIGHT, input, expected, move)
        testRegularAndReversedDirections(DOWN, input.mirror(), expected.mirror(), move)
    }

    private fun testRegularAndReversedDirections(direction: Direction, input: TestBoard, expected: TestBoard, move: Boolean) {
        testMove(direction, input, expected, move)
        testMove(direction.reversed(), input.reversed(), expected.reversed(), move)
    }

    private fun testMove(direction: Direction, input: TestBoard, expected: TestBoard, expectedMove: Boolean) {
        val board = createBoard(input)
        val actualMove = board.moveValues(direction)
        val result = board.toTestBoard()
        assertEquals(expected, result, "Incorrect move to $direction.\nInput:\n$input\n")
        assertEquals(expectedMove, actualMove,
            "The 'moveValues' method returns incorrect result. Direction: $direction.\n" +
                    "Input:\n$input\n"
        )
    }
}