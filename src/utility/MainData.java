package utility;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import model.*;

public class MainData {
    private static ArrayList<Customer> customers = new ArrayList<>();
    private static ArrayList<Item> items = new ArrayList<>();
    private static ArrayList<IssueTicket> issueTickets = new ArrayList<>();

    
    private static JSONObject dataPersistance = new JSONObject();





    public static ArrayList<IssueTicket> getIssueTickets() {
        return issueTickets;
    }

    public static JSONObject getDataPersistance() {
        return dataPersistance;
    }

    public static ArrayList<Customer> getCustomers() {
        return customers;
    }

    public static ArrayList<Item> getItems() {
        return items;
    }



}
