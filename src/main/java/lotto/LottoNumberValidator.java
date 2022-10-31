package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.LottoNumberBag.WINNING_NUMBER_INPUT_SPLIT_DELIMETER;

public class LottoNumberValidator {

    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;

    private LottoNumberValidator() {
        throw new IllegalStateException("유틸 클래스 입니다");
    }

    public static void validNumbers(List<Integer> numbers) {
        validNumberSize(numbers);
        validUnique(numbers);
        validRange(numbers);
    }

    public static void validInputNumber(String input) {
        try {
            Arrays.stream(input.split(WINNING_NUMBER_INPUT_SPLIT_DELIMETER))
                    .forEach(Integer::parseInt);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("당첨 번호는 모두 숫자여야 합니다. 입력 값:" + input);
        }
    }

    private static void validNumberSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(
                    "로또 숫자는 6개여야 합니다. 입력 값:" + numbers.stream()
                            .map(String::valueOf)
                            .collect(Collectors.joining(",")));
        }
    }

    private static void validUnique(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException(
                    "로또 숫자는 중복되지 않은 값이어야 합니다. 입력 값:" + numbers.stream()
                            .map(String::valueOf)
                            .collect(Collectors.joining(",")));
        }
    }

    private static void validRange(List<Integer> numbers) {
        for (int number : numbers) {
            checkRange(number);
        }
    }

    private static void checkRange(int number) {
        if (number < LOTTO_MIN_NUMBER || LOTTO_MAX_NUMBER < number) {
            throw new IllegalArgumentException(
                    "로또 숫자는 1 ~ 45 사이의 값이어야 합니다. 입력 값:" + number);
        }
    }

}
