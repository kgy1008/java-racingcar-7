package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.FixedNumberGenerator;
import racingcar.domain.dto.Winner;
import racingcar.domain.number.NumberGenerator;

class CarsTest {

    private NumberGenerator numberGenerator = new FixedNumberGenerator();

    @Test
    @DisplayName("우승자를 찾는 테스트")
    void findWinner() {
        Car car1 = new Car("kim", 9);
        Car car2 = new Car("phobi", 3);
        Cars cars = new Cars(List.of(car1, car2));

        Winner winner = cars.findWinner();

        assertThat(winner.winners()).contains(car1.getName());
        assertThat(winner.winners().size()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차 이동 테스트")
    void move() {
        Car car1 = new Car("kim", 3);
        Cars cars = new Cars(List.of(car1));

        cars.startRace(numberGenerator);

        assertThat(car1.getPosition()).isEqualTo(4);
    }
}
