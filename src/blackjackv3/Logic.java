package blackjackv3;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.plaf.nimbus.State;

public class Logic extends JFrame {

    private int money = 100;
    DBManager db = new DBManager();
    // Login log = new Login();
    
    Logic() {
        System.out.println("Hand value: " + BlackjackWindow.getHandvalue());
        
        Login log = new Login();

        log.setVisible(false);

        String loggedUser = log.getLoginName();

        

        if (BlackjackWindow.getHandvalue() > 21) {
            System.out.println("Bust! You lose.");
            JOptionPane.showMessageDialog(null, "Bust! You lose");
            
            Connection conn = db.getConnection();
            try{
                Statement statement = conn.createStatement();
                //money -= 50;
                statement.execute("UPDATE BLACKJACKDB SET money = money - 50 WHERE username = '" + loggedUser + "'");
                //statement.execute("UPDATE BLACKJACKDB SET money = money + 100 WHERE username = 'dog'");
            }
            catch(Exception e){
                e.printStackTrace();
            }

            System.out.println(loggedUser + "'s balance is: "+ money);



        }
        if (BlackjackWindow.getHandvalue() == 21) {
            System.out.println("Blackjack! You win!");
            JOptionPane.showMessageDialog(null, "Blackjack! You win!");
            money += 100;
            System.out.println("Your balance is: "+ money);
            

            
        }
        if (BlackjackWindow.getHandvalue() < 21) {
            System.out.println("You have " + BlackjackWindow.getHandvalue() + ". Would you like to hit or stay?");
        }
    }

    public void closeWindow(){
        this.dispose();
    
    }

}
