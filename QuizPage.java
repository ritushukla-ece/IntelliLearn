package intellilearn;

import javax.swing.*;
import java.awt.event.*;

public class QuizPage {

    JFrame frame;
    JLabel questionLabel;
    JRadioButton opt1, opt2, opt3, opt4;
    JButton nextButton;

    ButtonGroup group;

    int questionIndex = 0;
    int score = 0;

    String questions[] = {
            "Java is developed by?",
            "Which keyword is used for inheritance?",
            "Which company developed Java?"
    };

    String options[][] = {
            {"James Gosling","Dennis Ritchie","Bjarne Stroustrup","Guido van Rossum"},
            {"this","super","extends","import"},
            {"Microsoft","Sun Microsystems","Google","Apple"}
    };

    int answers[] = {0,2,1};

    QuizPage() {

        frame = new JFrame("Quiz - IntelliLearn");
        frame.setSize(500,400);
        frame.setLayout(null);

        questionLabel = new JLabel();
        questionLabel.setBounds(50,50,400,30);
        frame.add(questionLabel);

        opt1 = new JRadioButton();
        opt1.setBounds(50,100,300,30);

        opt2 = new JRadioButton();
        opt2.setBounds(50,130,300,30);

        opt3 = new JRadioButton();
        opt3.setBounds(50,160,300,30);

        opt4 = new JRadioButton();
        opt4.setBounds(50,190,300,30);

        group = new ButtonGroup();
        group.add(opt1);
        group.add(opt2);
        group.add(opt3);
        group.add(opt4);

        frame.add(opt1);
        frame.add(opt2);
        frame.add(opt3);
        frame.add(opt4);

        nextButton = new JButton("Next");
        nextButton.setBounds(200,250,100,30);
        frame.add(nextButton);

        loadQuestion();

        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int selected = -1;

                if(opt1.isSelected()) selected = 0;
                if(opt2.isSelected()) selected = 1;
                if(opt3.isSelected()) selected = 2;
                if(opt4.isSelected()) selected = 3;

                if(selected == answers[questionIndex]) {
                    score++;
                }

                questionIndex++;

                if(questionIndex < questions.length) {
                    loadQuestion();
                } else {

                    JOptionPane.showMessageDialog(frame,"Your Score: " + score + " / " + questions.length);
                    frame.dispose();

                }

                group.clearSelection();
            }
        });

        frame.setVisible(true);
    }

    void loadQuestion() {

        questionLabel.setText(questions[questionIndex]);

        opt1.setText(options[questionIndex][0]);
        opt2.setText(options[questionIndex][1]);
        opt3.setText(options[questionIndex][2]);
        opt4.setText(options[questionIndex][3]);

    }
}