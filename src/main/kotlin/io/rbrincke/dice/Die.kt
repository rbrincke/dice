package io.rbrincke.dice

data class Die(val faces: Collection<Int>) {

    /**
     * Returns the probability that a cast of this die results in a higher
     * face value than a cast of the [other] die.
     */
    fun dominates(other: Die): Double {
        val count = faces.map { x ->
            other.faces.map { y -> dominates(x, y) }.sum()
        }.sum()

        return count / (faces.size * other.faces.size)
    }

    private fun dominates(x: Int, y: Int) = when {
        x > y -> 1.0
        x == y -> 0.5
        else -> 0.0
    }
}