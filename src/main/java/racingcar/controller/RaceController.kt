package racingcar.controller

import racingcar.model.car.Cars
import racingcar.model.count.TryCount
import racingcar.model.race.Racing
import racingcar.model.race.Winner
import racingcar.view.InputView
import racingcar.view.OutputView

class RaceController {
    private val tryCount: TryCount
    private val carNames: String

    init {
        this.carNames = inputCarNames()
        this.tryCount = initTryCount()
    }

    fun execute() {
        val cars = Cars(carNames)
        val racing = Racing(cars)
        OutputView.printResultMessage()
        for (i in 0 until tryCount.tryCount) {
            runSingleTrial(cars, racing)
        }
        OutputView.printWinner(findWinner(cars))
    }

    private fun runSingleTrial(cars: Cars, racing: Racing) {
        racing.start()
        OutputView.printResult(cars)
    }

    private fun findWinner(cars: Cars): List<String> {
        val winner = Winner(cars)
        return winner.find()
    }

    private fun inputCarNames(): String {
        try {
            return InputView.inputCarName()
        } catch (e: IllegalArgumentException) {
            OutputView.printErrorMessage(e.message)
            throw e
        }
    }

    private fun initTryCount(): TryCount {
        try {
            val count = InputView.inputTryCount()
            return TryCount(count)
        } catch (e: IllegalArgumentException) {
            OutputView.printErrorMessage(e.message)
            throw e
        }
    }
}
