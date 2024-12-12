package racingcar.view;

import racingcar.domain.dto.Results;
import racingcar.domain.dto.Winner;

public class OutputView {

    private static final String STEP = "-";

    public void printErrorMessage(final String message) {
        System.out.println(message);
    }

    public void printResult(final Results results) {
        System.out.println("실행 결과");
        results.results().stream()
                .forEach(result -> System.out.printf("%s : %s%n", result.name(), printPosition(result.position())));
        System.out.println();
    }

    private String printPosition(int position) {
        StringBuilder sb = new StringBuilder();
        while (position-- > 0) {
            sb.append(STEP);
        }
        return sb.toString();
    }

    public void printWinner(final Winner winner) {
        String winners = String.join(", ", winner.winners());
        System.out.println("최종 우승자 : " + winners);
    }
}
