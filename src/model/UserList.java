//package model;
//
//import java.util.ArrayList;
//import controller.*;
//
//public class UserList {
//    private ArrayList<Manager> managerList;
//    private ArrayList<Customer> customerList;
//    private ListCntl theListCntl;
//
//    public UserList(ListCntl theListCntl) {
//        managerList = new ArrayList<>();
//        customerList = new ArrayList<>();
//        this.theListCntl = theListCntl;
//        generateTestData();
//    }
//
//    public void generateTestData() {
//        managerList.add(new Manager());
//        customerList.add(new Customer());
//    }
//
//    public ArrayList<Manager> getManagerList() {
//        return this.managerList;
//    }
//
//    public ArrayList<Customer> getCustomerList() {
//        return this.customerList;
//    }
//
//    public boolean authenticateManager(Manager manager){
//        //compare the user in the argument to the arraylist to see if it has valid username and pw
//        for(Manager currentM : managerList){
//            if(manager.getUsername().equals(currentM.getUsername()) && manager.getPassword().equals(currentM.getPassword())){
//                theListCntl.setCurrentManager(currentM);
//                theListCntl.setCurrentCustomer(null);
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public boolean authenticateCustomer(Customer customer){
//        //compare the user in the argument to the arraylist to see if it has valid username and pw
//        for(Customer currentC : customerList){
//            System.out.println("testU: " + customer.getUsername());
//            System.out.println("testP: " + customer.getPassword());
//            System.out.println("currentU: " + currentC.getUsername());
//            System.out.println("currentP: " + currentC.getPassword());
//
//            if(customer.getUsername().equals(currentC.getUsername()) && customer.getPassword().equals(currentC.getPassword())){
//                theListCntl.setCurrentCustomer(currentC);
//                theListCntl.setCurrentManager(null);
//                return true;
//            }
//        }
//        return false;
//    }
//}
