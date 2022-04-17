
package controller;

import model.*;
import utility.MainData;
import view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ListCntl {

    private LoginUI theLoginUI;
    private CustomerUI theCustomerUI;
    private ManagerUI theManagerUI;
    private SubmitIssue submitIssue;
    private ViewPreviousTickets previousTickets;
    private static Customer currentCustomer;
    private Integer currentTicket;

    public ListCntl(LoginUI theLoginUI, CustomerUI theCustomerUI, SubmitIssue submitIssue, ViewPreviousTickets previousTickets) {
        this.theLoginUI = theLoginUI;
        this.theCustomerUI = theCustomerUI;
        this.submitIssue = submitIssue;
        this.previousTickets = previousTickets;
        this.currentTicket = 0;

    }

    public void submitComplaint() {
        theCustomerUI.getSubmit_complaint().addActionListener(e -> {
            theCustomerUI.setVisible(false);
            submitIssue.setComboBox();
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
                IssueOrder selectedOrder = (IssueOrder) submitIssue.getComboBox().getSelectedItem();
                submitIssue.displayConfirmation();
                submitIssue.setVisible(false);
                MainData.getIssueTickets().add(new IssueTicket(submitIssue.getTextArea().getText(), 
                    MainData.getIssueTickets().size()+1, LocalDateTime.now(), false, selectedOrder.getOrderID(), 
                    "", currentCustomer.getCustID()));
                SavedData.saveAll("SaveMore.json");
                
                submitIssue.getTextArea().setText("");
                submitIssue.getComboBox().setSelectedIndex(0);

                theCustomerUI.setVisible(true);
                
            }
        });
    }

    public void previousTickets() {
        ArrayList<IssueTicket> filteredTickets = new ArrayList<>();

        theCustomerUI.getViewPreviousTickets().addActionListener(e -> {
            for (IssueTicket ticket : MainData.getIssueTickets()) {
                if (ticket.getCustID() == currentCustomer.getCustID()) {
                    filteredTickets.add(ticket);
                }
            }
            //if user has no tickets, return to main menu
            if (filteredTickets.size() == 0) {
                return;
            }

            theCustomerUI.setVisible(false);
            previousTickets.setVisible(true);
            parsePreviousTicket(currentTicket, filteredTickets);
        });
        previousTickets.getBackBtn().addActionListener(e -> {
            previousTickets.setVisible(false);
            theCustomerUI.setVisible(true);
        });
        previousTickets.getPrevBtn().addActionListener(e -> {
            if(currentTicket > 0) {
                currentTicket --;
            }
            else {
                currentTicket = filteredTickets.size() - 1;
            }
            parsePreviousTicket(currentTicket, filteredTickets);
        });
        previousTickets.getNextBtn().addActionListener(e -> {
            if(currentTicket < filteredTickets.size() -1 ) {
                currentTicket++;
            }
            else {
                currentTicket = 0;
            }
            parsePreviousTicket(currentTicket, filteredTickets);
        });
    }

    public void parsePreviousTicket(int currentTicket, ArrayList<IssueTicket> filteredTickets) {
        previousTickets.setId(filteredTickets.get(currentTicket).getReportID().toString());
        previousTickets.setType(filteredTickets.get(currentTicket).getOrderID().toString());
        previousTickets.setDates(filteredTickets.get(currentTicket).getDateTime().toString());
        previousTickets.setIssueTxt(filteredTickets.get(currentTicket).getDescription());
    }

    public void customers() {
        theLoginUI.getLogInButton().addActionListener(e -> {
            String username = theLoginUI.getUserNameField().getText();
            String password = String.valueOf(theLoginUI.getPasswordField().getPassword());
            
            for(int i = 0; i < MainData.getCustomers().size(); i++) {
                if (username.equals(MainData.getCustomers().get(i).getUsername()) && password.equals(MainData.getCustomers().get(i).getPassword()) && theLoginUI.getCustomer().isSelected()) {
                    currentCustomer = MainData.getCustomers().get(i);
                    theLoginUI.setVisible(false);
                    theCustomerUI.setVisible(true);
                    theCustomerUI.getUserName().setText(MainData.getCustomers().get(i).getFirstName() + " " + MainData.getCustomers().get(i).getLastName());
                    return;
                }
            }
            theLoginUI.displayIncorrectCredentials();
        });

        theCustomerUI.getLogout().addActionListener(e -> {
            int results = theCustomerUI.displayConfirmLogout();
            if (results == 0) {
                theCustomerUI.setVisible(false);
                theLoginUI.setVisible(true);
                theLoginUI.getUserNameField().setText("");
                theLoginUI.getPasswordField().setText("");
                theLoginUI.getBg().clearSelection();
                currentCustomer = null;
            }
        });
    }

    public static Customer getCurrentCustomer() {
        return currentCustomer;
    }

}