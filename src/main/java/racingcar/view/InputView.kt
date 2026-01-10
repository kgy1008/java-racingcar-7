package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.common.ErrorMessage

object InputView {
    private const val NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
    private const val TRY_COUNT_INPUT_MESSAGE = "시도할 횟수는 몇 회인가요?"
    private const val DELIMITER = ","

    @JvmStatic
    fun inputCarName(): String {
        println(NAME_INPUT_MESSAGE)
        val input = Console.readLine()
        validate(input)
        return input
    }

    fun inputTryCount(): String {
        println(TRY_COUNT_INPUT_MESSAGE)
        return Console.readLine()
    }

    private fun validate(carNames: String) {
        validateNonEmptyCarNames(carNames)
        validateCarCount(carNames)
    }

    private fun validateNonEmptyCarNames(carNames: String) {
        if (carNames.isBlank()) {
            throw IllegalArgumentException(ErrorMessage.EMPTY_CAR_NAME.message)
        }
    }

    private fun validateCarCount(carNames: String) {
        if (!carNames.contains(DELIMITER)) {
            throw IllegalArgumentException(ErrorMessage.INVALID_CAR_COUNT.message)
        }
    }
}
