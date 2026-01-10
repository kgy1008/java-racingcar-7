package racingcar.model.count

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.common.ErrorMessage

internal class TryCountTest {
    @Test
    @DisplayName("유효한 시도 횟수 입력")
    fun validTryCount() {
        val input = "5"
        val tryCount = TryCount(input)

        Assertions.assertEquals(5, tryCount.tryCount)
    }

    @ParameterizedTest
    @DisplayName("시도 횟수 예외 테스트")
    @ValueSource(strings = ["0", "abc", "-2"])
    fun invalidTryCount(input: String) {
        Assertions.assertThrows(
            IllegalArgumentException::class.java
        ) { TryCount(input) }
    }

    @ParameterizedTest
    @DisplayName("int 범위 초과시 예외 테스트")
    @ValueSource(strings = ["2147483648", "-2147483649"])
    fun outOfRangeTryCount(input: String) {
        org.assertj.core.api.Assertions.assertThatThrownBy { TryCount(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(ErrorMessage.OUT_OF_RANGE.message)
    }
}
