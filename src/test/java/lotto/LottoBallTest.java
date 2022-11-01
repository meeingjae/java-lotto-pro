package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("로또 공 클래스 테스트")
class LottoBallTest {

    @DisplayName("생성 성공")
    @Test
    void create_ball_successIsBonusBallFalse() {
        assertThatNoException().isThrownBy(() -> new LottoBall("1", () -> 0));
    }

    @DisplayName("보너스 로또 공 생성 성공")
    @Test
    void create_ball_successIsBonusBallTrue() {
        assertThatNoException().isThrownBy(() -> new LottoBall("1", () -> 0));
    }

    @DisplayName("생성 실패 - 숫자가 아닌 값 입력")
    @Test
    void create_ball_NumberFormatException() {
        //given:
        LottoBall lottoBall = new LottoBall("asd", () -> 0);
        assertThatThrownBy(lottoBall::getIntNumber).isInstanceOf(NumberFormatException.class);
    }

    @DisplayName("생성 실패 - 로또 숫자 범위를 벗어난 값 입력")
    @Test
    void create_ball_IllegalArgumentException() {
        //given:
        LottoBall lottoBall = new LottoBall("46", () -> 0);
        assertThatThrownBy(lottoBall::getIntNumber).isInstanceOf(IllegalArgumentException.class);
    }
}
