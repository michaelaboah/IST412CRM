package model;

import java.util.Random;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Item {
    private String itemName, itemURL, itemDescription;
    private int itemID;

    public Item(String itemName, String itemURL, 
        String itemDescription, int itemID) {
        this.itemName = itemName;
        this.itemURL = itemURL;
        this.itemDescription = itemDescription;
        this.itemID = itemID;
    }

   
    public String getItemName() {
        return this.itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemURL() {
        return this.itemURL;
    }

    public void setItemURL(String itemURL) {
        this.itemURL = itemURL;
    }

    public String getItemDescription() {
        return this.itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public int getItemID() {
        return this.itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    // public static JSONObject itemToJson(Item itm){
    //     var jObject = new JSONObject();
    //     jObject.put("Item Name", itm.itemName);
    //     jObject.put("Item URL", itm.itemURL);
    //     jObject.put("Item Description", itm.itemDescription);
    //     jObject.put("Item ID", itm.itemID);
    //     return jObject;
    // }

    // public static JSONArray itemJsonArray(ArrayList<Item> testArr){
    //     var jsonArray = new JSONArray();
    //     for (Item element : testArr) {
    //         jsonArray.add(itemToJson(element));
    //     }
    // return jsonArray;
    // }

}
