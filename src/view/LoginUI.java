package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoginUI extends JPanel {
    JTextField userNameField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton logInButton = new JButton("Login");
    JRadioButton customer = new JRadioButton("Customer");
    JRadioButton manager = new JRadioButton("Manager");
    ButtonGroup bg = new ButtonGroup();

    public LoginUI() {
        setScreen();
        createElements();

    }

    public void createElements() {
        JLabel title = new JLabel("CRM System");
        title.setBounds(0, 0, 210, 38);
        title.setFont(new Font("Helvetica", Font.BOLD, 32));
        title.setForeground(Color.decode("#ffffff"));
        add(title);

        JLabel header = new JLabel("PLEASE LOGIN");
        header.setBounds(502, 129, 176, 28);
        header.setFont(new Font("Helvetica", Font.PLAIN, 24));
        header.setForeground(Color.decode("#ffffff"));
        add(header);

//        x and y axis
        customer.setBounds(440, 177,110, 30);
        customer.setFont(new Font("Helvetica", Font.PLAIN, 16));
        customer.setForeground(Color.decode("#ffffff"));
        customer.setBackground(Color.decode("#212121"));
        customer    .setOpaque(true);

        manager.setBounds(545, 177, 110, 30);
        manager.setFont(new Font("Helvetica", Font.PLAIN, 16));
        manager.setForeground(Color.decode("#ffffff"));
        manager.setBackground(Color.decode("#212121"));
        manager.setOpaque(true);

        // adding radio buttons to button group
        bg.add(customer);
        bg.add(manager);

        // adding to jpanel
        add(customer);
        add(manager);


        JLabel userName = new JLabel("Username");
        userName.setBounds(440, 226, 100, 23);
        userName.setFont(new Font("Helvetica", Font.PLAIN, 20));
        userName.setForeground(Color.decode("#ffffff"));
        add(userName);

        userNameField.setBounds(440, 259, 300, 50);
        userNameField.setBackground(Color.decode("#ffffff"));
        userNameField.setOpaque(true);
        add(userNameField);

        JLabel passWord = new JLabel("Password");
        passWord.setBounds(440, 329, 100, 23);
        passWord.setFont(new Font("Helvetica", Font.PLAIN, 20));
        passWord.setForeground(Color.decode("#ffffff"));
        add(passWord);

        passwordField.setBounds(440, 362, 300, 50);
        passwordField.setBackground(Color.decode("#ffffff"));
        passwordField.setOpaque(true);
        add(passwordField);

        logInButton.setBounds(440, 442, 300, 50);
        logInButton.setFocusable(false);
        logInButton.setFont(new Font("Helvetica", Font.BOLD, 20));
        logInButton.setForeground(Color.white);
        logInButton.setBackground(Color.decode("#000000"));
        logInButton.setOpaque(true);
        logInButton.setBorderPainted(false);
        add(logInButton);
    }

    public void setScreen() {
        setBounds(50, 30, 1180, 620);
        setLayout(null);
        setVisible(true);
        setBackground(Color.decode("#212121"));
    }

    public JTextField getUserNameField() {
        return userNameField;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public JButton getLogInButton() {
        return logInButton;
    }

    public JRadioButton getCustomer() {
        return customer;
    }

    public JRadioButton getManager() {
        return manager;
    }

    public ButtonGroup getBg() {
        return bg;
    }

    public void displayIncorrectCredentials() {
        JOptionPane.showMessageDialog(this, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void displayNoTypeSpecified() {
        JOptionPane.showMessageDialog(this, "Please specify if you are a customer or manager signing in.", "Error", JOptionPane.ERROR_MESSAGE);
    }

}