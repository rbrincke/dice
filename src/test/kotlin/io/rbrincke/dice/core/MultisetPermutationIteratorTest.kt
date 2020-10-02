package io.rbrincke.dice.core

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MultisetPermutationIteratorTest {
    /**
     * Trivial single-element.
     */
    @Test
    fun `test single element`() {
        val multiset = listOf(2)
        val expected = listOf(listOf(2))
        val actual = MultisetPermutationIterator(multiset).asSequence().toList()

        assertEquals(expected, actual)
    }

    /**
     * Example from Aaron Williams' paper.
     */
    @Test
    fun `test paper example`() {
        val multiset = listOf(1, 1, 2, 2, 3)
        val expected = listOf(
            listOf(3, 2, 2, 1, 1),
            listOf(1, 3, 2, 2, 1),
            listOf(3, 1, 2, 2, 1),
            listOf(2, 3, 1, 2, 1),
            listOf(1, 2, 3, 2, 1),
            listOf(2, 1, 3, 2, 1),
            listOf(3, 2, 1, 2, 1),
            listOf(1, 3, 2, 1, 2),
            listOf(3, 1, 2, 1, 2),
            listOf(1, 3, 1, 2, 2),
            listOf(1, 1, 3, 2, 2),
            listOf(3, 1, 1, 2, 2),
            listOf(2, 3, 1, 1, 2),
            listOf(1, 2, 3, 1, 2),
            listOf(2, 1, 3, 1, 2),
            listOf(1, 2, 1, 3, 2),
            listOf(1, 1, 2, 3, 2),
            listOf(2, 1, 1, 3, 2),
            listOf(3, 2, 1, 1, 2),
            listOf(2, 3, 2, 1, 1),
            listOf(2, 2, 3, 1, 1),
            listOf(1, 2, 2, 3, 1),
            listOf(2, 1, 2, 3, 1),
            listOf(2, 2, 1, 3, 1),
            listOf(1, 2, 2, 1, 3),
            listOf(2, 1, 2, 1, 3),
            listOf(1, 2, 1, 2, 3),
            listOf(1, 1, 2, 2, 3),
            listOf(2, 1, 1, 2, 3),
            listOf(2, 2, 1, 1, 3)
        )
        val actual = MultisetPermutationIterator(multiset).asSequence().toList()

        assertEquals(expected, actual)
    }
}
