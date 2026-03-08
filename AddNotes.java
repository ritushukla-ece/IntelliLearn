package intellilearn;

import javax.swing.*;
import java.io.*;

public class AddNotes {

    JFrame frame;
    JTextArea textArea;
    JButton saveButton;

    AddNotes() {

        frame = new JFrame("Add Notes");
        frame.setSize(500,400);
        frame.setLayout(null);

        JLabel label = new JLabel("Write your notes:");
        label.setBounds(50,20,200,30);
        frame.add(label);

        textArea = new JTextArea();
        textArea.setBounds(50,60,380,200);
        frame.add(textArea);

        saveButton = new JButton("Save Note");
        saveButton.setBounds(180,280,120,30);
        frame.add(saveButton);

        saveButton.addActionListener(e -> {
            try {
                FileWriter writer = new FileWriter("notes.txt", true);
                writer.write(textArea.getText() + "\n");
                writer.close();

                JOptionPane.showMessageDialog(frame,"Note Saved!");

                textArea.setText("");

            } catch(Exception ex) {
                ex.printStackTrace();
            }
        });

        frame.setVisible(true);
    }
}