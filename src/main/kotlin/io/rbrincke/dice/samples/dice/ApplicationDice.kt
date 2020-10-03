package io.rbrincke.dice.samples.dice

import io.rbrincke.dice.core.Solver
import io.rbrincke.dice.samples.printResults

fun main() {
    dice().printResults(20)
}

fun dice() = run {
    val faces = (1..18).toList()
    val solver = Solver(faces, listOf(6, 6, 6), ::Die)

    solver.solve()
}
