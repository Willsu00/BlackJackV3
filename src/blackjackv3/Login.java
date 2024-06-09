package blackjackv3;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
        // NameText = new JTextField("", 10);
        PassText = new JTextField("", 10);
        UserLabel = new JLabel("Username: ");
        // NameLabel = new JLabel("Name: ");
        PassLabel = new JLabel("Password: ");

        this.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;

        constraints.gridx = 0;
        constraints.gridy = 0;
        this.add(UserLabel, constraints);

        constraints.gridx = 1;
        this.add(UserText, constraints);

        // constraints.gridx = 0;
        // constraints.gridy = 1;
        // this.add(NameLabel, constraints);

        // constraints.gridx = 1;
        // this.add(NameText, constraints);

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

            // start of login check

            boolean idCheck = false;
            String enteredUser = UserText.getText();
            String enteredPass = PassText.getText();
            // String enteredName = NameText.getText();

            File dir = new File("./Logins/"); // specify your directory if not current
            File[] files = dir.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(".txt");
                }
            });

            for (File file : files) {
                try {
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    String fileUsername = reader.readLine();
                    // String fileName = reader.readLine();
                    String filePassword = reader.readLine();
                    reader.close();

                    if (enteredUser.equals(fileUsername)
                            /* && enteredName.equals(fileName) */ && enteredPass.equals(filePassword)) {
                        idCheck = true;
                        break;
                    }
                } catch (IOException ex) {
                    System.out.println("Error: Login not matching");
                }
            }

            if (idCheck) {
                this.dispose();
                BlackJack game = new BlackJack();
                System.out.println("Sign In Button Clicked");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
                System.out.println("Login Failed");
            }
            // end of login check
           

        } else if (ae.getSource() == CreatBtn) {
            this.dispose();
            CreateAccount account = new CreateAccount();
            account.setVisible(true);
            System.out.println("Create Account Button Clicked");
        }
    }

}
