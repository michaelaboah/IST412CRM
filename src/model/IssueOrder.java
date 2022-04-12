package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class IssueOrder {

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

   @Override
   public String toString() {

       return "id: " + getOrderID() + "date/time of issue: " + getDateOrder()
               + "name: " + getListOfItemsForString() + " email: " + custOwner.getEmail()
               + " delivery status: " + getIsDelivered();

   }

}
