package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.CarNameParser;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {
    private final InputView inputView;
    private final OutputView outputView;

    public RaceController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Cars cars = parseCar();
    }

    private Cars parseCar() {
        String input = inputView.inputCarNames();
        List<Car> cars = CarNameParser.parse(input);
        return new Cars(cars);
    }
}
