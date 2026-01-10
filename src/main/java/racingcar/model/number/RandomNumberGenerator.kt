package racingcar.model.number

import camp.nextstep.edu.missionutils.Randoms

object RandomNumberGenerator {
    const val MIN_RANDOM_NUMBER: Int = 0
    const val MAX_RANDOM_NUMBER: Int = 9

    @JvmStatic
    fun generate(): Number {
        val randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER)
        return Number(randomNumber)
    }
}
