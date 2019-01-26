package io.rbrincke.dice

/**
 * Multiset permutation iterator. Not thread safe.
 *
 * See *"Loopless Generation of Multiset Permutations using a Constant Number
 * of Variables by Prefix Shifts."*, Aaron Williams, 2009.
 */
class MultisetPermutationIterator<E : Comparable<E>>(input: Collection<E>) : Iterator<List<E>> {

    private val nodes: List<Node<E>>

    private var head: Node<E>
    private var i: Node<E>? = null
    private var afteri: Node<E>

    private var pristine = true

    init {
        checkNotNull(input)
        check(input.isNotEmpty())

        nodes = initializeNodeList(input)
        head = nodes[0]

        if (input.size > 1) {
            i = nodes[nodes.size - 2]
        }

        afteri = nodes[nodes.size - 1]
    }

    private fun initializeNodeList(input: Collection<E>): List<Node<E>> {
        val nodes = input.reversed().map { Node(it) }.toList()

        for (i in 0 until nodes.size - 1) {
            nodes[i].next = nodes[i + 1]
        }

        return nodes
    }

    /**
     * Returns `true` if another permutation is available. (In other words, returns
     * true if the next call to [next] would return a permutation rather than
     * throwing an exception).
     */
    override fun hasNext(): Boolean {
        return pristine || afteri.next != null || afteri.value < head.value
    }

    /**
     * Returns the next permutation.
     * @throws NoSuchElementException if there are no more permutations
     */
    override fun next(): List<E> {
        if (!hasNext()) {
            throw NoSuchElementException()
        }

        if (pristine) {
            pristine = false
            return visit(head)
        }

        val afteriNext = afteri.next
        val beforek: Node<E> = if (afteriNext != null && i!!.value >= afteriNext.value) {
            afteri
        } else {
            i!!
        }

        val k = beforek.next
        checkNotNull(k)

        beforek.next = k.next
        k.next = head

        if (k.value < head.value) {
            i = k
        }

        afteri = i!!.next!!
        head = k

        return visit(head)
    }

    private fun visit(node: Node<E>): List<E> {
        val values = ArrayList<E>(nodes.size)

        values.add(node.value)

        var current = node
        while (current.next != null) {
            current = current.next!!
            values.add(current.value)
        }

        return values
    }
}

private class Node<E : Comparable<E>>(val value: E) {
    var next: Node<E>? = null
}
