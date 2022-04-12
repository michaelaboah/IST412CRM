

import java.util.ArrayList;

import controller.ListCntl;

import model.Customer;
import model.IssueTicket;
import model.IssueType;
import model.Manager;
import model.Manager.ManagerType;
import utility.ExternalDataControl;
import utility.JsonUtil;
import utility.MainData;
import view.*;


public class App {    
    public static void main(String[] args) {

        MainData.getCustomers().add(new Customer("firstName", "lastName", "email", "username", "password", "address", 123));
        // System.out.println(MainData.getCustomers());


        
        // JsonUtil.writeJson("Test2.json", MainData.getCustomers());
        var thing = JsonUtil.readJson("IssueTicket.json", new ArrayList<IssueTicket>());
        System.out.println(thing);

        // CRMJframe frame = new CRMJframe();

        // LoginUI loginUI = new LoginUI();
        // ManagerUI manager = new ManagerUI();
        // CustomerUI customerUI = new CustomerUI();
        // SubmitIssue submitIssue = new SubmitIssue();

        // ListCntl listCntl = new ListCntl(loginUI, customerUI, submitIssue);
        // listCntl.login();
        // listCntl.logout();
        // listCntl.submitComplaint();

        // frame.add(loginUI);
        // frame.add(manager);
        // frame.add(customerUI);
        // frame.add(submitIssue);
        // frame.setVisible(true);

    }
}

