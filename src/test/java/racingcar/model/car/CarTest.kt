package racingcar.model.car

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import racingcar.model.number.TestableNumber

internal class CarTest {
    private var car: Car? = null

    @BeforeEach
    fun setUp() {
        car = Car("phobi")
    }

    @Test
    @DisplayName("유효한 객체 생성 테스트")
    fun createCar() {
        Assertions.assertEquals("phobi", car!!.getName())
    }

    @Test
    @DisplayName("자동차가 전진 테스트")
    fun moveForward() {
        val number = TestableNumber(MOVING_FORWARD)

        car!!.goOrStop(number)

        Assertions.assertEquals(1, car!!.position.calculateMovingDistance())
    }

    @Test
    @DisplayName("자동차가 멈춤 테스트")
    fun stop() {
        val number = TestableNumber(STOP)

        car!!.goOrStop(number)

        Assertions.assertEquals(0, car!!.position.calculateMovingDistance())
    }

    companion object {
        private const val MOVING_FORWARD = 5
        private const val STOP = 3
    }
}
