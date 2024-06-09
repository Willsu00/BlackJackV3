package blackjackv3;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Logic extends JFrame {

    private int money = 100;

    Logic() {
        System.out.println("Hand value: " + BlackjackWindow.getHandvalue());

        if (BlackjackWindow.getHandvalue() > 21) {
            System.out.println("Bust! You lose.");
            JOptionPane.showMessageDialog(null, "Bust! You lose");
            money -= 50;
            System.out.println("Your balance is: " + money);

            this.dispose();

            // BlackJack game = new BlackJack();

        }
        if (BlackjackWindow.getHandvalue() == 21) {
            System.out.println("Blackjack! You win!");
            JOptionPane.showMessageDialog(null, "Blackjack! You win!");
            money += 100;
            System.out.println("Your balance is: " + money);

            this.dispose();

            // BlackJack game = new BlackJack();

        }
        if (BlackjackWindow.getHandvalue() < 21) {
            System.out.println("You have " + BlackjackWindow.getHandvalue() + ". Would you like to hit or stay?");
        }
    }

    public int getMoney() {
        return money;
    }

}
