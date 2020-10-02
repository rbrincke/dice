package io.rbrincke.dice.core

/**
 * Sets up a solver that is able to find allocations of [labels] that lead to non-transitive
 * elements. The number of resulting elements equals the size of [labelGroupSizes], and each
 * element will contain precisely the number specified in [labelGroupSizes].
 *
 * @param labels labels that are to be allocated to elements
 * @param labelGroupSizes the group sizes in which labels should be allocated (sum of all elements must equal the size of [labels])
 * @param elementCreator function that describes how to to create an element from a list of [labels]
 */
class Solver<S, T : Element<T>>(
    private val labels: List<S>,
    private val labelGroupSizes: List<Int>,
    private val elementCreator: (List<S>) -> T
) {
    init {
        check(labelGroupSizes.isNotEmpty())
        check(labelGroupSizes.all { it > 0 }) {
            "Input set sizes must all be strictly positive."
        }

        check(labelGroupSizes.sum() == labels.size) {
            "Input set element count does not equal the total of combination sizes."
        }
    }

    private fun permutationToElementSet(permutation: List<Int>): Combination<T> {
        val target = labelGroupSizes.mapIndexed { index, i ->
            index to ArrayList<S>(i)
        }.toMap()

        permutation.mapIndexed { index, i ->
            target.getValue(i).add(labels[index])
        }

        val elements = target.values.map { elementCreator.invoke(it) }
        return Combination(elements)
    }

    /**
     * Find any non-transitive [Combination]s.
     */
    fun solve(): List<Combination<T>> {
        // Perform permutation on a mask to avoid duplicate groupings due
        // to group-internal ordering differences.
        val mask = mutableListOf<Int>()
        labelGroupSizes.forEachIndexed { idx, count ->
            repeat(count) { mask.add(idx) }
        }

        check(mask.size == labels.size)

        // Fix the first item to slot 0 to avoid identical solutions
        // with rotated positions.
        return MultisetPermutationIterator(mask.drop(1))
            .asSequence()
            .map { listOf(0) + it }
            .map(::permutationToElementSet)
            .filter { it.isNonTransitive() }
            .toList()
    }
}
