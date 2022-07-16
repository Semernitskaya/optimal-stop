package com.github.semernitskaya

import kotlin.math.E
import kotlin.math.roundToInt

const val MAX_SCORE = 100

const val MIN_SCORE = 0

class OptimalStop(private val n: Int) {

    private val rejectToIndex = (n / E).roundToInt()
    private val scores = HashSet<Int>()

    private var max = MIN_SCORE
    private var currentIndex = 0
    private var stopped = false

    fun accept(score: Int): Boolean {
        if (stopped) {
            throw IllegalStateException("Process stopped!")
        }
        checkScore(score)
        checkCurrentIndex()
        return if (currentIndex++ < rejectToIndex) {
            max = if (score > max) score else max
            false
        } else {
            stopped = score > max
            return stopped
        }
    }

    private fun checkCurrentIndex() {
        if (currentIndex >= n) throw IndexOutOfBoundsException("$n elements is expected")
    }

    private fun checkScore(score: Int) {
        if (score !in MIN_SCORE..MAX_SCORE)
            throw IllegalArgumentException("Score $score, should be between $MIN_SCORE and $MAX_SCORE")
        if (!scores.add(score))
            throw IllegalArgumentException("Duplicated score $score")
    }
}