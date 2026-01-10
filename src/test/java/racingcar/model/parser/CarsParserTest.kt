package racingcar.model.parser

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.model.parser.CarsParser.parse

internal class CarsParserTest {
    @Test
    @DisplayName("단일 요소 파싱 테스트")
    fun parse() {
        val test = parse("phobi")

        Assertions.assertEquals(test.size, 1)
        Assertions.assertEquals(test[0].getName(), "phobi")
    }

    @Test
    @DisplayName("여러 요소 파싱 테스트")
    fun parse2() {
        val test = parse("phobi,wooni,kgy18")

        Assertions.assertEquals(test.size, 3)
        Assertions.assertEquals(test[0].getName(), "phobi")
        Assertions.assertEquals(test[1].getName(), "wooni")
        Assertions.assertEquals(test[2].getName(), "kgy18")
    }

    @ParameterizedTest
    @DisplayName("예외 테스트")
    @ValueSource(strings = ["wo:df", "5자를넘어감", "$%기호"])
    fun invalidInputParse(input: String) {
        Assertions.assertThrows(
            IllegalArgumentException::class.java
        ) { parse(input) }
    }
}
