package view;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ManagerUI extends JPanel {

    JLabel userName = new JLabel("");
    JButton resolveBtn = new JButton("Resolve Issue Ticket");
    JButton reviewBtn = new JButton("Review All Tickets");
    JButton logout = new JButton("Logout");

    public ManagerUI()  {
        setBounds(50, 30, 1180, 620);
        setLayout(null);
        setVisible(false);
        setBackground(Color.decode("#212121"));

        JLabel title = new JLabel("CRM System");
        title.setBounds(0, 0, 203, 38);
        title.setFont(new Font("Helvetica", Font.BOLD, 32));
        title.setForeground(Color.decode("#ffffff"));
        add(title);

        JLabel welcomeTxt = new JLabel("Welcome back, ");
        welcomeTxt.setBounds(432, 244, 322, 28);
        welcomeTxt.setFont(new Font("Helvetica", Font.PLAIN, 24));
        welcomeTxt.setForeground(Color.decode("#ffffff"));
        add(welcomeTxt);

        userName.setBounds(599, 244, 200, 28);
        userName.setFont(new Font("Helvetica", Font.PLAIN, 24));
        userName.setForeground(Color.decode("#ffffff"));
        add(userName);

        resolveBtn.setBounds(298, 322, 230, 55);
        resolveBtn.setFocusable(false);
        resolveBtn.setFont(new Font("Helvetica", Font.BOLD, 18));
        resolveBtn.setForeground(Color.white);
        resolveBtn.setBackground(Color.decode("#000000"));
        resolveBtn.setOpaque(true);
        resolveBtn.setBorderPainted(false);
        add(resolveBtn);

        JLabel orTxt = new JLabel("OR");
        orTxt.setBounds(578, 339, 30, 21);
        orTxt.setFont(new Font("Helvetica", Font.PLAIN, 18));
        orTxt.setForeground(Color.decode("#ffffff"));
        add(orTxt);

        reviewBtn.setBounds(652, 322, 230, 55);
        reviewBtn.setFocusable(false);
        reviewBtn.setFont(new Font("Helvetica", Font.BOLD, 18));
        reviewBtn.setForeground(Color.white);
        reviewBtn.setBackground(Color.decode("#000000"));
        reviewBtn.setOpaque(true);
        reviewBtn.setBorderPainted(false);
        add(reviewBtn);

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

        logout.setBounds(1050, 570, 130, 50);
        logout.setFocusable(false);
        logout.setFont(new Font("Helvetica", Font.BOLD, 18));
        logout.setForeground(Color.white);
        logout.setBackground(Color.decode("#484848"));
        logout.setOpaque(true);
        logout.setBorderPainted(false);
        add(logout);

    }


    public JLabel getUserName() {
        return userName;
    }

    public JButton getResolveBtn() {
        return resolveBtn;
    }

    public JButton getReviewBtn() {
        return reviewBtn;
    }

    public void setUserName(JLabel userName) {
        this.userName = userName;
    }

    public JButton getLogout() {
        return logout;
    }
}
