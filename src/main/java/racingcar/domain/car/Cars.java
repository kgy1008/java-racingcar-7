package racingcar.domain.car;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.dto.Result;
import racingcar.domain.dto.Results;
import racingcar.domain.number.NumberGenerator;

public class Cars {

    private static final int MIN_NUMBER_TO_MOVE = 4;

    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public Results startRace(final NumberGenerator numberGenerator) {
        List<Result> results = new ArrayList<>();
        for (Car car : cars) {
            int number = getNumber(numberGenerator);
            if (number >= MIN_NUMBER_TO_MOVE) {
                car.move();
            }
            results.add(new Result(car.getName(), car.getPosition()));
        }
        return new Results(results);
    }

    private int getNumber(final NumberGenerator numberGenerator) {
        return numberGenerator.generate();
    }

}
