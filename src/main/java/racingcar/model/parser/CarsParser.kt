package racingcar.model.parser

import racingcar.model.car.Car
import java.util.*

object CarsParser {
    private const val DELIMITER: String = ","

    @JvmStatic
    fun parse(input: String): List<Car> {
        val carNames = input.split(DELIMITER.toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        return Arrays.stream(carNames)
            .map { name: String? -> Car(name!!) }
            .toList()
    }
}
