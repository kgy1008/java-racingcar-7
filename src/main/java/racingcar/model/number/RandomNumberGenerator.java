package racingcar.model.number;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    protected static final int MIN_RANDOM_NUMBER = 0;
    protected static final int MAX_RANDOM_NUMBER = 9;

    public static Number generateRandomNumber() {
        final int randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
        return new Number(randomNumber);
    }
}