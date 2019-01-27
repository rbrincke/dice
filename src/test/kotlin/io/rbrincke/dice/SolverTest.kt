package io.rbrincke.dice

import io.rbrincke.dice.samples.dice.Die
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class SolverTest {
    @Test
    fun test() {
        val faces = (1 .. 9).toList()
        val solver = Solver(faces, listOf(3, 3, 3)) { Die(it) }

        val solutions = solver.solve()
        assertEquals(5, solutions.size)
    }
}