package model;

import java.time.LocalDateTime;
import java.util.ArrayList;


/**
 * Object representation of a product or item that the customer ordered
 * 
 * @author Michael Aboah, Nathan Carr, Lamees Eltohami, Henry Hoffman, Liam Kirkland, Edwin Reyes Rodriguez
 * @version 04/17/22
 * 
 */
public class IssueOrder {

   private ArrayList<Integer> orderedItem;
   private Integer orderID;
   private LocalDateTime dateOrder;
   private Boolean isDelivered;
   private int custID;


   /**
    * Creates IssueOrder constructor
    * 
    * @param orderedItem    arraylist of orderIDs for products ordered  // TODO: I HAVE NO CLUE WHY THIS IS HERE... DELETE?
    * @param orderID        integer used to identify the customer's order/s
    * @param dateOrder      LocalDateTime used to capture when the customer ordered their items
    * @param isDelivered    Boolean used to determine if the items have been delivered yet
    * @param custID         Integer representation of customer's documented Forest identification number for a given order
    */
   public IssueOrder(ArrayList<Integer> orderedItem, Integer orderID,
       LocalDateTime dateOrder, Boolean isDelivered, int custID) {

       this.orderedItem = orderedItem;
       this.orderID = orderID;
       this.dateOrder = dateOrder;
       this.isDelivered = isDelivered;
       this.custID = custID;
   }

   public ArrayList<Integer> getOrderedItem() {
       return this.orderedItem;
   }

   public void setOrderedItem(ArrayList<Integer> orderedItem) {
       this.orderedItem = orderedItem;
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

   

   public int getCustID() {
    return custID;
}

    public void setCustID(int custID) {
        this.custID = custID;
    }



   @Override
   public String toString() {

    StringBuilder sb = new StringBuilder();

    sb.append("Order ID: ").append(getOrderID()).append("; Date: ").append(getDateOrder());

    return sb.toString();



   }

}