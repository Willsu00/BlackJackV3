package blackjackv3;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CreateAccount extends JFrame implements ActionListener {

    String username;
    String password;
    JTextField UserText;
    JTextField PassText;
    String file_directory = "./logins/";
    DBManager db = new DBManager();

    CreateAccount() {

        this.setTitle("Create Account");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(300, 150);

        JLabel UserLabel = new JLabel("Username: ");
        UserText = new JTextField("", 10);
        JLabel PassLabel = new JLabel("Password: ");
        PassText = new JTextField("", 10);
        JButton CreateBtn = new JButton("Create Account");
        JButton BackBtn = new JButton("Back");

        System.out.println(PassText);

        this.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;

        constraints.gridx = 0;
        constraints.gridy = 0;
        this.add(UserLabel, constraints);

        constraints.gridx = 1;
        this.add(UserText, constraints);

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

        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 2; // span across two columns
        constraints.anchor = GridBagConstraints.CENTER; // position the button in the center
        this.add(BackBtn, constraints);
        BackBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Login();
            }
        });

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String username = UserText.getText();
        String password = PassText.getText();

        // check if fields are empty

        // if (name.equals("") || username.equals("") || password.equals("")) {
        // JOptionPane.showMessageDialog(this, "Please fill out all fields");
        // return;
        // }

        File dir = new File("./Logins/");
        File[] files = dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                // Only accept files that end with .txt
                return name.endsWith(".txt");
            }
        });

        boolean accountExists = false;

        for (File file : files) {
            try {
                // Create a BufferedReader to read the file
                BufferedReader reader = new BufferedReader(new FileReader(file));

                // Read the username, name, and password from the file
                String fileUsername = reader.readLine();
                String fileName = reader.readLine();
                String filePassword = reader.readLine();

                // Close the BufferedReader
                reader.close();

                // If the entered username, name, and password match the ones in the file,
                // set the accountExists flag to true and break out of the loop
                if (username.equals(fileUsername) && password.equals(filePassword)) {
                    accountExists = true;
                    break;
                }
            } catch (IOException ex) {
                // If there was an error reading the file, print an error message
                System.out.println("Error: Login not matching");
            }
        }

        try {
            // Create a new file in the Logins folder
            File file = new File("./Logins/" + username + ".txt");
            file.getParentFile().mkdirs(); // Will create Logins directory if it doesn't exist

            PrintWriter writer = new PrintWriter(file);
            writer.println(username);
            writer.println(password);
            writer.close();

        } catch (FileNotFoundException ex) {
            System.out.println("Error Writing");
        }

        if (accountExists) {
            JOptionPane.showMessageDialog(this, "Account Already Exists");
            System.out.println("Account Already Exists");
        } else {
            try {
                // If the account doesn't exist, create a new file for the account
                File file = new File("./Logins/" + username + ".txt");

                // If the Logins directory does not exist, it will be created
                file.getParentFile().mkdirs();

                // Create a PrintWriter to write to the file
                PrintWriter writer = new PrintWriter(file);

                // Write the entered username, name, and password to the file
                writer.println(username);
                writer.println(password);

                // Close the PrintWriter
                writer.close();

                Connection conn = db.getConnection();

                try{
                    Statement statement = conn.createStatement();
                    statement.execute("INSERT INTO BLACKJACKDB (USERNAME) VALUES ('" + username + "')");
                    statement.execute("UPDATE BLACKJACKDB SET MONEY = 100 WHERE USERNAME = '" + username +"'");
                } catch (Exception ex){
                    ex.printStackTrace();
                }

                this.dispose();
                new Login();

            } catch (FileNotFoundException ex) {
                // If the file could not be created for some reason, print an error message
                System.out.println("Error Writing");

            }
        }

        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method
        // 'actionPerformed'");
    }

}