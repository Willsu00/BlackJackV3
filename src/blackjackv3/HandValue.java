package blackjackv3;

import java.util.List;

public class HandValue {
    private static int value;

    public HandValue(List<Card> deck) {
        value = 0;
        for (Card card : deck) {
            value += card.getValue();
        }
    }

    public static int getValue() {
        return value;
    }

}
