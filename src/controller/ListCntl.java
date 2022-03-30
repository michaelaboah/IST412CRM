// package controller;

// import model.*;
// import view.*;

// import java.time.LocalDateTime;
// import java.util.ArrayList;


// public class ListCntl {

//     private Customer currentCustomer;
//     private Manager currentManager;
//     private LoginUI theLoginUI;
//     private CustomerUI theCustomerUI;
//     private ManagerUI theManagerUI;
//     private RecordSearchUI theRecordSearchUI;
//     private UserList theUserList;

//     public ListCntl() {

//         this.getTestTicketData();
//         System.out.println(IssueTicket.getIssueTicketList());

//         theUserList = new UserList(this);

//         theLoginUI = new LoginUI(this);
         
//         showLoginUI();
//     }

//     // public IssueOrderList getOrderList() {
//     //     return IssueOrder.getIssueOrderList();
//     // }

//     //Ticket List
//     public ArrayList<IssueTicket> getTicketList() {
//         return IssueTicket.getIssueTicketList();
//     }


//     public void getTestTicketData() {

//         Customer cust = new Customer();
//         Manager manager = new Manager();

//         Customer cust2 = new Customer("joe", "man", "jm@gmail.com", 
//         "jm", "password1", "42 Wallaby Way, Sydney, Australia", 27);

//         /*
//         public IssueTicket(Integer reportID, LocalDateTime dateTime, String name, 
//         Boolean isResolved, String description, Customer custOwner, 
//         Manager recipient, IssueType issueType)
//     */
//         IssueTicket ticket1 = new IssueTicket();

//         IssueTicket ticket2 = new IssueTicket.IssueTicketBuilder(cust, manager, IssueType.OTHER)
//         .description("help2")
//         .name("Problem2")
//         .build();

//         IssueTicket ticket3 = new IssueTicket.IssueTicketBuilder(cust, manager, IssueType.OTHER)
//         .description("help3")
//         .name("Problem3")
//         .build();

//         IssueTicket ticket4 = new IssueTicket.IssueTicketBuilder(cust, manager, IssueType.OTHER)
//         .description("help4")
//         .name("Problem4")
//         .build();
//     }

//     /*
//     public void setTicketListName(IssueTicket issueTicket) {
//         theTicketList.getNodeDataInList().setName(issueTicket.getName());
//     }
//     public void setTicketListCustomer(IssueTicket issueTicket) {
//         theTicketList.getNodeDataInList().setCustOwner(issueTicket.getCustOwner());
//     }
//     public void setTicketListDesc(IssueTicket issueTicket) {
//         theTicketList.getNodeDataInList().setDescription(issueTicket.getDescription());
//     }
//     public void setTicketListResolved(IssueTicket issueTicket) {
//         theTicketList.getNodeDataInList().setIsResolved(issueTicket.getIsResolved());
//     }
//     */

//     public void showCustomerUI() {
//         theCustomerUI.setVisible(true);
//     }

//     public void showManagerUI() {
//         theManagerUI.setVisible(true);
//     }

//     public void showLoginUI(){
//         theLoginUI.setVisible(true);
//     }
    

//     public void requestAuthenticateCustomer(Customer customer){
//         if(customer == null) {
//             System.out.println("Please select the type of account.");
//             return;
//         }

//         if(theUserList.authenticateCustomer(customer)==true) {
//             System.out.println("Valid user");
//             theLoginUI.setVisible(false);
//             theCustomerUI = new CustomerUI(this);
//             theCustomerUI.setVisible(true);
//             //ObjectiveCntl objectiveCntl = new ObjectiveCntl(this, user);
//             //TimeGoalCntl timeGoalCntl = new TimeGoalCntl(theUserList.getListOfUsers(), currentUser);
//         }

//         else
//             System.out.println("Cntl: Invalid username/password");
//     }

//     public void requestAuthenticateManager(Manager manager){
//         if(theUserList.authenticateManager(manager)==true){
//             //System.out.println("Valid user");
//             theLoginUI.setVisible(false);
//             theManagerUI = new ManagerUI(this);
//             theManagerUI.setVisible(true);
//             //ObjectiveCntl objectiveCntl = new ObjectiveCntl(this, user);
//             //TimeGoalCntl timeGoalCntl = new TimeGoalCntl(theUserList.getListOfUsers(), currentUser);
//         }

//         else
//             System.out.println("LoginCntl: Invalid username/password");
//     }

//     public void setCurrentCustomer(Customer customer) {
//         this.currentCustomer = customer;
//     }

//     public void setCurrentManager(Manager manager) {
//         this.currentManager = manager;
//     }

//     public Customer getCurrentCustomer() {
//         return this.currentCustomer;
//     }

//     public Manager getCurrentManager() {
//         return this.currentManager;
//     }

//     /*
//     public void writeData() {
//         theOrderList.writeFileData();
//     }
//     public String readData() {
//         return theOrderList.getFileData().toString();
//     }
//     public void importRewriteData() {
//         theOrderList = theOrderList.getFileData();
//     }
//     public void updateSessionToFile() {
//         theTicketList.writeFileData();
//     }
//     */
//     public void restoreSession() {
//         /*
//         try {
//             theTicketList = theTicketList.getFileData();
//         } catch (Exception e) {
//             System.out.println("File data could not be gotten");
//         }
//         */
//         System.out.println("session restored");
//     }
//     /*
//     public void resetSession() {
//         theTicketList = theTicketList.getTestTicketData();
//     }
//     */
// }
