import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import model.Customer;
import utility.ExternalDataControl;
import utility.JsonUtil;
import utility.MainData;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println();

        Customer cus = new Customer();
        cus.setFirstName("customer firstname");
        cus.setLastName("customer lastName");
        cus.setUsername("customer username");
        cus.setPassword("customer password");
        cus.setCustID(31574986);
        
        MainData.getCustomers().add(cus);

        // JsonUtil.writeJson("customer.json", Customer.customerJsonArray(MainData.getCustomers()));
        // System.out.println(JsonUtil.readJson("customer.json"));


        
        JSONArray ja = (JSONArray) JsonUtil.readJson("customer.json").get("Customers");
        JSONObject t = (JSONObject) ja.get(0);
        System.out.println(t.get("UserName"));


    }
}
