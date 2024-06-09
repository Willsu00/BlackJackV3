package blackjackv3;

public class Card {
    private int rank;
    

    public Card(int rank) {
        this.rank = rank;
    }

    public void printCard() {
        System.out.println(" _______ ");
        System.out.println("|" + rank + "      |");
        System.out.println("|       |");
        System.out.println("|       |");
        System.out.println("|       |");
        System.out.println("|_____" + rank + "|");
    }

    public int getValue() {
        return rank;
    }

    @Override
    public String toString() {
        String formattedRank = rank > 9 ? "10" : String.format("%2s", rank);
        return " _______ " + System.lineSeparator() +
                "|" + formattedRank + "           |" + System.lineSeparator() +
                "|              |" + System.lineSeparator() +
                "|           " + formattedRank + "|" + System.lineSeparator() +
                "|_______|";
    }
}
