package intellilearn;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class ViewNotes {

    JFrame frame;
    JTextArea notesArea;
    JButton deleteButton;

    ViewNotes() {

        frame = new JFrame("View Notes");
        frame.setSize(500,400);
        frame.setLayout(null);

        notesArea = new JTextArea();
        notesArea.setBounds(50,50,380,200);
        frame.add(notesArea);

        JButton loadButton = new JButton("Load Notes");
        loadButton.setBounds(50,270,120,30);
        frame.add(loadButton);

        deleteButton = new JButton("Delete Notes");
        deleteButton.setBounds(200,270,150,30);
        frame.add(deleteButton);

        // LOAD NOTES
        loadButton.addActionListener(e -> {

            try {
                BufferedReader br = new BufferedReader(new FileReader("notes.txt"));
                notesArea.read(br,null);
                br.close();
            } catch(Exception ex) {
                ex.printStackTrace();
            }

        });

        // DELETE NOTES
        deleteButton.addActionListener(e -> {

            int confirm = JOptionPane.showConfirmDialog(frame,"Delete all notes?");

            if(confirm == 0) {

                try {
                    PrintWriter pw = new PrintWriter("notes.txt");
                    pw.print("");
                    pw.close();

                    notesArea.setText("");

                    JOptionPane.showMessageDialog(frame,"Notes Deleted");

                } catch(Exception ex) {
                    ex.printStackTrace();
                }

            }

        });

        frame.setVisible(true);
    }
}