package racingcar.common;

public enum ErrorMessage {

    INVALID_INPUT("아무것도 입력되지 않았습니다. 다시 입력해주세요."),
    INVALID_INPUT_TYPE("숫자로 입력해주세요."),
    INVALID_NAME_LENGTH("자동차 이름은 최대 5자까지 가능합니다.");

    private static final String HEADER = "[ERROR] ";
    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return HEADER + message;
    }
}

