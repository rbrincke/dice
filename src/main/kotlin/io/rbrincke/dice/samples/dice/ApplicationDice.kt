package io.rbrincke.dice.samples.dice

import io.rbrincke.dice.Solver

fun main(args: Array<String>) {
    val faces = (1..18).toList()
    val solver = Solver(faces, listOf(6, 6, 6)) {
        Die(it)
    }

    val solutions = solver.solve()
            .sortedWith(
                    compareBy({ -it.leastDominance() }, { -it.dominance().max()!! })
            )

    println("${solutions.size} solutions")

    val print = solutions
            .subList(0, 20)
            .joinToString(System.lineSeparator()) {
                it.prettyPrint()
            }
    
    println(print)
}
