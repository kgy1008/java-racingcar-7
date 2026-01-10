package racingcar.model.car

import racingcar.model.number.Number
import java.util.*

class Car(name: String) {
    private val name = Name(name)
    val position: Position = Position()

    fun goOrStop(number: Number) {
        if (number.isGreaterThanForwardThreshold) {
            position.increase()
        }
    }

    fun getName(): String {
        return name.name
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) {
            return true
        }
        if (o == null || javaClass != o.javaClass) {
            return false
        }
        val car = o as Car
        return name == car.name
    }

    override fun hashCode(): Int {
        return Objects.hashCode(name)
    }
}
