package racingcar.controller;

import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarNameParser;
import racingcar.domain.car.Cars;
import racingcar.domain.dto.Results;
import racingcar.domain.dto.Winner;
import racingcar.domain.number.NumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {
    private final InputView inputView;
    private final OutputView outputView;
    private final NumberGenerator numberGenerator;

    public RaceController(final InputView inputView, final OutputView outputView,
                          final NumberGenerator numberGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.numberGenerator = numberGenerator;
    }

    public void run() {
        Cars cars = parseCar();
        int tryCount = inputView.inputTryCount();
        while (tryCount-- > 0) {
            Results results = cars.startRace(numberGenerator);
            outputView.printResult(results);
        }
        Winner winner = cars.findWinner();
        outputView.printWinner(winner);
    }

    private Cars parseCar() {
        String input = inputView.inputCarNames();
        List<Car> cars = CarNameParser.parse(input);
        return new Cars(cars);
    }
}
