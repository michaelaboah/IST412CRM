

import java.time.LocalDateTime;
import java.util.ArrayList;

import controller.ListCntl;

import model.Customer;
import model.IssueTicket;
import model.IssueType;
import model.Item;
import model.Manager;
import model.SavedData;
import model.Manager.ManagerType;
import utility.JsonUtil;
import utility.MainData;
import view.*;


public class App {    
    public static void main(String[] args) {

        SavedData.readAll("SaveMore.json");
        



        CRMJframe frame = new CRMJframe();

        LoginUI loginUI = new LoginUI();
        ManagerUI manager = new ManagerUI();
        CustomerUI customerUI = new CustomerUI();
        SubmitIssue submitIssue = new SubmitIssue();

        ListCntl listCntl = new ListCntl(loginUI, customerUI, submitIssue);
        listCntl.login();
        listCntl.logout();
        listCntl.submitComplaint();

        frame.add(loginUI);
        frame.add(manager);
        frame.add(customerUI);
        frame.add(submitIssue);
        frame.setVisible(true);

    }
}

