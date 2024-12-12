package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("5자가 넘는 이름이 들어오면 예외가 발생한다")
    void invalidCarName() {
        String name = "dsfdsfsaf";
        assertThatThrownBy(() -> new Car(name, 0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
