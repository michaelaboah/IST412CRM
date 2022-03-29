package utility;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONAware;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonUtil {
    

    public static JSONArray storeAsJArray(ArrayList<?> arrayList){
        try {
            JSONArray array = new JSONArray();
            for (Object element : arrayList) {
                array.add(element);
            }
            return array;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }


    public static void writeJson(String filepath, JSONAware jsonObject){
        try {
            var writer = new BufferedWriter(new FileWriter(filepath));
            writer.write(jsonObject.toJSONString());
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static JSONObject readJson(String filepath){
        try {
            Object obj = new JSONParser().parse(new FileReader("customer.json"));
            JSONObject jObject = (JSONObject) obj;
            return jObject;
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }

    public static void saveAllData(String jsonName, JSONAware json){
        
        MainData.getDataPersistance().put(jsonName, json);
    }
}
