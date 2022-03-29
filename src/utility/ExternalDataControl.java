package utility;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

import model.Customer;

public class ExternalDataControl {

    

    public static String jsonInput(String s){

        try {
            Object importedData = new JSONParser().parse(new FileReader(s));
            
            return importedData.toString();
        } catch (Exception e) {

            System.out.println(e);
            return null;
        }
    }




    public static void jsonOutput(){

        try {

        // BufferedWriter writer = new BufferedWriter(new FileWriter("customer.json"));

        // writer.write(jo.toJSONString());
        // writer.close();

        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}
