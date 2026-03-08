package intellilearn;

import javax.swing.*;
import java.awt.event.*;

public class LoginPage {

    JFrame frame;
    JTextField username;
    JPasswordField password;
    JButton loginButton;

    LoginPage() {

        frame = new JFrame("Login - IntelliLearn");
        frame.setSize(400,300);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel userLabel = new JLabel("Username");
        userLabel.setBounds(50,60,100,30);
        frame.add(userLabel);

        username = new JTextField();
        username.setBounds(150,60,150,30);
        frame.add(username);

        JLabel passLabel = new JLabel("Password");
        passLabel.setBounds(50,110,100,30);
        frame.add(passLabel);

        password = new JPasswordField();
        password.setBounds(150,110,150,30);
        frame.add(password);

        loginButton = new JButton("Login");
        loginButton.setBounds(150,170,100,30);
        frame.add(loginButton);

        // LOGIN BUTTON ACTION
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String user = username.getText();
                String pass = new String(password.getPassword());

                if(user.equals("ritu") && pass.equals("3456")) {

                    JOptionPane.showMessageDialog(frame,"Login Successful");
                    frame.dispose();
                    new Dashboard(user);   // username dashboard ko bhejna

                } else {

                    JOptionPane.showMessageDialog(frame,"Invalid Username or Password");

                }
            }
        });

        frame.setVisible(true);
    }
}