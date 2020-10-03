package io.rbrincke.dice.samples.rps

import io.rbrincke.dice.core.Solver
import io.rbrincke.dice.samples.printResults

fun main() {
    rockPaperScissors().printResults(1)
}

fun rockPaperScissors() = run {
    val shapes = listOf(Rock, Paper, Scissors)
    val solver = Solver(shapes, listOf(1, 1, 1)) {
        it.single()
    }

    solver.solve()
}
