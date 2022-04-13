package view;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ResolveIssue extends JPanel {
    JButton backBtn = new JButton("Back");
//    @note: default values for testing
    JLabel id = new JLabel("id: 910202920");
    JLabel fullName = new JLabel("Alex Harper");
    JLabel dates = new JLabel("2022-04-12");
    TextArea getIssueTxt = new TextArea();
    TextArea submitResponse = new TextArea();
    JButton resolveIssue = new JButton("Resolve Issue");
    JButton prevBtn = new JButton("<");
    JButton nextBtn = new JButton(">");

    public ResolveIssue() {
        setBounds(50, 30, 1180, 620);
        setLayout(null);
        setVisible(true);
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

        backBtn.setBounds(0, 0, 130, 50);
        backBtn.setFocusable(false);
        backBtn.setFont(new Font("Helvetica", Font.BOLD, 18));
        backBtn.setForeground(Color.white);
        backBtn.setBackground(Color.decode("#484848"));
        backBtn.setOpaque(true);
        backBtn.setBorderPainted(false);
        add(backBtn);

        id.setBounds(531, 36, 150, 21);
        id.setFont(new Font("Helvetica", Font.BOLD, 18));
        id.setForeground(Color.white );
        add(id);

        JLabel custNameTxt = new JLabel("Customer Name: ");
        custNameTxt.setBounds(321, 77, 170, 21);
        custNameTxt.setFont(new Font("Helvetica", Font.BOLD, 18));
        custNameTxt.setForeground(Color.white);
        add(custNameTxt);

        fullName.setBounds(476, 78, 100, 19);
        fullName.setFont(new Font("Helvetica", Font.PLAIN, 16));
        fullName.setForeground(Color.white );
        add(fullName);

        JLabel dateIssueTxt = new JLabel("Date Issue: ");
        dateIssueTxt.setBounds(630, 77, 116, 21);
        dateIssueTxt.setFont(new Font("Helvetica", Font.BOLD, 18));
        dateIssueTxt.setForeground(Color.white);
        add(dateIssueTxt);

        dates.setBounds(738, 79, 150, 16);
        dates.setFont(new Font("Helvetica", Font.PLAIN, 16));
        dates.setForeground(Color.white);
        add(dates);

        JLabel problemDescriptionTxt = new JLabel("Problem description:");
        problemDescriptionTxt.setBounds(321, 118, 150, 21);
        problemDescriptionTxt.setFont(new Font("Helvetica", Font.PLAIN, 14));
        problemDescriptionTxt.setForeground(Color.white);
        add(problemDescriptionTxt);

        getIssueTxt.setBounds(321, 144, 538, 150);
        add(getIssueTxt);


        JLabel submitResponseTxt = new JLabel("Submit Response:");
        submitResponseTxt.setBounds(321, 324, 116, 21);
        submitResponseTxt.setFont(new Font("Helvetica", Font.PLAIN, 14));
        submitResponseTxt.setForeground(Color.white);
        add(submitResponseTxt);

        submitResponse.setBounds(321, 350, 538, 150);
        add(submitResponse);

        resolveIssue.setBounds(480, 530, 230, 55);
        resolveIssue.setFocusable(false);
        resolveIssue.setFont(new Font("Helvetica", Font.BOLD, 18));
        resolveIssue.setForeground(Color.white);
        resolveIssue.setBackground(Color.decode("#484848"));
        resolveIssue.setOpaque(true);
        resolveIssue.setBorderPainted(false);
        add(resolveIssue);

        prevBtn.setBounds(130, 285, 60, 60);
        prevBtn.setFocusable(false);
        prevBtn.setFont(new Font("Helvetica", Font.BOLD, 24));
        prevBtn.setForeground(Color.white);
        prevBtn.setBackground(Color.decode("#212121"));
        prevBtn.setOpaque(true);
        prevBtn.setBorderPainted(false);
        add(prevBtn);

        nextBtn.setBounds(969, 285, 60, 60);
        nextBtn.setFocusable(false);
        nextBtn.setFont(new Font("Helvetica", Font.BOLD, 24));
        nextBtn.setForeground(Color.white);
        nextBtn.setBackground(Color.decode("#212121"));
        nextBtn.setOpaque(true);
        nextBtn.setBorderPainted(false);
        add(nextBtn);

    }

    public JButton getBackBtn() {
        return backBtn;
    }

    public void setBackBtn(JButton backBtn) {
        this.backBtn = backBtn;
    }

    public JLabel getId() {
        return id;
    }

    public void setId(JLabel id) {
        this.id = id;
    }

    public JLabel getFullName() {
        return fullName;
    }

    public void setFullName(JLabel fullName) {
        this.fullName = fullName;
    }

    public JLabel getDates() {
        return dates;
    }

    public void setDates(JLabel dates) {
        this.dates = dates;
    }

    public TextArea getGetIssueTxt() {
        return getIssueTxt;
    }

    public void setGetIssueTxt(TextArea getIssueTxt) {
        this.getIssueTxt = getIssueTxt;
    }

    public TextArea getSubmitResponse() {
        return submitResponse;
    }

    public void setSubmitResponse(TextArea submitResponse) {
        this.submitResponse = submitResponse;
    }

    public JButton getResolveIssue() {
        return resolveIssue;
    }

    public void setResolveIssue(JButton resolveIssue) {
        this.resolveIssue = resolveIssue;
    }

    public JButton getPrevBtn() {
        return prevBtn;
    }

    public void setPrevBtn(JButton prevBtn) {
        this.prevBtn = prevBtn;
    }

    public JButton getNextBtn() {
        return nextBtn;
    }

    public void setNextBtn(JButton nextBtn) {
        this.nextBtn = nextBtn;
    }
}
