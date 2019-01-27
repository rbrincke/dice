package io.rbrincke.dice.samples.dice

import io.rbrincke.dice.Solver

fun main(args: Array<String>) {
    val faces = (1..9).toList()
    val solver = Solver(faces, listOf(3, 3, 3)) {
        Die(it)
    }

    val solutions = solver.solve()

    val print = solutions.joinToString(System.lineSeparator()) { it.prettyPrint() }
    println(print)
}
