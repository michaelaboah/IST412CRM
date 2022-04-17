import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.swing.plaf.synth.SynthSeparatorUI;

import com.google.gson.*;

import controller.ListCntl;

import model.Customer;
import model.IssueOrder;
import model.IssueTicket;
import model.SavedData;
import utility.JsonUtil;
import utility.MainData;
import view.*;

public class App {    
    public static void main(String[] args) {

        SavedData.readAll("SaveMore.json");
        // ArrayList<Integer> orderedItems = new ArrayList<>();
        // orderedItems.add(1);orderedItems.add(2); orderedItems.add(3);
        // IssueOrder o =  new IssueOrder(orderedItems, 1, LocalDateTime.now(), false, 1);
        // IssueOrder o2 =  new IssueOrder(orderedItems, 2, LocalDateTime.now(), true, 1);
        // IssueOrder o3 =  new IssueOrder(orderedItems, 3, LocalDateTime.now(), false, 2);
        // IssueOrder o4 =  new IssueOrder(orderedItems, 4, LocalDateTime.now(), true, 2);
        // MainData.getIssueOrders().add(o);
        // MainData.getIssueOrders().add(o2);
        // MainData.getIssueOrders().add(o3);
        // MainData.getIssueOrders().add(o4);
        // SavedData.saveAll("SaveMore.json");
        // System.out.println("========================");
        // System.out.println(MainData.getIssueOrders());
        // System.out.println(MainData.getIssueOrders().get(2).getOrderedItem());

        //================================
        
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
