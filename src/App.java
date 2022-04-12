
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;

import controller.ListCntl;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

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

        // MainData.setIssueTickets(IssueTicket.jsonToIssueTicket(JsonUtil.readJsonArray("IssueTicket.json")));
        // MainData.getCustomers().add(Customer.jsonToCustomer(JsonUtil.readJsonObject("customer.json")));
        
        //This is the template you will use. Add it to a Var and use .get on the variable
        JSONObject jObject = (JSONObject) JsonUtil.readJsonObject("insertSome file path here");


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

