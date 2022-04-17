package view;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class CustomerUI extends JPanel {
    JLabel userName = new JLabel("");
    JButton submit_complaint = new JButton("Submit Complaint");
    JButton viewPreviousTickets = new JButton("View Previous Tickets");
    JButton logout = new JButton("Logout");



    public CustomerUI() {
        setBounds(50, 30, 1180, 620);
        setLayout(null);
        setVisible(false);
        setBackground(Color.decode("#212121"));

        JLabel title = new JLabel("CRM System");
        title.setBounds(0, 0, 203, 38);
        title.setFont(new Font("Helvetica", Font.BOLD, 32));
        title.setForeground(Color.decode("#ffffff"));
        add(title);

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

        JLabel welcomeTxt = new JLabel("Welcome back, ");
        welcomeTxt.setBounds(440, 191, 170, 28);
        welcomeTxt.setFont(new Font("Helvetica", Font.PLAIN, 24));
        welcomeTxt.setForeground(Color.decode("#ffffff"));
        add(welcomeTxt);

        userName.setBounds(607, 191, 140, 28);
        userName.setFont(new Font("Helvetica", Font.PLAIN, 24));
        userName.setForeground(Color.decode("#ffffff"));
        add(userName);

        submit_complaint.setBounds(465, 269, 250, 55);
        submit_complaint.setFocusable(false);
        submit_complaint.setFont(new Font("Helvetica", Font.BOLD, 18));
        submit_complaint.setForeground(Color.white);
        submit_complaint.setBackground(Color.decode("#000000"));
        submit_complaint.setOpaque(true);
        submit_complaint.setBorderPainted(false);
        add(submit_complaint);


        viewPreviousTickets.setBounds(465, 374, 250, 55);
        viewPreviousTickets.setFocusable(false);
        viewPreviousTickets.setFont(new Font("Helvetica", Font.BOLD, 18));
        viewPreviousTickets.setForeground(Color.white);
        viewPreviousTickets.setBackground(Color.decode("#000000"));
        viewPreviousTickets.setOpaque(true);
        viewPreviousTickets.setBorderPainted(false);
        add(viewPreviousTickets);

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

    public void setUserName(JLabel userName) {
        this.userName = userName;
    }

    public JButton getSubmit_complaint() {
        return submit_complaint;
    }

    public JButton getViewPreviousTickets() {
        return viewPreviousTickets;
    }

    public JButton getLogout() {
        return logout;
    }

    public int displayConfirmLogout() {
        int results = JOptionPane.showConfirmDialog(this, "Are you sure you want to logout?", "Confirmation", JOptionPane.YES_NO_OPTION);
        return results;
    }
}
