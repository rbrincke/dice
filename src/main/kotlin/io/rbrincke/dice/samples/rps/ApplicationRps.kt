package io.rbrincke.dice.samples.rps

import io.rbrincke.dice.core.Solver

fun main() {
    val solutions = rockPaperScissors()

    // Only one solution:
    val print = solutions.joinToString(System.lineSeparator()) { it.prettyPrint() }
    println(print)
}

fun rockPaperScissors() = run {
    val shapes = listOf(Rock, Paper, Scissors)
    val solver = Solver(shapes, listOf(1, 1, 1)) {
        it.single()
    }

    solver.solve()
}
