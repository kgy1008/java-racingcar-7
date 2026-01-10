package racingcar

import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class ApplicationTest : NsTest() {
    @Test
    fun 기능_테스트() {
        camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "1")
                Assertions.assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi")
            },
            MOVING_FORWARD, STOP
        )
    }

    @Test
    fun 우승자_여러명일_경우() {
        camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "1")
                Assertions.assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi, woni")
            },
            MOVING_FORWARD, MOVING_FORWARD
        )
    }

    @Test
    fun 예외_테스트() {
        camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest {
            Assertions.assertThatThrownBy {
                runException(
                    "pobi,javaji",
                    "1"
                )
            }
                .isInstanceOf(IllegalArgumentException::class.java)
        }
    }

    public override fun runMain() {
        Application.main(arrayOf())
    }

    companion object {
        private const val MOVING_FORWARD = 4
        private const val STOP = 3
    }
}
