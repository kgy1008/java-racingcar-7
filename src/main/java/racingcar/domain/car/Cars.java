package racingcar.domain.car;

import java.util.List;
import racingcar.domain.dto.Result;
import racingcar.domain.dto.Results;
import racingcar.domain.dto.Winner;
import racingcar.domain.number.NumberGenerator;

public class Cars {

    private static final int MIN_NUMBER_TO_MOVE = 4;

    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public Results startRace(final NumberGenerator numberGenerator) {
        List<Result> results = cars.stream()
                .peek(car -> moveOrStop(numberGenerator, car))
                .map(car -> new Result(car.getName(), car.getPosition()))
                .toList();
        return new Results(results);
    }

    private void moveOrStop(final NumberGenerator numberGenerator, final Car car) {
        int number = getNumber(numberGenerator);
        if (number >= MIN_NUMBER_TO_MOVE) {
            car.move();
        }
    }

    private int getNumber(final NumberGenerator numberGenerator) {
        return numberGenerator.generate();
    }

    public Winner findWinner() {
        List<String> winners = cars.stream()
                .filter(car -> car.getPosition() == findMaxPosition())
                .map(Car::getName)
                .toList();
        return new Winner(winners);
    }

    private int findMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}
