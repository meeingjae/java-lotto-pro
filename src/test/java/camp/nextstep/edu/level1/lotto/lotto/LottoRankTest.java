package camp.nextstep.edu.level1.lotto.lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRankTest {

    @Test
    void 일치하는_수에_해당하는_로또_랭크를_반환해야_한다() {
        List<Integer> winnerNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> firstNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> secondNumbers = Arrays.asList(1, 2, 3, 4, 5, 45);
        List<Integer> thirdNumbers = Arrays.asList(1, 2, 3, 4, 5, 7);
        List<Integer> forthNumbers = Arrays.asList(1, 2, 3, 4, 7, 45);
        List<Integer> fifthNumbers = Arrays.asList(1, 2, 3, 7, 8, 45);

        LottoNumbers winnerLottoNumbers = new LottoNumbers(winnerNumbers);
        LottoNumbers firstLottoNumbers = new LottoNumbers(firstNumbers);
        LottoNumbers secondLottoNumbers = new LottoNumbers(secondNumbers);
        LottoNumbers thirdLottoNumbers = new LottoNumbers(thirdNumbers);
        LottoNumbers forthLottoNumbers = new LottoNumbers(forthNumbers);
        LottoNumbers fifthLottoNumbers = new LottoNumbers(fifthNumbers);

        LottoNumber bonusBall = new LottoNumber(45);

        assertThat(LottoRank.findLottoRank(firstLottoNumbers, winnerLottoNumbers, bonusBall)).isEqualTo(LottoRank.FIRST);
        assertThat(LottoRank.findLottoRank(secondLottoNumbers, winnerLottoNumbers, bonusBall)).isEqualTo(LottoRank.SECOND);
        assertThat(LottoRank.findLottoRank(thirdLottoNumbers, winnerLottoNumbers, bonusBall)).isEqualTo(LottoRank.THIRD);
        assertThat(LottoRank.findLottoRank(forthLottoNumbers, winnerLottoNumbers, bonusBall)).isEqualTo(LottoRank.FORTH);
        assertThat(LottoRank.findLottoRank(fifthLottoNumbers, winnerLottoNumbers, bonusBall)).isEqualTo(LottoRank.FIFTH);
    }
}