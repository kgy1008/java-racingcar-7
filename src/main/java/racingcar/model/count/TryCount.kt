package racingcar.model.count

import racingcar.common.ErrorMessage

class TryCount(count: String) {
    val tryCount: Int

    init {
        val tryCount = convertStringToInt(count)
        validate(tryCount)
        this.tryCount = tryCount
    }

    private fun validate(input: Int) {
        if (input <= ZERO) {
            throw IllegalArgumentException(ErrorMessage.INVALID_TRY_COUNT.message)
        }
    }

    private fun convertStringToInt(input: String): Int {
        try {
            val value = input.toLong()
            checkOutOfIntegerRange(value)
            return value.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(ErrorMessage.INVALID_TRY_COUNT.message)
        }
    }

    private fun checkOutOfIntegerRange(input: Long) {
        if (input > Int.MAX_VALUE || input < Int.MIN_VALUE) {
            throw IllegalArgumentException(ErrorMessage.OUT_OF_RANGE.message)
        }
    }

    companion object {
        private const val ZERO = 0
    }
}
