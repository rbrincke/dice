package io.rbrincke.dice.core

class Combination<T : Element<T>>(private val elements: List<T>) {
    init {
        check(elements.isNotEmpty()) { "Elements may not be empty." }
    }

    /**
     * Matches element 1 to 2, ..., N - 1 to N, N to 1.
     */
    private val elementPairs = elements.mapIndexed { currentIdx, current ->
        val other = elements[(currentIdx + 1) % elements.size]
        current to other
    }

    /**
     * For the N elements in this set, compute the probability that die 1 beats die 2,
     * ..., N - 1 beats N, N beats 1.
     */
    private val dominanceProbabilities = elementPairs.map { (current, other) ->
        current.beats(other)
    }

    val elementPairDominanceProbabilities = elementPairs.zip(dominanceProbabilities)

    /**
     * True if element 1 beats element 2, ..., N - 1 beats N, N beats 1, false otherwise.
     */
    fun isNonTransitive() = dominanceProbabilities.all { v -> v > 0.5 }

    /**
     * Least of the probabilities that element 1 beats element 2, ..., N - 1 beats N, N beats 1.
     */
    fun leastDominance() = dominanceProbabilities.minOrNull() ?: throw IllegalStateException("Empty set.")

    /**
     * Probability that element 1 beats element 2, ..., N - 1 beats N, N beats 1.
     */
    fun dominance() = dominanceProbabilities.toList()

    /**
     * Pretty prints this combination.
     */
    fun prettyPrint() = elementPairDominanceProbabilities.joinToString { (elements, probability) ->
        val (current, other) = elements
        "$current beats $other with probability $probability"
    }
}

interface Element<in E> {
    /**
     * Probability that this element beats the other element [E]. If draws are possible,
     * they are assumed to be resolved by a coin toss.
     */
    fun beats(other: E): Double
}
