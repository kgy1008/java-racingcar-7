package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.common.ErrorMessage;

public class InputView {

    public String inputCarNames() {
        String input = Console.readLine();
        validate(input);
        return input;
    }

    public int inputTryCount() {
        String input = Console.readLine();
        return convertToInt(input);
    }

    private void validate(final String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
        }
    }

    private int convertToInt(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_TYPE.getMessage());
        }
    }
}
