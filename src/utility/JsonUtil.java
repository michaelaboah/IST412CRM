
// This is the JSON util class, it's purpose is to provide simple and useful JSON functions wherever needed
// Author: Michael Aboah
// Date Created: 

package utility;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonUtil {
    
                                //Insert filepath and Object
    public static void writeJson(String filepath, Object jsonObject){
        Gson jParser = new GsonBuilder().setPrettyPrinting().create();
        try {
            var writer = new BufferedWriter(new FileWriter(filepath));
            var data = jParser.toJson(jsonObject);
            writer.write(data);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

                        // Insert filepath and a new %ObjectType%()
    public static Object readJson(String filePath,  Object obj ){
        Gson gson = new Gson();
        try (Reader reader = new FileReader(filePath)) {
            return gson.fromJson(reader, obj.getClass());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
