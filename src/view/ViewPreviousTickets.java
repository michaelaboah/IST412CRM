package view;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ViewPreviousTickets extends JPanel {
    JButton backBtn = new JButton("Back");
//    @note: for testing
    JLabel id = new JLabel("192929");
    JLabel type = new JLabel("some order");
    JLabel dates = new JLabel("2022/02/03");
    TextArea getIssueTxt = new TextArea();
    JButton prevBtn = new JButton("<");
    JButton nextBtn = new JButton(">");


    public ViewPreviousTickets() {
        setScreen();
        createElements();

    }

    public void createElements() {
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

        JLabel title = new JLabel("Previous Issued Tickets");
        title.setBounds(482, 116, 230, 23);
        title.setFont(new Font("Helvetica", Font.BOLD, 20));
        title.setForeground(Color.decode("#ffffff"));
        add(title);

        JLabel ticketIDTxt = new JLabel("Ticket ID: ");
        ticketIDTxt.setBounds(321, 195, 100, 19);
        ticketIDTxt.setFont(new Font("Helvetica", Font.BOLD, 16));
        ticketIDTxt.setForeground(Color.decode("#ffffff"));
        add(ticketIDTxt);

        id.setBounds(400,195, 100, 19 );
        id.setFont(new Font("Helvetica", Font.BOLD, 16));
        id.setForeground(Color.decode("#ffffff"));
        add(id);

        JLabel issueTypeTxt = new JLabel("Order No.: ");
        issueTypeTxt.setBounds(321, 229, 100, 19);
        issueTypeTxt.setFont(new Font("Helvetica", Font.BOLD, 16));
        issueTypeTxt.setForeground(Color.decode("#ffffff"));
        add(issueTypeTxt);

        type.setBounds(420, 229, 100, 19);
        type.setFont(new Font("Helvetica", Font.BOLD, 16));
        type.setForeground(Color.decode("#ffffff"));
        add(type);

        JLabel dataIssueTxt = new JLabel("Date Issued: ");
        dataIssueTxt.setBounds(675, 229, 100, 19);
        dataIssueTxt.setFont(new Font("Helvetica", Font.BOLD, 16));
        dataIssueTxt.setForeground(Color.decode("#ffffff"));
        add(dataIssueTxt);

        dates.setBounds(780, 229, 100, 19);
        dates.setFont(new Font("Helvetica", Font.BOLD, 16));
        dates.setForeground(Color.decode("#ffffff"));
        add(dates);

        JLabel problemDescriptionTxt = new JLabel("Problem description:");
        problemDescriptionTxt.setBounds(321, 278, 150, 21);
        problemDescriptionTxt.setFont(new Font("Helvetica", Font.PLAIN, 14));
        problemDescriptionTxt.setForeground(Color.white);
        add(problemDescriptionTxt);

        getIssueTxt.setBounds(321, 304, 538, 150);
        getIssueTxt.setFocusable(false);
        add(getIssueTxt);

        prevBtn.setBounds(171, 356, 60, 60);
        prevBtn.setFocusable(false);
        prevBtn.setFont(new Font("Helvetica", Font.BOLD, 24));
        prevBtn.setForeground(Color.white);
        prevBtn.setBackground(Color.decode("#212121"));
        prevBtn.setOpaque(true);
        prevBtn.setBorderPainted(false);
        add(prevBtn);

        nextBtn.setBounds(1009, 356, 60, 60);
        nextBtn.setFocusable(false);
        nextBtn.setFont(new Font("Helvetica", Font.BOLD, 24));
        nextBtn.setForeground(Color.white);
        nextBtn.setBackground(Color.decode("#212121"));
        nextBtn.setOpaque(true);
        nextBtn.setBorderPainted(false);
        add(nextBtn);
    }

    public void setScreen() {
        setBounds(50, 30, 1180, 620);
        setLayout(null);
        setVisible(false);
        setBackground(Color.decode("#212121"));
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

    // public void setId(JLabel id) {
    //     this.id = id;
    // }

    public void setId(String id) {
        this.id.setText(id);
    }

    public JLabel getType() {
        return type;
    }

    // public void setType(JLabel type) {
    //     this.type = type;
    // }

    public void setType(String type) {
        this.type.setText(type);
    }
    public JLabel getDates() {
        return dates;
    }

    // public void setDates(JLabel dates) {
    //     this.dates = dates;
    // }
    public void setDates(String dates) {
        this.dates.setText(dates);
    }

    public TextArea getGetIssueTxt() {
        return getIssueTxt;
    }

    // public void setGetIssueTxt(TextArea getIssueTxt) {
    //     this.getIssueTxt = getIssueTxt;
    // }

    public void setIssueTxt(String issue) {
        this.getIssueTxt.setText(issue);
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