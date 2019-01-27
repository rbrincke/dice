package io.rbrincke.dice

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class DiceSetTest {
    @Test
    fun testDominance() {
        val a = Die(listOf(6, 7, 8, 11, 12, 13))
        val b = Die(listOf(3, 4, 5, 10, 17, 18))
        val c = Die(listOf(1, 2, 9, 14, 15, 16))

        val expectedDominance = listOf(21.0 / 36.0, 21.0 / 36.0, 21.0 / 36.0)

        val diceSet = DiceSet(listOf(a, b, c))
        val actualDominance = diceSet.dominance()

        assertTrue(diceSet.isNontransitive())
        assertEquals(expectedDominance, actualDominance)
        assertEquals(expectedDominance.min(), diceSet.leastDominance())
    }
}