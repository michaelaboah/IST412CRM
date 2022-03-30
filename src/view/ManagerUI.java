package view;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ManagerUI extends JPanel {

    JLabel name = new JLabel("Carlos Flores");
    JLabel ticketAmount = new JLabel("1");
    JButton resolveBtn = new JButton("Resolve Issue Ticket");
    JButton reviewBtn = new JButton("Review All Tickets");
    JButton logout = new JButton("Logout");

    public ManagerUI()  {
        setBounds(50, 30, 1180, 620);
        setLayout(null);
        setVisible(true);
        setBackground(Color.decode("#212121"));

        JLabel title = new JLabel("CRM System");
        title.setBounds(0, 0, 203, 38);
        title.setFont(new Font("Helvetica", Font.BOLD, 32));
        title.setForeground(Color.decode("#ffffff"));
        add(title);

        JLabel welcomeTxt = new JLabel("Welcome back, ");
        welcomeTxt.setBounds(429, 208, 322, 28);
        welcomeTxt.setFont(new Font("Helvetica", Font.PLAIN, 24));
        welcomeTxt.setForeground(Color.decode("#ffffff"));
        add(welcomeTxt);

        name.setBounds(596, 208, 200, 28);
        name.setFont(new Font("Helvetica", Font.PLAIN, 24));
        name.setForeground(Color.decode("#ffffff"));
        add(name);

        JLabel description = new JLabel("You have ");
        description.setBounds(408, 286, 90, 21);
        description.setFont(new Font("Helvetica", Font.PLAIN, 18));
        description.setForeground(Color.decode("#ffffff"));
        add(description);

        ticketAmount.setBounds(487, 286, 20, 21);
        ticketAmount.setFont(new Font("Helvetica", Font.BOLD, 18));
        ticketAmount.setForeground(Color.decode("#ffffff"));
        add(ticketAmount);

        JLabel descContinue = new JLabel("issues ticket pending to be resolve.");
        descContinue.setBounds(500, 286, 280, 21);
        descContinue.setFont(new Font("Helvetica", Font.PLAIN, 18));
        descContinue.setForeground(Color.decode("#ffffff"));
        add(descContinue);

        resolveBtn.setBounds(298, 357, 230, 55);
        resolveBtn.setFocusable(false);
        resolveBtn.setFont(new Font("Helvetica", Font.BOLD, 18));
        resolveBtn.setForeground(Color.white);
        resolveBtn.setBackground(Color.decode("#000000"));
        resolveBtn.setOpaque(true);
        resolveBtn.setBorderPainted(false);
        add(resolveBtn);

        JLabel orTxt = new JLabel("OR");
        orTxt.setBounds(578, 374, 30, 21);
        orTxt.setFont(new Font("Helvetica", Font.PLAIN, 18));
        orTxt.setForeground(Color.decode("#ffffff"));
        add(orTxt);

        reviewBtn.setBounds(652, 357, 230, 55);
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




}
