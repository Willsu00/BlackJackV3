package blackjackv3;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
//import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class BlackjackWindow extends JFrame implements ActionListener {

    private int i = 0;

    JButton HitBtn = new JButton("Hit");
    JButton StandBtn = new JButton("Stand");
    JButton QuitBtn = new JButton("Quit");

    private JPanel textAreaPanel;
    private JTextArea textArea1;
    private JPanel buttonPanel;

    BlackjackWindow() {

        this.setTitle("BlackJack");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setResizable(false);
        this.setVisible(true);

        JPanel buttonPanel = new JPanel(); // create a new panel

        buttonPanel.add(HitBtn); // add buttons to the panel
        HitBtn.addActionListener(this);
        buttonPanel.add(StandBtn);
        StandBtn.addActionListener(this);
        buttonPanel.add(QuitBtn);
        QuitBtn.addActionListener(this);

        this.add(buttonPanel, BorderLayout.SOUTH); // add the panel to the SOUTH region

        Deck deck = new Deck();
        deck.shuffleDeck();

        Card card = deck.getCard(0);
        Card card1 = deck.getCard(1);

        JPanel textAreaPanel = new JPanel((new FlowLayout())); // create a new panel for the JTextAreas

        JTextArea textArea = new JTextArea();
        textArea.setText(card.toString());
        textArea.setBounds(50, -1000, 200, 200); // x, y, width, height
        textArea.setFont(new Font("Serif", Font.PLAIN, 20)); // font name, style, size
        textAreaPanel.add(textArea); // add the JTextArea to the new panel

        JTextArea textArea1 = new JTextArea();
        textArea1.setText(card1.toString());
        textArea1.setBounds(50, 400, 200, 200); // x, y, width, height
        textArea1.setFont(new Font("Serif", Font.PLAIN, 20)); // font name, style, size
        textAreaPanel.add(textArea1); // add the JTextArea to the new panel

        this.add(textAreaPanel, BorderLayout.CENTER); // add the new panel to the NORTH region

        this.add(buttonPanel, BorderLayout.SOUTH); // add the buttonPanel to the SOUTH region

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == HitBtn) {
            // Create a new card
            if (ae.getSource() == HitBtn) {
                i++;
                // Create a new card
                Deck deck = new Deck();
                Card newCard = deck.getCard(i); // Replace 'deck.drawCard()' with the method you use to draw a new card

                // Create a new JTextArea to display the new card
                JTextArea newCardTextArea = new JTextArea();
                newCardTextArea.setText(newCard.toString());
                newCardTextArea.setFont(new Font("Serif", Font.PLAIN, 20)); // font name, style, size

                // Initialize textAreaPanel if it's null
                if (textAreaPanel == null) {
                    textAreaPanel = new JPanel();
                    this.add(textAreaPanel, BorderLayout.CENTER); // add the textAreaPanel to the CENTER region
                }

                // Add the new JTextArea to the panel
                textAreaPanel.add(newCardTextArea);

                // Refresh the panel
                textAreaPanel.revalidate();
                textAreaPanel.repaint();

                // Initialize buttonPanel if it's null
                if (buttonPanel == null) {
                    buttonPanel = new JPanel();
                    // Add buttons to buttonPanel here
                    this.add(buttonPanel, BorderLayout.SOUTH); // add the buttonPanel to the SOUTH region
                }

                this.setVisible(true);
            } else if (ae.getSource() == StandBtn) {

            } else if (ae.getSource() == QuitBtn) {
                System.exit(0); // close the application

            }
        }
    }

}