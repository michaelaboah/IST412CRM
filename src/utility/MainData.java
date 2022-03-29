package IST412CRM.utility;
import java.util.ArrayList;

public class MainData {
    private static ArrayList<model.Customer> customers = new ArrayList<>();
    private static ArrayList<Item> items = new ArrayList<>();







    public static ArrayList<Customer> getCustomers() {
        return customers;
    }

    public static ArrayList<Item> getItems() {
        return items;
    }
}
