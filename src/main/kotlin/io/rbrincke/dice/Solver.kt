package io.rbrincke.dice

class Solver<S, T : Element<T>>(
        private val inputSet: List<S>,
        private val combinationSizes: List<Int>,
        private val elementCreator: (List<S>) -> T) {

    init {
        check(combinationSizes.isNotEmpty())
        check(combinationSizes.all { it > 0 }) {
            "Input set sizes must all be strictly positive."
        }

        check(combinationSizes.sum() == inputSet.size) {
            "Input set element count does not equal the total of combination sizes."
        }
    }

    private fun permutationToElementSet(permutation: List<Int>): Combination<T> {
        val target = combinationSizes.mapIndexed { index, i -> index to ArrayList<S>(i) }.toMap()

        permutation.mapIndexed { index, i ->
            target[i]!!.add(inputSet[index])
        }

        val elements = target.values.map { elementCreator.invoke(it) }

        return Combination(elements)
    }

    /**
     * Find any nontransitive [Combination]s.
     */
    fun solve(): List<Combination<T>> {
        // Perform permutation on a mask to avoid duplicate groupings due
        // to group-internal ordering differences.
        val mask = mutableListOf<Int>()
        combinationSizes.forEachIndexed { idx, count ->
            repeat(count) { mask.add(idx) }
        }

        check(mask.size == inputSet.size)

        // Always assign the first item to slot 0 to prevent equal solutions
        // with the positions rotated.
        return MultisetPermutationIterator(mask.drop(1))
                .asSequence()
                .map { listOf(0) + it }
                .map(::permutationToElementSet)
                .filter { it.isNontransitive() }
                .toList()
    }

}
