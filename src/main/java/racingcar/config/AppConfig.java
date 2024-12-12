package racingcar.config;

import racingcar.controller.RaceController;
import racingcar.domain.number.NumberGenerator;
import racingcar.domain.number.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class AppConfig {

    public RaceController controller() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        return new RaceController(inputView, outputView, numberGenerator);
    }
}
