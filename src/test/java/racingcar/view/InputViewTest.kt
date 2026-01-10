package racingcar.view

import camp.nextstep.edu.missionutils.Console
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import racingcar.view.InputView.inputCarName
import java.io.ByteArrayInputStream
import java.io.InputStream

internal class InputViewTest {
    private fun setInput(input: String) {
        val inputStream: InputStream = ByteArrayInputStream(input.toByteArray())
        System.setIn(inputStream)
    }

    @AfterEach
    fun closeConsole() {
        Console.close()
    }

    @Test
    @DisplayName("자동차 이름 목록 입력 예외 테스트 - 빈 문자열")
    fun emptyInput() {
        val input = " "
        setInput(input)

        Assertions.assertThrows(IllegalArgumentException::class.java) {
            InputView.inputCarName()
        }
    }

    @Test
    @DisplayName("자동차 이름 목록 입력 예외 테스트 - 쉼표가 없는 경우(경주 자동차가 오직 1대)")
    fun onlyOneCarName() {
        val input = "car1car2"
        setInput(input)

        Assertions.assertThrows(IllegalArgumentException::class.java) {
            InputView.inputCarName()
        }
    }

    @Test
    @DisplayName("자동차 이름 목록 정상 입력 테스트")
    fun createValidName() {
        val input = "car1,car2"
        setInput(input)

        val result = inputCarName()

        Assertions.assertEquals(input, result)
    }
}
