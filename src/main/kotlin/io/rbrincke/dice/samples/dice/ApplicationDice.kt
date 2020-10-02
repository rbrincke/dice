package io.rbrincke.dice.samples.dice

import io.rbrincke.dice.core.Solver

fun main() {
    val solutions = dice()

    println("${solutions.size} solutions")

    // Print the first 20 solutions, sorted by their strength.
    val print = solutions
        .sortedWith(
            compareBy({ -it.leastDominance() }, { -it.dominance().maxOrNull()!! })
        )
        .subList(0, 20)
        .joinToString(System.lineSeparator()) {
            it.prettyPrint()
        }

    println(print)
}

fun dice() = run {
    val faces = (1..18).toList()
    val solver = Solver(faces, listOf(6, 6, 6), ::Die)

    solver.solve()
}
