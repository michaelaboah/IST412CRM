package view;

import model.*;

import java.awt.event.ItemEvent;
import java.util.ArrayList;

import controller.*;

public class RecordSearchUI extends javax.swing.JFrame {

    private ListCntl theListCntl;
    private IssueType selectedIssueType;

    public RecordSearchUI(ListCntl theListCntl) {
        this.theListCntl = theListCntl;
        initComponents();
        addALButtons();
    }
    private void initComponents() {

        IssueType[] types  = {IssueType.None, IssueType.PRODUCT, IssueType.SHIPMENT, IssueType.BILLING,
            IssueType.TECH_SUPPORT, IssueType.OTHER};
            pageHeaderLabel = new javax.swing.JLabel();
            issueTypeLabel = new javax.swing.JLabel();
            issueDropdown = new javax.swing.JComboBox<>(types);
            employeeLabel = new javax.swing.JLabel();
            customerLabel = new javax.swing.JLabel();
            managerField = new javax.swing.JTextField();
            customerField = new javax.swing.JTextField();
            searchButton = new javax.swing.JButton();
            resultsBox = new javax.swing.JTextPane();
            jScrollPane = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pageHeaderLabel.setFont(new java.awt.Font("Helvetica", 1, 20)); // NOI18N
        pageHeaderLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pageHeaderLabel.setText("Ticket Records Search");

        issueTypeLabel.setFont(new java.awt.Font("Helvetica", 1, 13)); // NOI18N
        issueTypeLabel.setText("IssueType:");

        employeeLabel.setFont(new java.awt.Font("Helvetica", 1, 13)); // NOI18N
        employeeLabel.setText("Emloyee ID:");

        customerLabel.setFont(new java.awt.Font("Helvetica", 1, 13)); // NOI18N
        customerLabel.setText("Customer ID:");

        searchButton.setFont(new java.awt.Font("Helvetica", 1, 13)); // NOI18N
        searchButton.setText("Find Tickets");

        jScrollPane.setViewportView(resultsBox);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(customerLabel)
                    .addComponent(employeeLabel)
                    .addComponent(issueTypeLabel))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(issueDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(managerField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(customerField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(pageHeaderLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(120, Short.MAX_VALUE)
                .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(pageHeaderLabel)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(issueTypeLabel)
                    .addComponent(issueDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(employeeLabel)
                    .addComponent(managerField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(customerField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>                        

    // Variables declaration - do not modify                     
    private javax.swing.JTextField customerField;
    private javax.swing.JComboBox<IssueType> issueDropdown;
    private javax.swing.JLabel issueTypeLabel;
    private javax.swing.JLabel employeeLabel;
    private javax.swing.JLabel customerLabel;
    private javax.swing.JTextField managerField;
    private javax.swing.JLabel pageHeaderLabel;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextPane resultsBox;
    private javax.swing.JScrollPane jScrollPane;
    // End of variables declaration

    private void addALButtons() {
        issueDropdown.addItemListener(event -> {
            if (event.getStateChange() == ItemEvent.SELECTED) {
                selectedIssueType = (IssueType) issueDropdown.getSelectedItem();
                System.out.println(selectedIssueType);
            }
        });

        searchButton.addActionListener(e -> {
            System.out.println("Something happened");
            ArrayList<IssueTicket> tempList = new ArrayList<>();
            ArrayList<IssueTicket> actualList = IssueTicket.getIssueTicketList();

            Boolean issueTypeSelected = selectedIssueType != null && selectedIssueType != IssueType.None;
            Boolean managerSpecified = !managerField.getText().isEmpty();
            Boolean customerSpecified = !customerField.getText().isEmpty();
            if(issueTypeSelected && managerSpecified && customerSpecified) {
                IssueTicket currentIssueTicket;
                for(int i = 0; i < actualList.size(); i++) {
                    currentIssueTicket = actualList.get(i);
            
                    System.out.println("currentIssueTicket.getIssueType() = " + currentIssueTicket.getIssueType());
                    System.out.println("selectedIssueType = " + selectedIssueType);
                    System.out.println("managerField.getText().toString() = " + managerField.getText().toString());
                    System.out.println("currentIssueTicket.getRecipient().getManagerID().toString() = " + currentIssueTicket.getRecipient().getManagerID().toString());
                    System.out.println("customerField.getText().toString() = " + customerField.getText().toString());
                    System.out.println("currentIssueTicket.getCustOwner().getCustID().toString() = " + currentIssueTicket.getCustOwner().getCustID().toString());
                    System.out.println(currentIssueTicket.getDescription());
                    System.out.println("===================================");

                    if(currentIssueTicket.getIssueType() == selectedIssueType && managerField.getText().toString().equals(currentIssueTicket.getRecipient().getManagerID().toString())
                        && customerField.getText().toString().equals(currentIssueTicket.getCustOwner().getCustID().toString())) {
                            tempList.add(currentIssueTicket);
                        }
                }
            }

            else if(issueTypeSelected && managerSpecified) {
                System.out.println("IssueType field and MangerField found");
                IssueTicket currentIssueTicket;
                for(int i = 0; i < actualList.size(); i++) {
                    currentIssueTicket = actualList.get(i);

                    if(currentIssueTicket.getIssueType() == selectedIssueType 
                        && managerField.getText().toString().equals(currentIssueTicket.getRecipient().getManagerID().toString())) {
                            tempList.add(currentIssueTicket);
                        }
                }

                System.out.println("RESULTS: \n" + tempList.toString());
            }

            else if(managerSpecified && customerSpecified) {
                System.out.println("MangerField and CustomerField found");
                IssueTicket currentIssueTicket;
                for(int i = 0; i < actualList.size(); i++) {
                    currentIssueTicket = actualList.get(i);

                    if(managerField.getText().toString().equals(currentIssueTicket.getRecipient().getManagerID().toString())
                        && customerField.getText().toString().equals(currentIssueTicket.getCustOwner().getCustID().toString())) {
                            tempList.add(currentIssueTicket);
                        }
                }

                System.out.println("RESULTS: \n" + tempList.toString());
            }

            else if(issueTypeSelected && customerSpecified) {
                System.out.println("IssueType field and CustomerField found");
                IssueTicket currentIssueTicket;
                for(int i = 0; i < actualList.size(); i++) {
                    currentIssueTicket = actualList.get(i);

                    if(currentIssueTicket.getIssueType() == selectedIssueType && 
                        customerField.getText().toString().equals(currentIssueTicket.getCustOwner().getCustID().toString())) {
                            tempList.add(currentIssueTicket);
                        }
                }

                System.out.println("RESULTS: \n" + tempList.toString());
            }

            else if(issueTypeSelected) {
                System.out.println("IssueType field found");
                IssueTicket currentIssueTicket;
                for(int i = 0; i < actualList.size(); i++) {
                    currentIssueTicket = actualList.get(i);

                    if(currentIssueTicket.getIssueType() == selectedIssueType) {
                            tempList.add(currentIssueTicket);
                        }
                }

                System.out.println("RESULTS: \n" + tempList.toString());
            }

            else if(customerSpecified) {
                System.out.println("CustomerField found");
                IssueTicket currentIssueTicket;
                for(int i = 0; i < actualList.size(); i++) {
                    currentIssueTicket = actualList.get(i);

                    if(customerField.getText().toString()
                        .equals(currentIssueTicket.getCustOwner().getCustID().toString())) {
                            tempList.add(currentIssueTicket);
                        }
                }

                System.out.println("RESULTS: \n" + tempList.toString());
            }

            else if(managerSpecified) {
                System.out.println("MangerField found");
                IssueTicket currentIssueTicket;
                for(int i = 0; i < actualList.size(); i++) {
                    currentIssueTicket = actualList.get(i);

                    if(managerField.getText().toString()
                        .equals(currentIssueTicket.getRecipient().getManagerID().toString())) {
                            tempList.add(currentIssueTicket);
                    }
                }
            }

            else {
                System.out.println("None fields filled in. Displaying all.");
                tempList = IssueTicket.getIssueTicketList();
            }

            System.out.println("RESULTS:");
                for(int i = 0; i < tempList.size(); i++) {
                    System.out.println(tempList.get(i).getName());
                }
        });
    }

}
