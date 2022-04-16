
package controller;

import model.*;
import utility.MainData;
import view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListCntl {

    private LoginUI theLoginUI;
    private CustomerUI theCustomerUI;
    private ManagerUI theManagerUI;
    private SubmitIssue submitIssue;
    private ViewPreviousTickets previousTickets;

    public ListCntl(LoginUI theLoginUI, CustomerUI theCustomerUI, SubmitIssue submitIssue, ViewPreviousTickets previousTickets) {
        this.theLoginUI = theLoginUI;
        this.theCustomerUI = theCustomerUI;
        this.submitIssue = submitIssue;
        this.previousTickets = previousTickets;

    }

    public void submitComplaint() {
        theCustomerUI.getSubmit_complaint().addActionListener(e -> {
            theCustomerUI.setVisible(false);
            submitIssue.setVisible(true);
        });

        submitIssue.getBackBtn().addActionListener(e -> {
            submitIssue.setVisible(false);
            theCustomerUI.setVisible(true);
        });

        submitIssue.getSubmitForm().addActionListener(e -> {

            if (submitIssue.getTextArea().getText().isEmpty() && submitIssue.getComboBox().getSelectedItem().equals(submitIssue.getComboBox().getItemAt(0))) {
                
                submitIssue.displayEmptyForm();
            } else {
                submitIssue.displayConfirmation();
                submitIssue.setVisible(false);
//                MainData.getIssueTickets().add(new IssueTicket(submitIssue.getTextArea().getText(), MainData.getIssueTickets().size()+1,LocalDateTime.now(), false, submitIssue.getComboBox().getSelectedItem().toString()));
                System.out.println(MainData.getIssueTickets());
                System.out.println(submitIssue.getComboBox().getSelectedItem());
                submitIssue.getTextArea().setText("");
                submitIssue.getComboBox().setSelectedIndex(0);
                theCustomerUI.setVisible(true);
                
            }
        });
    }

    public void previousTickets() {
        theCustomerUI.getViewPreviousTickets().addActionListener(e -> {
            theCustomerUI.setVisible(false);
            previousTickets.setVisible(true);
        });
        previousTickets.getBackBtn().addActionListener(e -> {
            previousTickets.setVisible(false);
            theCustomerUI.setVisible(true);
        });
    }

    public void customers() {
        theLoginUI.getLogInButton().addActionListener(e -> {
            String username = theLoginUI.getUserNameField().getText();
            String password = String.valueOf(theLoginUI.getPasswordField().getPassword());

            if (username.equals(MainData.getCustomers().get(0).getUsername()) && password.equals(MainData.getCustomers().get(0).getPassword()) && theLoginUI.getCustomer().isSelected()) {
                theLoginUI.setVisible(false);
                theCustomerUI.setVisible(true);
                theCustomerUI.getUserName().setText(MainData.getCustomers().get(0).getFirstName() + " " + MainData.getCustomers().get(0).getLastName());
            }
            else {
                theLoginUI.displayIncorrectCredentials();
            }

        });

        theCustomerUI.getLogout().addActionListener(e -> {
            int results = theCustomerUI.displayConfirmLogout();
            if (results == 0) {
                theCustomerUI.setVisible(false);
                theLoginUI.setVisible(true);
                theLoginUI.getUserNameField().setText("");
                theLoginUI.getPasswordField().setText("");
                theLoginUI.getBg().clearSelection();
            }
        });
    }

}
