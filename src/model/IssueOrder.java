package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class IssueOrder {

   private ArrayList<Integer> orderedItem;
   private Integer orderID;
   private LocalDateTime dateOrder;
   private Boolean isDelivered;
   private int custID;

   public IssueOrder(ArrayList<Integer> orderedItem, Integer orderID,
       LocalDateTime dateOrder, Boolean isDelivered, int custID) {

       this.orderedItem = orderedItem;
       this.orderID = orderID;
       this.dateOrder = dateOrder;
       this.isDelivered = isDelivered;
       this.custID = custID;
   }

   public IssueOrder() {

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

       return "id: " + getOrderID() + "date/time of issue: " + getDateOrder()
               + " delivery status: " + getIsDelivered();

   }

}