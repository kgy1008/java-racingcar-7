package racingcar.domain;

import racingcar.common.ErrorMessage;

public class Car {

    private static final int MAX_LENGTH = 5;

    private final String name;
    private final int position;

    public Car(final String name, final int position) {
        validateName(name);
        this.name = name;
        this.position = position;
    }

    private void validateName(final String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NAME_LENGTH.getMessage());
        }
    }
}
