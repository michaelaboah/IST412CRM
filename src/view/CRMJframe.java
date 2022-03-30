package view;

import javax.swing.*;
import java.awt.*;

public class CRMJframe extends JFrame {
    public CRMJframe() {
        setTitle("CRM");
        setSize(1280, 720);
        setLayout(null);
        getContentPane().setBackground(Color.decode("#212121"));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
    }
}
