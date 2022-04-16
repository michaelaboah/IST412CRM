import controller.ListCntl;

import model.Customer;
import model.IssueTicket;
import utility.JsonUtil;
import utility.MainData;
import view.*;

public class App {    
    public static void main(String[] args) {

        MainData.setIssueTickets(IssueTicket.jsonToIssueTicket(JsonUtil.readJsonArray("IssueTicket.json")));
        MainData.getCustomers().add(Customer.jsonToCustomer(JsonUtil.readJsonObject("customer.json")));

        CRMJframe frame = new CRMJframe();

        LoginUI loginUI = new LoginUI();
        CustomerUI customerUI = new CustomerUI();
        SubmitIssue submitIssue = new SubmitIssue();
        ManagerUI managerUI = new ManagerUI();
        ViewPreviousTickets previousTickets = new ViewPreviousTickets();

        ListCntl listCntl = new ListCntl(loginUI, customerUI, submitIssue, previousTickets);
        listCntl.customers();
        listCntl.submitComplaint();
        listCntl.previousTickets();

        frame.add(loginUI);
        frame.add(managerUI);
        frame.add(customerUI);
        frame.add(submitIssue);
        frame.add(managerUI);
        frame.add(previousTickets);
        frame.setVisible(true);

    }
}

