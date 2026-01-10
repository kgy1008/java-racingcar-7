package racingcar.model.car

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.ValueSource

internal class NameTest {
    @ParameterizedTest
    @DisplayName("이름 예외 테스트")
    @EmptySource
    @ValueSource(strings = [" ", "5자를넘어감", "$%기호"])
    fun createInValidName(name: String) {
        Assertions.assertThrows(
            IllegalArgumentException::class.java
        ) { Name(name) }
    }

    @ParameterizedTest
    @DisplayName("정상 이름 생성 테스트")
    @ValueSource(strings = ["phobi", "woni", "bmwM3"])
    fun createValidName(name: String) {
        val createdName = Name(name)
        Assertions.assertEquals(name, createdName.name)
    }
}
