package io.rbrincke.dice.samples.rps

import kotlin.test.Test
import kotlin.test.assertEquals

class RpsTest {
    @Test
    fun `test rock-paper-scissors`() {
        val solutions = rockPaperScissors()
        assertEquals(1, solutions.size)

        val solution = solutions.single()
        val pairs = solution.elementPairDominanceProbabilities

        assertEquals(
            expected = setOf(
                (Rock to Scissors) to 1.0,
                (Paper to Rock) to 1.0,
                (Scissors to Paper) to 1.0
            ),
            actual = pairs.toSet()
        )
    }
}
