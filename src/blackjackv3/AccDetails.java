package blackjackv3;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

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
    private JButton backBtn;
    String LoggedName = Login.getLoginName();
    

    AccDetails() {

        this.setTitle("Account Details");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(300, 150);

        Connection conn = db.getConnection();

        try{
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT money FROM BLACKJACKDB WHERE username = '" + LoggedName + "'");
            if (rs.next()) {
                money = rs.getInt("money");
            }
            }
        catch(Exception e){
            e.printStackTrace();
        }


        JLabel userName = new JLabel("Name: " + LoggedName);
        JLabel Money = new JLabel("Money: " + money);

        backBtn = new JButton("Back");
        backBtn.addActionListener(this);

        this.add(Money);
        this.add(userName);
        this.add(backBtn);

        this.setLayout(new GridLayout(3, 1));

        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backBtn) {
            dispose();
            
        }

    }
    

}