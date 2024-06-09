package blackjackv3;

import javax.swing.JFrame;

public class BlackJack {

    BlackJack() {
        startGame();
        

        BlackjackWindow window = new BlackjackWindow();

    }

    public static void main(String[] args) {
        

        
        new Login();
        
        DBManager dbmanager = new DBManager();
        dbmanager.getConnection();
        
        

    }

    public void startGame() {

    }

}
