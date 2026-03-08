package intellilearn;

import javax.swing.*;

public class Dashboard {

    JFrame frame;

    Dashboard(String username) {

        frame = new JFrame("Dashboard - IntelliLearn");
        frame.setSize(500,400);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Welcome " + username);
        label.setBounds(180,50,200,30);
        frame.add(label);

        JButton notesButton = new JButton("Add Notes");
        notesButton.setBounds(180,120,150,30);
        frame.add(notesButton);
        notesButton.addActionListener(e -> {
            new AddNotes();
        });

        JButton viewButton = new JButton("View Notes");
        viewButton.setBounds(180,170,150,30);
        frame.add(viewButton);
        viewButton.addActionListener(e -> {
            new ViewNotes();
        });

        JButton quizButton = new JButton("Start Quiz");
        quizButton.setBounds(180,220,150,30);
        frame.add(quizButton);
        quizButton.addActionListener(e -> {
            new QuizPage();
        });

        JButton logoutButton = new JButton("Logout");
        logoutButton.setBounds(180,270,150,30);
        frame.add(logoutButton);

        logoutButton.addActionListener(e -> {
            frame.dispose();
            new LoginPage();
        });

        frame.setVisible(true);
    }
}