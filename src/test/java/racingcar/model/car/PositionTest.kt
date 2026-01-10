package racingcar.model.car

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class PositionTest {
    private val position = Position()

    @Test
    @DisplayName("자동차 전진시 위치 변화 테스트")
    fun movePosition() {
        val initialPosition = position.calculateMovingDistance()

        position.increase()
        position.increase()
        position.increase()

        val finalPosition = position.calculateMovingDistance()

        Assertions.assertEquals(3, finalPosition - initialPosition)
        Assertions.assertEquals("---", position.getDistance())
    }

    @Test
    @DisplayName("자동차 멈춤시 위치 변화 테스트1")
    fun stop1() {
        val initialPosition = position.calculateMovingDistance()
        val finalPosition = position.calculateMovingDistance()

        Assertions.assertEquals(0, finalPosition - initialPosition)
        Assertions.assertEquals("", position.getDistance())
    }

    @Test
    @DisplayName("자동차 멈춤시 위치 변화 테스트2")
    fun stop2() {
        position.increase()

        val initialPosition = position.calculateMovingDistance()
        val finalPosition = position.calculateMovingDistance()

        Assertions.assertEquals(0, finalPosition - initialPosition)
        Assertions.assertEquals("-", position.getDistance())
    }
}
