package view;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import controller.*;
import model.IssueOrder;
import utility.MainData;

public class SubmitIssue extends JPanel {

    JComboBox comboBox;
    TextArea textArea = new TextArea();
    JButton submitForm = new JButton("SUBMIT");
    JButton backBtn = new JButton("Back");


    public SubmitIssue() {
        setBounds(50, 30, 1180, 620);
        setLayout(null);
        setVisible(false);
        setBackground(Color.decode("#212121"));

        JLabel date = new JLabel("" + LocalDate.now());
        date.setBounds(1080, 0, 100, 21);
        date.setForeground(Color.white);
        date.setFont(new Font("Helvetica", Font.PLAIN, 18));
        add(date);

        JLabel time = new JLabel("" + LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm a")));
        time.setBounds(1095, 31, 80, 21);
        time.setFont(new Font("Helvetica", Font.PLAIN, 18));
        time.setForeground(Color.white  );
        add(time);

        JLabel header = new JLabel("Submit an issue");
        header.setBounds(503, 96, 200, 28);
        header.setFont(new Font("Helvetica", Font.BOLD, 24));
        header.setForeground(Color.decode("#ffffff"));
        add(header);

        JLabel description = new JLabel("What do you need help with?");
        description.setBounds(360, 154, 240, 21);
        description.setFont(new Font("Helvetica", Font.PLAIN, 18));
        description.setForeground(Color.decode("#ffffff"));
        add(description);

        textArea.setBounds(360, 243, 459, 200);
        add(textArea);

        comboBox = new JComboBox();
        comboBox.setBounds(619, 154, 200, 21);
        add(comboBox);

        submitForm.setBounds(360, 473, 200, 50);
        submitForm.setFocusable(false);
        submitForm.setFont(new Font("Helvetica", Font.BOLD, 18));
        submitForm.setForeground(Color.white);
        submitForm.setBackground(Color.decode("#000000"));
        submitForm.setOpaque(true);
        submitForm.setBorderPainted(false);
        add(submitForm);


        backBtn.setBounds(0, 0, 130, 50);
        backBtn.setFocusable(false);
        backBtn.setFont(new Font("Helvetica", Font.BOLD, 18));
        backBtn.setForeground(Color.white);
        backBtn.setBackground(Color.decode("#484848"));
        backBtn.setOpaque(true);
        backBtn.setBorderPainted(false);
        add(backBtn);
    }

    public JComboBox getComboBox() {
        return comboBox;
    }

    public void setComboBox(JComboBox comboBox) {
        this.comboBox = comboBox;
    }

    public TextArea getTextArea() {
        return textArea;
    }

    public void setTextArea(TextArea textArea) {
        this.textArea = textArea;
    }

    public JButton getSubmitForm() {
        return submitForm;
    }

    public JButton getBackBtn() {
        return backBtn;
    }

    public void setComboBox() {
        comboBox.removeAllItems();
        Integer custID = ListCntl.getCurrentCustomer().getCustID();
        ArrayList<IssueOrder> temp = new ArrayList<>();
        System.out.println("custID:" + custID);
        for (IssueOrder order : MainData.getIssueOrders()) {
            System.out.println("current order's custID: " + order.getCustID());
            if (order.getCustID() == custID) {
                System.out.println("match!");
                temp.add(order);
            }
        }
        System.out.println(temp);
        for (IssueOrder order : temp) {
            comboBox.addItem(order);
        }
    }

    public void displayConfirmation() {
        JOptionPane.showMessageDialog(this, "Your ticket has been submitted. \n\n" + "Topic: " + getComboBox().getSelectedItem() + "\n\nMessage: " + getTextArea().getText(), "Confirmation", JOptionPane.INFORMATION_MESSAGE);
    }

    public void displayEmptyForm() {
        JOptionPane.showMessageDialog(this, "Please fill out the required field", "Error", JOptionPane.ERROR_MESSAGE);
    }
}