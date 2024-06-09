package blackjackv3;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Logic extends JFrame {

    Logic() {
        System.out.println("Hand value: " + BlackjackWindow.getHandvalue());

        if (BlackjackWindow.getHandvalue() > 21) {
            System.out.println("Bust! You lose.");
            JOptionPane.showMessageDialog(null, "Bust! You lose");
        }
        if (BlackjackWindow.getHandvalue() == 21) {
            System.out.println("Blackjack! You win!");
            JOptionPane.showMessageDialog(null, "Blackjack! You win!");
        }
        if (BlackjackWindow.getHandvalue() < 21) {
            System.out.println("You have " + BlackjackWindow.getHandvalue() + ". Would you like to hit or stay?");
        }
    }

}
