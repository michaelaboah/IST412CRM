
package controller;

import model.*;
import utility.MainData;
import view.*;

import java.rmi.registry.LocateRegistry;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Controls the interactions between CRM UI interface (view) and backend (model)
 * 
 * @author Michael Aboah, Nathan Carr, Lamees Eltohami, Henry Hoffman, Liam Kirkland, Edwin Reyes Rodriguez
 * @version 04/17/22
 * 
 */
public class ListCntl {

    private static final java.time.Duration Duration = null;
    private LoginUI theLoginUI;
    private CustomerUI theCustomerUI;
    private SubmitIssue submitIssue;
    private ViewPreviousTickets previousTickets;
    private ManagerUI managerUI;
    private static Customer currentCustomer;
    private static Manager currentManager;
    private Integer currentTicket;
    private Integer currentRecord;
    private ArrayList<IssueTicket> unresolvedTickets;
    private ArrayList<IssueTicket> filteredTickets;
    private LocalDateTime lastSubmission;
    Duration duration;

    // Uncomment once Manager front/back end is fully developed
    // private ManagerUI theManagerUI;


    /**
     * Creates ListCntl constructor
     * 
     * @param theLoginUI        LoginUI view class instance
     * @param theCustomerUI     CustomerUI view class instance
     * @param submitIssue       SubmitIssue view class instance
     * @param previousTickets   ViewPreviousTickets view class instance
     * @param managerUI         ManagerUI view class instance
     */
    public ListCntl(LoginUI theLoginUI, CustomerUI theCustomerUI, SubmitIssue submitIssue, 
        ViewPreviousTickets previousTickets, ManagerUI managerUI) {
        this.theLoginUI = theLoginUI;
        this.theCustomerUI = theCustomerUI;
        this.submitIssue = submitIssue;
        this.previousTickets = previousTickets;
        this.managerUI = managerUI;
        this.currentTicket = 0;
        this.unresolvedTickets = new ArrayList<>();

    }

    /**
     * Launches the "submit complaint" UI/use case
     * 
     */
    public void submitComplaint() {
        theCustomerUI.getSubmit_complaint().addActionListener(e -> {
            buildOrderSelection();
            if (submitIssue.getComboBox().getItemCount() == 0) {
                theCustomerUI.displayNoOrders();
                return;
            }
            theCustomerUI.setVisible(false);
            submitIssue.setVisible(true);
        });

        submitIssue.getBackBtn().addActionListener(e -> {
            submitIssue.setVisible(false);
            theCustomerUI.setVisible(true);
        });

        submitIssue.getSubmitForm().addActionListener(e -> {
            if(checkSpam()) {
                return;
            }
            if(submitTicket()) {
                submitIssue.displayConfirmation();
                submitIssue.setVisible(false);
                submitIssue.getTextArea().setText("");
                submitIssue.getComboBox().setSelectedIndex(0);
                theCustomerUI.setVisible(true);
                SavedData.saveAll("SaveMore.json");
            }
            else {
                submitIssue.displayEmptyForm();
            }
        });
    }

    public void buildOrderSelection() {
        submitIssue.setComboBox();
        if (submitIssue.getComboBox().getItemCount() == 0) {
            submitIssue.getSubmitForm().setEnabled(false);
        }
    }

    public Boolean submitTicket() {
        if (submitIssue.getTextArea().getText().isEmpty() && submitIssue.getComboBox().getSelectedItem().equals(submitIssue.getComboBox().getItemAt(0))) {
            return false;
        } 

        IssueOrder selectedOrder = (IssueOrder) submitIssue.getComboBox().getSelectedItem();
        MainData.getIssueTickets().add(new IssueTicket(submitIssue.getTextArea().getText(), 
            MainData.getIssueTickets().size() + 1, LocalDateTime.now(), false, selectedOrder.getOrderID(), 
            "", currentCustomer.getCustID()));
        
        lastSubmission = LocalDateTime.now();

        return true;
    }

    public Boolean checkSpam() {
        if (lastSubmission != null) {
            duration = java.time.Duration.between(lastSubmission, LocalDateTime.now());
            if (duration.getSeconds() < 5) {
                System.out.println("Spam detected. Blocking all subsequent submissions. Until 5 seconds elapsed.");
                return true;
            }
        }

        return false;
    }

