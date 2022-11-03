package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class LottoBag {

    private final List<Lotto> lottoList;

    public static final Money LOTTO_PRICE = new Money(1000);

    public LottoBag(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public List<WinningResult> getResult(WinningLottoBallBag winningLottoBallBag) {
        return lottoList.stream()
                .map(lotto -> lotto.getResult(winningLottoBallBag))
                .collect(Collectors.toList());
    }

    public long lottoSize() {
        return lottoList.size();
    }

    public List<NumberBag> getLottoNumbers() {
        return lottoList.stream()
                .map(Lotto::getNumbers)
                .collect(Collectors.toList());
    }

    public static int availableCount(Money money) {
        return money.divide(LOTTO_PRICE);
    }
}
