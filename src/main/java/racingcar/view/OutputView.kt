package racingcar.view

import racingcar.model.car.Car
import racingcar.model.car.Cars

object OutputView {
    private const val RESULT_MESSAGE = "실행 결과"
    private const val DETAIL = " : "
    private const val DELIMITER = ", "
    private const val WINNER_MESSAGE = "최종 우승자$DETAIL"
    private const val ERROR_MESSAGE = "[ERROR] "

    fun printResultMessage() {
        println(
            """
                
                $RESULT_MESSAGE
                """.trimIndent()
        )
    }

    @JvmStatic
    fun printResult(cars: Cars) {
        cars.cars.stream()
            .map { car: Car -> car.getName() + DETAIL + getMovingDistance(car) }
            .forEach { x: String? -> println(x) }
        println()
    }

    fun printWinner(winners: List<String?>) {
        println(WINNER_MESSAGE + java.lang.String.join(DELIMITER, winners))
    }

    fun printErrorMessage(message: String?) {
        println(ERROR_MESSAGE + message)
    }

    private fun getMovingDistance(car: Car): String {
        return car.position.getDistance()
    }
}