    /**
     * Launches the "view previous tickets" UI/use case
     * 
     */
    public void previousTickets() {
        theCustomerUI.getViewPreviousTickets().addActionListener(e -> {
            filteredTickets = filterIssueTickets();
            //if user has no tickets, return to main menu
            if (filteredTickets.size() == 0) {
                theCustomerUI.displayEmptyList();
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

    public ArrayList<IssueTicket> filterIssueTickets() {
        ArrayList<IssueTicket> filteredTickets = new ArrayList<>();
        if(filteredTickets.size() > 0) {
            filteredTickets.clear();
        }
        for (IssueTicket ticket : MainData.getIssueTickets()) {
            if (ticket.getCustID() == currentCustomer.getCustID()) {
                filteredTickets.add(ticket);
            }
        }
        return filteredTickets;
    }

    /**
     * Sets the current viewable ticket in ticket history based on index in list
     * 
     * @param currentTicket     integer marking the current index of the currently viewing ticket
     * @param filteredTickets   arraylist of all issuetickets that the current customer has made
     */
    public void parsePreviousTicket(int currentTicket, ArrayList<IssueTicket> filteredTickets) {
        LocalDateTime date = filteredTickets.get(currentTicket).getDateTime();
        previousTickets.setId(filteredTickets.get(currentTicket).getReportID().toString());
        previousTickets.setType(filteredTickets.get(currentTicket).getOrderID().toString()); 
        previousTickets.setDates(date.getMonthValue() + "/" + date.getDayOfMonth() + "/" + date.getYear());
        previousTickets.setIssueTxt(filteredTickets.get(currentTicket).getDescription());
    }

    /**
     * Handles customer user data generation upon login and logout
     * 
     */
    public void logInOut() {
        theLoginUI.getLogInButton().addActionListener(e -> {
            String username = theLoginUI.getUserNameField().getText();
            String password = String.valueOf(theLoginUI.getPasswordField().getPassword());
            // loginUser(username, password);
            if (!theLoginUI.getCustomer().isSelected() && !theLoginUI.getManager().isSelected()) {
                theLoginUI.displayNoTypeSpecified();
                return;
            }
            if (!loginUser(username, password)) {
                theLoginUI.displayIncorrectCredentials();
            }
        });

        theCustomerUI.getLogout().addActionListener(e -> {
            logoutCustomer();
        });

        managerUI.getLogout().addActionListener(e -> {
            logoutManager();
        });
    }

    public Boolean loginUser(String username, String password) {
        for(int i = 0; i < MainData.getCustomers().size(); i++) {
            if (username.equals(MainData.getCustomers().get(i).getUsername()) && password.equals(MainData.getCustomers().get(i).getPassword()) && theLoginUI.getCustomer().isSelected()) {
                currentCustomer = MainData.getCustomers().get(i);
                theLoginUI.setVisible(false);
                theCustomerUI.setVisible(true);
                theCustomerUI.getUserName().setText("Welcome back, " + MainData.getCustomers().get(i).getFirstName() + " " + MainData.getCustomers().get(i).getLastName());
                return true;
            }
        }
        for(int i = 0; i < MainData.getManagers().size(); i++) {
            // System.out.println("Current username: " + MainData.getManagers().get(i).getUsername());
            // System.out.println("Current password: " + MainData.getManagers().get(i).getPassword());
            if (username.equals(MainData.getManagers().get(i).getUsername()) && password.equals(MainData.getManagers().get(i).getPassword()) && theLoginUI.getManager().isSelected()) {
                // unresolvedTickets = new ArrayList<>(); // For testing purposes only
                unresolvedTickets = generateUnresolvedList();
                currentManager = MainData.getManagers().get(i);
                theLoginUI.setVisible(false);
                managerUI.setVisible(true);
                currentRecord = 0;

                //Lock interactions if no tickets exist
                if(emptyListCheck()) {
                    parseManagerUI(currentRecord);
                    return true;
                }
            
                parseManagerUI(currentRecord);
                return true;
            }
        }
        return false;
    }

    public Boolean emptyListCheck() {
        if(unresolvedTickets.isEmpty()) {
            managerUI.getNextBtn().setEnabled(false);
            managerUI.getPrevBtn().setEnabled(false);
            managerUI.getResolveIssue().setEnabled(false);
            managerUI.getSubmitResponse().setEditable(false);
            return true;
        }
        return false;
    }

    public void logoutCustomer() {
        int results = theCustomerUI.displayConfirmLogout();
        if (results == 0) {
            theCustomerUI.setVisible(false);
            theLoginUI.setVisible(true);
            theLoginUI.getUserNameField().setText("");
            theLoginUI.getPasswordField().setText("");
            theLoginUI.getBg().clearSelection();
            currentCustomer = null;
        }
    }

    public void logoutManager() {
        int results = theCustomerUI.displayConfirmLogout();
        if (results == 0) {
            managerUI.setVisible(false);
            theLoginUI.setVisible(true);
            theLoginUI.getUserNameField().setText("");
            theLoginUI.getPasswordField().setText("");
            theLoginUI.getBg().clearSelection();
            currentManager = null;
        }
    }
    
    public static Customer getCurrentCustomer() {
        return currentCustomer;
    }

    public static Manager getCurrentManager() {
        return currentManager;
    }

    public void manager() {
        managerUI.getNextBtn().addActionListener(e -> {
            traverseForwardManager();
        });

        managerUI.getPrevBtn().addActionListener(e -> {
            traverseBackwardManager();
        });

        managerUI.getResolveIssue().addActionListener(e -> {
            
            if(!resolveIssue()) {
                managerUI.displayEmptyForm();
            }
            else {
                managerUI.displayConfirmation();
                SavedData.saveAll("SaveMore.json");
            }
        });
    }

    public Boolean resolveIssue() {
        String resolution = managerUI.getSubmitResponse().getText();
        if(resolution.equals("")) {
            return false;
        }
        IssueTicket currentTicket = unresolvedTickets.get(currentRecord);
        currentTicket.setIsResolved(true);
        currentTicket.setResponse(resolution);
        currentTicket.setDescription(currentTicket.getDescription() + "\n\nResponse: " + resolution);
        unresolvedTickets.remove(currentTicket);
        if(currentRecord > unresolvedTickets.size() -1 ) {
            currentRecord = 0;
        }
        System.out.println("Current Record: " + currentRecord);
        parseManagerUI(currentRecord);
        managerUI.getSubmitResponse().setText("");
        return true;
    }
    
    public void traverseForwardManager() {
        System.out.println("Next clicked");
        if(currentRecord < unresolvedTickets.size() -1 ) {
            currentRecord++;
        }
        else {
            currentRecord = 0;
        }
        System.out.println("Current Record: " + currentRecord);
        parseManagerUI(currentRecord);
    }

    public void traverseBackwardManager() {
        System.out.println("Prev clicked");
        if(currentRecord > 0) {
            currentRecord --;
        }
        else {
            currentRecord = unresolvedTickets.size() - 1;
        }
        System.out.println("Current Record: " + currentRecord);
        parseManagerUI(currentRecord);
    }

    public void parseManagerUI(int currentRecord) {
        if (unresolvedTickets.size() == 0) {
            System.out.println("There are no issue ticket records to review.");
            managerUI.setId("ID: N/A");
            managerUI.setFullName("N/A");
            managerUI.setDates("N/A");
            managerUI.setGetIssueTxt("N/A");
            managerUI.getSubmitResponse().setText("No tickets to respond to.");
            return;
        }
        IssueTicket currentTicket = unresolvedTickets.get(currentRecord);
        managerUI.setId("ID: " + currentTicket.getReportID().toString());
        Customer custOwner = null;
        for(Customer cust : MainData.getCustomers()) {
            if(currentTicket.getCustID() == cust.getCustID()) {
                custOwner = cust;
            }
        }
        LocalDateTime date = currentTicket.getDateTime();
        managerUI.setFullName(custOwner.getFirstName() + " " + custOwner.getLastName());
        managerUI.setDates(date.getMonthValue() + "/" + date.getDayOfMonth() + "/" + date.getYear());
        managerUI.setGetIssueTxt(currentTicket.getDescription());
    }

    public ArrayList<IssueTicket> generateUnresolvedList() {
        ArrayList<IssueTicket> unresolvedTickets = new ArrayList<>();
        for(IssueTicket ticket : MainData.getIssueTickets()) {
            if(!ticket.getIsResolved()) {
                unresolvedTickets.add(ticket);
            }
        }

        return unresolvedTickets;
    }

    public LoginUI getTheLoginUI() {
        return theLoginUI;
    }

    public void setTheLoginUI(LoginUI theLoginUI) {
        this.theLoginUI = theLoginUI;
    }

    public CustomerUI getTheCustomerUI() {
        return theCustomerUI;
    }

    public void setTheCustomerUI(CustomerUI theCustomerUI) {
        this.theCustomerUI = theCustomerUI;
    }

    public ManagerUI getManagerUI() {
        return managerUI;
    }

    public void setManagerUI(ManagerUI managerUI) {
        this.managerUI = managerUI;
    }

    public SubmitIssue getSubmitIssue() {
        return submitIssue;
    }

    public void setSubmitIssue(SubmitIssue submitIssue) {
        this.submitIssue = submitIssue;
    }

    public ViewPreviousTickets getPreviousTickets() {
        return previousTickets;
    }

    public void setPreviousTickets(ViewPreviousTickets previousTickets) {
        this.previousTickets = previousTickets;
    }

    public static void setCurrentCustomer(Customer currentCustomer) {
        ListCntl.currentCustomer = currentCustomer;
    }

    public static void setCurrentManager(Manager currentManager) {
        ListCntl.currentManager = currentManager;
    }

    public Integer getCurrentTicket() {
        return currentTicket;
    }

    public void setCurrentTicket(Integer currentTicket) {
        this.currentTicket = currentTicket;
    }

    public Integer getCurrentRecord() {
        return currentRecord;
    }

    public void setCurrentRecord(Integer currentRecord) {
        this.currentRecord = currentRecord;
    }

    public ArrayList<IssueTicket> getUnresolvedTickets() {
        return unresolvedTickets;
    }

    public void setUnresolvedTickets(ArrayList<IssueTicket> unresolvedTickets) {
        this.unresolvedTickets = unresolvedTickets;
    }

    public void saveData() {
        SavedData.saveAll("SaveMore.json");
    }

}