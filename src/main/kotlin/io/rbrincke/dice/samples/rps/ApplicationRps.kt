package io.rbrincke.dice.samples.rps

import io.rbrincke.dice.Solver

fun main(args: Array<String>) {
    val shapes = listOf(Rock, Paper, Scissors)
    val solver = Solver(shapes, listOf(1, 1, 1)) {
        it.single()
    }

    val solutions = solver.solve()

    // Only one solution:
    val print = solutions.joinToString(System.lineSeparator()) { it.prettyPrint() }
    println(print)
}
