package racingcar.model.car

import racingcar.common.ErrorMessage
import racingcar.model.parser.CarsParser

class Cars(carNames: String) {
    val cars: List<Car>

    init {
        val cars = createCarList(carNames)
        validate(cars)
        this.cars = cars
    }

    private fun createCarList(carNames: String): List<Car> {
        return CarsParser.parse(carNames)
    }

    private fun validate(cars: List<Car>) {
        validateEmptyInput(cars)
        validateDuplicatedName(cars)
    }

    private fun validateEmptyInput(cars: List<Car>) {
        if (cars.isEmpty()) {
            throw IllegalArgumentException(ErrorMessage.EMPTY_CAR_LIST.message)
        }
    }

    private fun validateDuplicatedName(cars: List<Car>) {
        val expectedCarsList: Set<Car> = HashSet(cars)
        if (expectedCarsList.size != cars.size) {
            throw IllegalArgumentException(ErrorMessage.CONFLICT_ERROR.message)
        }
    }
}
