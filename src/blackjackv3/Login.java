package blackjackv3;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener {

    JButton ConBtn = new JButton("Sign In");
    JButton CreatBtn = new JButton("Create Account");
    JPanel panel = new JPanel();
    JTextField UserText, NameText, PassText;
    JLabel UserLabel, NameLabel, PassLabel;

    Login() {

        this.setTitle("Login");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(300, 150);

        UserText = new JTextField("", 10); // Set width for username field
        NameText = new JTextField("", 10);
        PassText = new JTextField("", 10);
        UserLabel = new JLabel("Username: ");
        NameLabel = new JLabel("Name: ");
        PassLabel = new JLabel("Password: ");

        this.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;

        constraints.gridx = 0;
        constraints.gridy = 0;
        this.add(UserLabel, constraints);

        constraints.gridx = 1;
        this.add(UserText, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        this.add(NameLabel, constraints);

        constraints.gridx = 1;
        this.add(NameText, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        this.add(PassLabel, constraints);

        constraints.gridx = 1;
        this.add(PassText, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        this.add(ConBtn, constraints);
        ConBtn.addActionListener(this);

        constraints.gridx = 1;
        this.add(CreatBtn, constraints);
        CreatBtn.addActionListener(this);

        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == ConBtn) {

            this.dispose();
            BlackJack game = new BlackJack();
            System.out.println("Sign In Button Clicked");

        } else if (ae.getSource() == CreatBtn) {
            this.dispose();
            CreateAccount account = new CreateAccount();
            account.setVisible(true);
            System.out.println("Create Account Button Clicked");
        }
    }

}
