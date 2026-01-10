package racingcar.model.race

import racingcar.model.car.Car
import racingcar.model.car.Cars
import racingcar.model.number.Number
import racingcar.model.number.RandomNumberGenerator.generate
import java.util.function.Consumer

class Racing(private val cars: Cars) {
    fun start() {
        cars.cars.forEach(Consumer { car: Car ->
            val number = randomNumber
            car.goOrStop(number)
        })
    }

    private val randomNumber: Number
        get() = generate()
}
