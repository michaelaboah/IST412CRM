package model;


/**
 * Object representation of a distributor's item
 * 
 * @author Michael Aboah, Nathan Carr, Lamees Eltohami, Henry Hoffman, Liam Kirkland, Edwin Reyes Rodriguez
 * @version 04/17/22
 * 
 */
public class Item {
    private String itemName, itemURL, itemDescription;
    private int itemID;

    /**
     * Create Item constructor
     * 
     * @param itemName          String name of a given item
     * @param itemURL           String url link of a given item
     * @param itemDescription   String description of a given item
     * @param itemID            Integer identification of a given item
     */
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


    @Override
    public String toString() {


        StringBuilder sb = new StringBuilder();

        sb.append("Item [itemDescription").append(itemDescription).append(", itemID=").append(itemID)
        .append(", itemName=").append(itemName).append(", itemURL=").append(itemURL).append("]");
    
        return sb.toString();

    }

    

}