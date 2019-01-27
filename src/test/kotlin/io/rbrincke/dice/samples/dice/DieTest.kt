package io.rbrincke.dice.samples.dice

import io.rbrincke.dice.samples.dice.Die
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class DieTest {
    @Test
    fun testDominance() {
        val a = Die(listOf(6, 7, 8, 11, 12, 13))
        val b = Die(listOf(3, 4, 5, 10, 17, 18))

        val score = a.beats(b)

        assertEquals(21.0 / 36.0, score)
    }

    @Test
    fun testDominance2() {
        val a = Die(listOf(1, 2, 3, 5))
        val b = Die(listOf(1, 2, 2, 3))

        val score = a.beats(b)

        assertEquals(10.0 / 16.0, score)
    }
}
