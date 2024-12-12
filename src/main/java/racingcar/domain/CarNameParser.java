package racingcar.domain;

import java.util.Arrays;
import java.util.List;

public class CarNameParser {

    private static final String DELIMITER = ",";
    private static final int START_POSITION = 0;

    public static List<Car> parse(final String input) {
        return Arrays.stream(input.split(DELIMITER))
                .map(car -> new Car(car.trim(), START_POSITION))
                .toList();
    }
}
