package blackjackv3;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CreateAccount extends JFrame implements ActionListener {

    CreateAccount() {

        this.setTitle("Create Account");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(300, 150);

        JTextField UserText = new JTextField("", 10);
        JTextField NameText = new JTextField("", 10);
        JTextField PassText = new JTextField("", 10);
        JLabel UserLabel = new JLabel("Username: ");
        JLabel NameLabel = new JLabel("Name: ");
        JLabel PassLabel = new JLabel("Password: ");
        JButton CreateBtn = new JButton("Create Account");

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
        constraints.gridwidth = 2; // span across two columns
        constraints.anchor = GridBagConstraints.CENTER; // position the button in the center
        this.add(CreateBtn, constraints);
        CreateBtn.addActionListener(this);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        this.dispose();
        new Login();

        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}