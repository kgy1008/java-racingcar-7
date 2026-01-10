package racingcar.model.race

import racingcar.common.ErrorMessage
import racingcar.model.car.Cars

class Winner(private val cars: Cars) {

    fun find(): List<String> {
        val maxDistance = findMaxMovingDistance()

        return cars.cars
            .filter { it.position.calculateMovingDistance() == maxDistance }
            .map { it.getName() }
    }

    private fun findMaxMovingDistance(): Int {
        return cars.cars
            .maxOfOrNull { it.position.calculateMovingDistance() }
            ?: throw IllegalArgumentException(
                ErrorMessage.CAN_NOT_CALCULATE_DISTANCE.message
            )
    }
}
