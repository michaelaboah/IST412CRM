package utility;
import java.util.ArrayList;

import org.json.simple.JSONArray;

import model.*;

public class MainData {
    private static ArrayList<Customer> customers = new ArrayList<>();
    private static ArrayList<Item> items = new ArrayList<>();







    public static ArrayList<Customer> getCustomers() {
        return customers;
    }

    public static ArrayList<Item> getItems() {
        return items;
    }


    // public static JSONArray convertCustomerToJson(){
    //     JSONArray jArray = new JSONArray();
    //     for (Customer customer : customers) {
    //         jArray.add(customer.getFirstName());
    //     }
    // }

}
