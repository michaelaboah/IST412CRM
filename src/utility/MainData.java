
package utility;
import java.util.ArrayList;



import model.*;

public class MainData {

    private static ArrayList<Customer> customers = new ArrayList<>();
    private static ArrayList<Item> items = new ArrayList<>();
    private static ArrayList<IssueTicket> issueTickets = new ArrayList<>();




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


}
