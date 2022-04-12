
package controller;

import model.*;
import utility.MainData;
import view.*;
import org.json.simple.JSONObject;
import utility.JsonUtil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.ArrayList;


public class ListCntl {

    private Customer currentCustomer;
    private Manager currentManager;
    private LoginUI theLoginUI;
    private CustomerUI theCustomerUI;
    private ManagerUI theManagerUI;
    private SubmitIssue submitIssue;

    public ListCntl(LoginUI theLoginUI, CustomerUI theCustomerUI, SubmitIssue submitIssue) {
        System.out.println(MainData.getCustomers());
        this.theLoginUI = theLoginUI;
        this.theCustomerUI = theCustomerUI;
        this.submitIssue = submitIssue;
    }

    public void login() {
        theLoginUI.getLogInButton().addActionListener(e -> {
            String username = theLoginUI.getUserNameField().getText();
            String password = String.valueOf(theLoginUI.getPasswordField().getPassword());


            if (username.equals(JsonUtil.readJsonObject("customer.json").get("UserName")) && password.equals(JsonUtil.readJsonObject("customer.json").get("Password")) && theLoginUI.getCustomer().isSelected()) {
                theLoginUI.setVisible(false);
                theCustomerUI.setVisible(true);
                theCustomerUI.getUserName().setText(JsonUtil.readJsonObject("customer.json").get("First Name") + " " + JsonUtil.readJsonObject("customer.json").get("Last Name"));
            } 
            else {
                theLoginUI.displayIncorrectCredentials();
            }

        });
    }

    public void logout() {
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
                MainData.getIssueTickets().add(new IssueTicket(submitIssue.getTextArea().getText(), MainData.getIssueTickets().size()+1,LocalDateTime.now(), false, submitIssue.getComboBox().getSelectedItem().toString()));
                System.out.println(MainData.getIssueTickets());
                System.out.println(submitIssue.getComboBox().getSelectedItem());
                submitIssue.getTextArea().setText("");
                submitIssue.getComboBox().setSelectedIndex(0);
                theCustomerUI.setVisible(true);
                
            }
        });
    }

}
