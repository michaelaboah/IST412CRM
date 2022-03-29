import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

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
        ArrayList<String> list = new ArrayList<>();
        JSONArray jsonArray = new JSONArray();
        // jsonArray.add(MainData.getCustomers().get(0).getFirstName());

        // System.out.println(JsonUtil.storeAsJArray(MainData.getCustomers()).get(0));

        JSONObject jObject = new JSONObject();
        jObject.put("FirstName", cus.getFirstName());
        jObject.put("LastName", cus.getLastName());


        System.out.println(jObject);



        jsonArray.addAll(MainData.getCustomers());
        
        // System.out.println(jsonArray);

        BufferedWriter writer = new BufferedWriter(new FileWriter("customer.json"));

        // writer.write(jsonArray.);
        writer.close();
    }
}
