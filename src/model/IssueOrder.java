package model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class IssueOrder implements Serializable {

   private ArrayList<Item> orderedItems;
   private Integer orderID;
   private LocalDateTime dateOrder;
   private Boolean isDelivered;
   private Customer custOwner;
   private static ArrayList<IssueOrder> issueOrderList;

   public IssueOrder(ArrayList<Item> orderedItems, Integer orderID,
       LocalDateTime dateOrder, Boolean isDelivered,
       Customer custOwner) {

       this.orderedItems = orderedItems;
       this.orderID = orderID;
       this.dateOrder = dateOrder;
       this.isDelivered = isDelivered;
       this.custOwner = custOwner;
       try {
           issueOrderList.add(this);
       }
       catch(NullPointerException e) {
           issueOrderList = new ArrayList<>();
           issueOrderList.add(this);
       }
   }

   public IssueOrder(Item orderedItem, Integer orderID,
       LocalDateTime dateOrder, Boolean isDelivered,
       Customer custOwner) {

       this.orderedItems = new ArrayList<>();
       this.orderedItems.add(orderedItem);
       this.orderID = orderID;
       this.dateOrder = dateOrder;
       this.isDelivered = isDelivered;
       this.custOwner = custOwner;
       try {
           issueOrderList.add(this);
       }
       catch(NullPointerException e) {
           issueOrderList = new ArrayList<>();
           issueOrderList.add(this);
       }
   }

   public IssueOrder() {

       this.orderedItems = new ArrayList<>();
       this.orderedItems.add(new Item());
       orderID = 1234;
       dateOrder = LocalDateTime.of(2017, 1, 14, 10, 34);
       isDelivered = false;
       this.custOwner = new Customer();
       try {
           issueOrderList.add(this);
       }
       catch(NullPointerException e) {
           issueOrderList = new ArrayList<>();
           issueOrderList.add(this);
       }
   }

   public IssueOrder(Customer custOwner) {

       this.orderedItems = new ArrayList<>();
       this.orderedItems.add(new Item());
       orderID = 1234;
       dateOrder = LocalDateTime.of(2017, 1, 14, 10, 34);
       isDelivered = false;
       this.custOwner = custOwner;
       try {
           issueOrderList.add(this);
       }
       catch(NullPointerException e) {
           issueOrderList = new ArrayList<>();
           issueOrderList.add(this);
       }
   }


   public ArrayList<Item> getOrderedItems() {
       return this.orderedItems;
   }

   public void setOrderedItems(ArrayList<Item> orderedItems) {
       this.orderedItems = orderedItems;
   }

   public Integer getOrderID() {
       return orderID;
   }

   public void setOrderID(Integer orderID) {
       this.orderID = orderID;
   }


   public LocalDateTime getDateOrder() {
       return dateOrder;
   }

   public void setDateOrder(LocalDateTime dateOrder) {
       this.dateOrder = dateOrder;
   }


   public Boolean getIsDelivered() {
       return isDelivered;
   }

   public void setIsDelivered(Boolean isDelivered) {
       this.isDelivered = isDelivered;
   }

   public Customer getCustOwner() {
       return this.custOwner;
   }

   public void setCustOwner(Customer custOwner) {
       this.custOwner = custOwner;
   }

   public String getListOfItemsForString() {
       String tempStringList = "";
       for(Item item : orderedItems) {
           tempStringList += item.getItemName();
           tempStringList += ", ";
       }

       tempStringList = tempStringList.substring(0, tempStringList.length()-2);

       return tempStringList;
   }

   public static ArrayList<IssueOrder> getIssueOrderList() {
       return IssueOrder.issueOrderList;
   }

   // public static void printOrderList() {
   //     String listStr = "Issue Ticket List: \n";
   //     for (int i = 0; issueOrderList.size(); i++) {
   //         listStr += issueOrderList.get(i).getName() + "\n";
   //     }
   //     System.out.println(listStr);
   // }

   @Override
   public String toString() {

       return "id: " + getOrderID() + "date/time of issue: " + getDateOrder()
               + "name: " + getListOfItemsForString() + " email: " + custOwner.getEmail()
               + " delivery status: " + getIsDelivered();

   }

   public String getExtra() {
       return "extra";
   }


   public static JSONObject issueOrderToJson(IssueOrder iss){
       var jObject = new JSONObject();
       jObject.put("Items Ordered", iss.orderedItems);
       jObject.put("Order ID", iss.orderID);
       jObject.put("Date Ordered", iss.dateOrder);
       jObject.put("Delivered?", iss.isDelivered);
       jObject.put("Customer Owner", iss.custOwner);
       jObject.put("Issue Order List", iss.issueOrderList);
       return jObject;
   }

   public static JSONArray issueOrderJsonArray(ArrayList<IssueOrder> testArr){
       var jsonArray = new JSONArray();
       for (IssueOrder element : testArr) {
           jsonArray.add(issueOrderToJson(element));
       }
   return jsonArray;
   }

}
