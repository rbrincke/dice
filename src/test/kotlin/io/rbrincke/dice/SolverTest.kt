package io.rbrincke.dice

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class SolverTest {
    @Test
    fun test() {
        val faces = (1 .. 9).toList()
        val solver = Solver(faces, listOf(3, 3, 3))

        val solutions = solver.solve()
        assertEquals(15, solutions.size)
    }
}