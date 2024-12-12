package racingcar.config;

import racingcar.controller.RaceController;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class AppConfig {

    public RaceController controller() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        return new RaceController(inputView, outputView);
    }
}
