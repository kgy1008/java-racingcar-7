package racingcar

import racingcar.controller.RaceController

object Application {
    @JvmStatic
    fun main(args: Array<String>) {
        val raceController = RaceController()
        raceController.execute()
    }
}
