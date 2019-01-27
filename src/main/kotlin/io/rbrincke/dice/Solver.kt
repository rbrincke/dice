package io.rbrincke.dice

class Solver(val faces: List<Int>, val faceCountPerDie: List<Int>) {

    init {
        check(faceCountPerDie.isNotEmpty())
        check(faceCountPerDie.all { it > 0 }) { "Number of faces for any given die must be strictly positive." }
        check(faceCountPerDie.sum() == faces.size) { "Number of die faces does not equal the face count per die." }
    }

    private fun permutationToDiceSet(permutation: List<Int>): DiceSet {
        val sink = faceCountPerDie.mapIndexed { index, i -> index to mutableListOf<Int>() }
                .toMap()

        permutation.mapIndexed { index, i ->
            sink[i]!!.add(faces[index])
        }

        val dice = sink.values.map { Die(it) }

        return DiceSet(dice)
    }

    /**
     * Find any nontransitive [DiceSet]s.
     */
    fun solve(): Collection<DiceSet> {
        val mask = mutableListOf<Int>()
        faceCountPerDie.forEachIndexed { idx, count ->
            repeat(count) { mask.add(idx) }
        }

        check(mask.size == faces.size)

        return MultisetPermutationIterator(mask)
                .asSequence()
                .map(::permutationToDiceSet)
                .filter { it.isNontransitive() }
                .toList()
    }
}