package racingcar.domain;

import racingcar.domain.number.NumberGenerator;

public class FixedNumberGenerator implements NumberGenerator {

    @Override
    public int generate() {
        return 4;
    }
}
