package racingcar.view;

import racingcar.common.ErrorMessage;

public class InputView {

    private void validate(final String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
        }
    }
}
