package io.rbrincke.dice

class Combination<T : Element<T>>(val elements: List<T>) {

    init {
        check(elements.isNotEmpty()) { "Element set may not be empty." }
    }

    /**
     * Matches element 1 to 2, ..., N - 1 to N, N to 1.
     */
    private fun matches() = elements.mapIndexed { currentIdx, current ->
        val otherIdx = if (currentIdx + 1 < elements.size) currentIdx + 1 else 0
        val other = elements[otherIdx]

        current to other
    }

    /**
     * For the N elements in this set, compute the probability that die 1 beats die 2,
     * ..., N - 1 beats N, N beats 1.
     */
    private val dominanceProbabilities = matches().map { (current, other) ->
        current.beats(other)
    }

    /**
     * True if element 1 beats element 2, ..., N - 1 beats N, N beats 1, false otherwise.
     */
    fun isNontransitive() = dominanceProbabilities.all { v -> v > 0.5 }

    /**
     * Least of the probabilities that element 1 beats element 2, ..., N - 1 beats N, N beats 1.
     */
    fun leastDominance() =
            dominanceProbabilities.min() ?: throw IllegalStateException("Empty set.")

    /**
     * Probability that element 1 beats element 2, ..., N - 1 beats N, N beats 1.
     */
    fun dominance() = dominanceProbabilities.toList()

    /**
     * Prints this combination as if it is nontransitive.
     */
    fun prettyPrint() =
            matches().zip(dominanceProbabilities).joinToString { (elements, probability) ->
                val (current, other) = elements
                "$current beats $other with probability $probability"
            }

}

interface Element<E> {

    /**
     * Probability that this element beats the other element [E].
     */
    fun beats(other: E): Double

}
