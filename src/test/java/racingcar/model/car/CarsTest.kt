package racingcar.model.car

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.ValueSource

internal class CarsTest {
    @ParameterizedTest
    @DisplayName("자동차 목록 생성 예외 테스트")
    @EmptySource
    @ValueSource(strings = ["winG,winG", "winG,ph,winG"])
    fun createInValidCars(input: String) {
        Assertions.assertThrows(
            IllegalArgumentException::class.java
        ) { Cars(input) }
    }

    @ParameterizedTest
    @DisplayName("유효한 자동차 목록 생성 테스트")
    @ValueSource(strings = ["phobi", "woni,bmwM3"])
    fun createValidName(input: String) {
        val cars = Cars(input)
        val expected = input.split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()

        Assertions.assertEquals(expected.size, cars.cars.size)
    }
}
