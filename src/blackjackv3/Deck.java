package blackjackv3;

import java.util.ArrayList;
//import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {
    private List<Card> deck;
    Random random = new Random();

    int card;
    int card1;

    public Deck() {
        int[] ranks = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11 };
        this.deck = new ArrayList<Card>();
        for (int rank : ranks) {
            deck.add(new Card(rank));
        }
    }

    public void shuffleDeck() {
        for (int i = 0; i < deck.size(); i++) {
            int ran = random.nextInt(deck.size());
            Card currentCard = deck.get(i);
            Card randomCard = deck.get(ran);

            deck.set(i, randomCard);
            deck.set(ran, currentCard);

        }
    }

    public void printDeck() {
        for (Card card : deck) {
            // System.out.println(card.getValue());
        }
    }

    public Card getCard(int index) {
        return deck.get(index);
    }
}
