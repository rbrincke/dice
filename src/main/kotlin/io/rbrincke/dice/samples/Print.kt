package io.rbrincke.dice.samples

import io.rbrincke.dice.core.Combination
import kotlin.math.min

private val solutionStrengthComparator = compareBy<Combination<*>>(
    { -it.leastDominance() },
    { -it.dominance().maxOrNull()!! }
)

/**
 * Prints the result to the console.
 */
fun List<Combination<*>>.printResults(maximumNumberOfSolutionsToPrint: Int) {
    val numberOfSolutionsToBePrinted = min(size, maximumNumberOfSolutionsToPrint)
    println("$size solutions found, printing $numberOfSolutionsToBePrinted")

    sortedWith(solutionStrengthComparator).subList(0, numberOfSolutionsToBePrinted).forEach {
        println(it.prettyPrint())
    }
}
