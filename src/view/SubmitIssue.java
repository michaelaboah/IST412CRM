package view;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class SubmitIssue extends JPanel {

    JComboBox comboBox;
    TextArea textArea = new TextArea();
    JButton submitForm = new JButton("SUBMIT");
    JButton logout = new JButton("Logout");
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

        String topics[] = {"-", "A product I ordered", "A current shipment progress", "Billing", "Website", "Other"};

        comboBox = new JComboBox(topics);
        comboBox.setBounds(619, 154, 200, 21);
        add(comboBox);

        textArea.setBounds(360, 243, 459, 200);
        add(textArea);

        submitForm.setBounds(360, 473, 200, 50);
        submitForm.setFocusable(false);
        submitForm.setFont(new Font("Helvetica", Font.BOLD, 18));
        submitForm.setForeground(Color.white);
        submitForm.setBackground(Color.decode("#000000"));
        submitForm.setOpaque(true);
        submitForm.setBorderPainted(false);
        add(submitForm);

        logout.setBounds(1050, 570, 130, 50);
        logout.setFocusable(false);
        logout.setFont(new Font("Helvetica", Font.BOLD, 18));
        logout.setForeground(Color.white);
        logout.setBackground(Color.decode("#484848"));
        logout.setOpaque(true);
        logout.setBorderPainted(false);
        add(logout);


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

    public TextArea getTextArea() {
        return textArea;
    }

    public JButton getSubmitForm() {
        return submitForm;
    }

    public JButton getLogout() {
        return logout;
    }

    public JButton getBackBtn() {
        return backBtn;
    }
}
