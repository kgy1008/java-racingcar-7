package racingcar.model.number

import racingcar.common.ErrorMessage

open class Number(number: Int) {
    private val number: Int

    init {
        validate(number)
        this.number = number
    }

    val isGreaterThanForwardThreshold: Boolean
        get() = number >= FORWARD_THRESHOLD

    private fun validate(number: Int) {
        if (number < RandomNumberGenerator.MIN_RANDOM_NUMBER || number > RandomNumberGenerator.MAX_RANDOM_NUMBER) {
            throw IllegalArgumentException(ErrorMessage.OUT_OF_RANGE.message)
        }
    }

    companion object {
        private const val FORWARD_THRESHOLD = 4
    }
}
