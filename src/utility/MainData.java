
package utility;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import model.*;

public class MainData {

    private static ArrayList<Customer> customers = new ArrayList<>();
    private static ArrayList<Item> items = new ArrayList<>();
    private static ArrayList<IssueTicket> issueTickets = new ArrayList<>();
    private static ArrayList<IssueOrder> issueOrders = new ArrayList<>();
    private static ArrayList<Manager> managers = new ArrayList<>();


    private static JSONObject dataPersistance = new JSONObject();

    public static ArrayList<Customer> getCustomers() {
        return customers;
    }


    public static void setCustomers(ArrayList<Customer> customers) {
        MainData.customers = customers;
    }


    public static ArrayList<Item> getItems() {
        return items;
    }


    public static void setItems(ArrayList<Item> items) {
        MainData.items = items;
    }


    public static ArrayList<IssueTicket> getIssueTickets() {
        return issueTickets;
    }


    public static void setIssueTickets(ArrayList<IssueTicket> issueTickets) {
        MainData.issueTickets = issueTickets;
    }


    public static ArrayList<IssueOrder> getIssueOrders() {
        return issueOrders;
    }

    
    public static void setIssueOrders(ArrayList<IssueOrder> issueOrders) {
        MainData.issueOrders = issueOrders;
    }

    public static ArrayList<Manager> getManagers() {
        return managers;
    }


    public static void setManagers(ArrayList<Manager> managers) {
        MainData.managers = managers;
    }


    public static JSONObject getDataPersistance() {
        return dataPersistance;
    }


    public static void setDataPersistance(JSONObject dataPersistance) {
        MainData.dataPersistance = dataPersistance;
    }


}
