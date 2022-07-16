package com.github.semernitskaya

import kotlin.math.E

const val MAX_SCORE = 100

const val MIN_SCORE = 0

class OptimalStop(private val n: Int) {

    private var max = MIN_SCORE
    private var currentIndex = 0
    private val rejectToIndex = (n / E)

    init {
        println(rejectToIndex)
    }

    fun accept(score: Int): Boolean {
        checkScore(score)
        checkCurrentIndex()
        return if (currentIndex++ <= rejectToIndex) {
            max = if (score > max) score else max
            false
        } else score > max
    }

    private fun checkCurrentIndex() {
        if (currentIndex >= n) throw IndexOutOfBoundsException("$n elements is expected")
    }

    private fun checkScore(score: Int) {
        if (score !in MIN_SCORE..MAX_SCORE)
            throw IllegalArgumentException("Score $score, should be between $MIN_SCORE and $MAX_SCORE")
    }
}