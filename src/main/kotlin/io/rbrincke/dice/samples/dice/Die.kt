package io.rbrincke.dice.samples.dice

import io.rbrincke.dice.Element

data class Die(val faces: Collection<Int>) : Element<Die> {

    /**
     * Returns the probability that a cast of this die results in a higher
     * face value than a cast of the [other] die. Draws are assumed to be
     * resolved by a coin toss.
     */
    override fun beats(other: Die): Double {
        val count = faces.map { x ->
            other.faces.map { y -> beats(x, y) }.sum()
        }.sum()

        return count / (faces.size * other.faces.size)
    }

    private fun beats(x: Int, y: Int) = when {
        x > y -> 1.0
        x == y -> 0.5
        else -> 0.0
    }

}
