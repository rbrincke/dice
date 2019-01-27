package io.rbrincke.dice

data class DiceSet(val dice: List<Die>) {

    init {
        check(dice.isNotEmpty()) { "Dice set may not be empty." }
    }

    /**
     * For the N dice in this set, compute the probability that die 1 beats die 2,
     * ..., N - 1 beats N, N beats 1.
     */
    private val dominanceProbabilities= dice.mapIndexed { currentIdx, current ->
        val otherIdx = if (currentIdx + 1 < dice.size) currentIdx + 1 else 0
        val other = dice[otherIdx]

        current.dominates(other)
    }

    /**
     * True if die 1 beats die 2, ..., N - 1 beats N, N beats 1, false otherwise.
     */
    fun isNontransitive() = dominanceProbabilities.all { v -> v > 0.5 }

    /**
     * Least of the probabilities that die 1 beats die 2, ..., N - 1 beats N, N beats 1.
     */
    fun leastDominance() =
            dominanceProbabilities.min() ?: throw IllegalStateException("Empty set.")

    /**
     * Probability that 1 beats 2, ..., N - 1 beats N, N beats 1.
     */
    fun dominance() = dominanceProbabilities.toList()
}
