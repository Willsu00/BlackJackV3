package blackjackv3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AccDetails extends JFrame implements ActionListener {
    
    String usernane;
    int money;
    DBManager db = new DBManager();

    AccDetails(){
        
        this.setTitle("Account Details");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(300, 150);

        JLabel userName = new JLabel("Name: ");
        JLabel money = new JLabel("Money: ");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}