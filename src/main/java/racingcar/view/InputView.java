package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.common.ErrorMessage;

public class InputView {

    public String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        validate(input);
        return input;
    }

    public int inputTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
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
