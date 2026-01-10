package racingcar.view

import org.junit.jupiter.api.*
import racingcar.model.car.Cars
import racingcar.model.number.TestableNumber
import racingcar.view.OutputView.printResult
import racingcar.view.OutputView.printWinner
import java.io.ByteArrayOutputStream
import java.io.PrintStream

internal class OutputViewTest {
    private val outputStream = ByteArrayOutputStream()

    @BeforeEach
    fun setUp() {
        System.setOut(PrintStream(outputStream))
    }

    @AfterEach
    fun restoresStreams() {
        System.setOut(System.out)
    }

    @Test
    @DisplayName("단독 우승자 출력 테스트")
    fun printOneWinner() {
        val winnerCarName = "pobi"

        printWinner(java.util.List.of(winnerCarName))

        Assertions.assertEquals("최종 우승자 : pobi\n", outputStream.toString())
    }

    @Test
    @DisplayName("다수의 우승자 출력 테스트")
    fun printMultipleWinner() {
        val winnerCarNames: List<String?> = listOf("pobi", "kgy", "yeoni")

        printWinner(winnerCarNames)

        Assertions.assertEquals("최종 우승자 : pobi, kgy, yeoni\n", outputStream.toString())
    }

    @Test
    @DisplayName("자동차 결과 출력 테스트")
    fun printResultTest() {
        val cars = Cars("pobi,woni")
        val car1 = cars.cars[0]
        val car2 = cars.cars[1]

        car1.goOrStop(TestableNumber(MOVING_FORWARD))
        car2.goOrStop(TestableNumber(STOP))

        printResult(cars)

        val expectedOutput = "pobi : -\nwoni : \n\n"
        Assertions.assertEquals(expectedOutput, outputStream.toString())
    }

    companion object {
        private const val MOVING_FORWARD = 5
        private const val STOP = 3
    }
}
