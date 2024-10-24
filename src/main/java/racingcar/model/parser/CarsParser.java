package racingcar.model.parser;

import java.util.Arrays;
import java.util.List;
import racingcar.model.car.Car;

public class CarsParser {

    public static List<Car> parse(final String input) {
        final String[] carNames = input.split(",");
        return Arrays.stream(carNames)
                .map(Car::new)
                .toList();
    }
}