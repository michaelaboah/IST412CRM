
// This is the JSON util class, it's purpose is to provide simple and useful JSON functions wherever needed
// Author: Michael Aboah
// Date Created: 

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
            // JSONObject wrapper = new JSONObject();
            // wrapper.put(jsonName, jsonObject);
            writer.write(jsonObject.toJSONString());
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static JSONObject readJsonObject(String filepath){
        try {
            Object obj = new JSONParser().parse(new FileReader(filepath));
            JSONObject jObject = (JSONObject) obj;
            return jObject;
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }

    
    public static JSONArray readJsonArray(String filepath){
        try {
            Object parsed = new JSONParser().parse(new FileReader(filepath));
            JSONArray jArray = (JSONArray) parsed;
            // JSONObject jObject = (JSONObject) jArray.get(i);
            return jArray;
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }

    public static JSONObject jArrToJObj(JSONArray arr, int i){
        try {
            JSONObject jObject = (JSONObject) arr.get(i);
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
