package view;

import controller.ListCntl;
import model.Manager.ManagerType;

import java.security.AllPermission;

import javax.swing.*;

public class ManagerUI extends javax.swing.JFrame {

    private ListCntl theListCntl;


    public ManagerUI(ListCntl listCntl) {
        this.theListCntl = listCntl;
        this.initComponents();
        this.addALButtons();
    }

    private void initComponents() {

        welcomeLabel = new javax.swing.JLabel();
        resolveButton = new javax.swing.JButton();
        managerTypeLabel = new javax.swing.JLabel();
        recordsButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        welcomeLabel.setFont(new java.awt.Font("Helvetica", 1, 20)); // NOI18N
        welcomeLabel.setText("Welcome, " + theListCntl.getCurrentManager().getFName() + ".");
        welcomeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        welcomeLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        

        resolveButton.setBackground(new java.awt.Color(41,134,204));
        resolveButton.setFont(new java.awt.Font("Helvetica", 1, 13)); // NOI18N
        resolveButton.setForeground(new java.awt.Color(255, 255, 255));
        resolveButton.setOpaque(true);
        resolveButton.setBorderPainted(false);
        resolveButton.setText("Resolve Assigned Issue Tickets");

        managerTypeLabel.setFont(new java.awt.Font("Helvetica", 0, 13)); // NOI18N
        managerTypeLabel.setText("Manager Type: " + theListCntl.getCurrentManager().getManagerType());

        if(theListCntl.getCurrentManager().getManagerType() != ManagerType.CRM) {
            recordsButton.setBackground(new java.awt.Color(91,91,91));
        }
        else {
            recordsButton.setBackground(new java.awt.Color(41,134,204));
        }
        recordsButton.setForeground(new java.awt.Color(255, 255, 255));
        recordsButton.setFont(new java.awt.Font("Helvetica", 1, 13)); // NOI18N
        
        recordsButton.setOpaque(true);
        recordsButton.setBorderPainted(false);
        recordsButton.setFont(new java.awt.Font("Helvetica", 1, 13)); // NOI18N
        recordsButton.setText("Review Issue Ticket Records");

        javax.swing.GroupLayout menuLayout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(menuLayout);
        menuLayout.setHorizontalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(welcomeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(menuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuLayout.createSequentialGroup()
                        .addComponent(managerTypeLabel)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuLayout.createSequentialGroup()
                        .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(recordsButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(resolveButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        menuLayout.setVerticalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(managerTypeLabel)
                .addGap(26, 26, 26)
                .addComponent(welcomeLabel)
                .addGap(18, 18, 18)
                .addComponent(resolveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(recordsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        pack();
        
        if(theListCntl.getCurrentManager().getManagerType() != ManagerType.CRM) {
            recordsButton.setEnabled(false);
        }
    }// </editor-fold>>                         


    // Variables declaration - do not modify                     
    private javax.swing.JLabel welcomeLabel;
    private javax.swing.JLabel managerTypeLabel;
    private javax.swing.JButton recordsButton;
    private javax.swing.JButton resolveButton;
    // End of variables declaration
  

    private void addALButtons() {
        recordsButton.addActionListener(e -> {
            System.out.println("records clicked!");
            this.setVisible(false);
            RecordSearchUI recordUI = new RecordSearchUI(theListCntl);
            recordUI.setVisible(true);
        });

        resolveButton.addActionListener(e -> {
            System.out.println("resolve clicked!");
        });
    }
}    
