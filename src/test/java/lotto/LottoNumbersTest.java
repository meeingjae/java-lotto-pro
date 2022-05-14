package lotto;

import lotto.model.LottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("LottoNumbers는 ")
public class LottoNumbersTest {
    private static Stream<List> provideInvalidSizeList() {
        return Stream.of(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                Arrays.asList(1, 2, 3, 4, 5)
        );
    }

    @DisplayName("6개의 LottoNumber가 아니라면 예외를 던진다.")
    @ParameterizedTest
    @MethodSource("provideInvalidSizeList")
    void invalidLottoNumberSize(List<Integer> numbers) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoNumbers(numbers));
    }
}