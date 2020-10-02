package io.rbrincke.dice.samples.rps

import io.rbrincke.dice.core.Element

sealed class Shape : Element<Shape>

object Rock : Shape() {
    override fun beats(other: Shape) = if (other is Scissors) 1.0 else 0.0
    override fun toString() = "Rock"
}

object Paper : Shape() {
    override fun beats(other: Shape) = if (other is Rock) 1.0 else 0.0
    override fun toString() = "Paper"
}

object Scissors : Shape() {
    override fun beats(other: Shape) = if (other is Paper) 1.0 else 0.0
    override fun toString() = "Scissors"
}
