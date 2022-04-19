package model;

import java.util.ArrayList;

import utility.JsonUtil;
import utility.MainData;

public class SavedData{

    private  ArrayList<Customer> customers = new ArrayList<>();
    private  ArrayList<Item> items = new ArrayList<>();
    private  ArrayList<IssueTicket> issueTickets = new ArrayList<>();
    private  ArrayList<IssueOrder> issueOrders = new ArrayList<>();
    private  ArrayList<Manager> managers = new ArrayList<>();

    public ArrayList<Customer> getCustomers() {
        return customers;
    }
    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }
    public ArrayList<Item> getItems() {
        return items;
    }
    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public ArrayList<IssueTicket> getIssueTickets() {
        return issueTickets;
    }
    public void setIssueTickets(ArrayList<IssueTicket> issueTickets) {
        this.issueTickets = issueTickets;
    }

    public ArrayList<IssueOrder> getIssueOrders() {
        return issueOrders;
    }

    public void setIssueOrders(ArrayList<IssueOrder> issueOrders) {
        this.issueOrders = issueOrders;
    }

    public ArrayList<Manager> getManagers() {
        return managers;
    }
    public void setManagers(ArrayList<Manager> managers) {
        this.managers = managers;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("SavedData [customers=").append(customers).append(", issueTickets=").append(issueTickets)
            .append(", items=").append(items).append(", issueOrders").append(issueOrders).append("]");

        return sb.toString();
    }


    public static void readAll(String filePath){
        SavedData retrieved = (SavedData) JsonUtil.readJson(filePath, new SavedData());
        
        MainData.setCustomers(retrieved.getCustomers());
        MainData.setIssueTickets(retrieved.getIssueTickets());
        MainData.setItems(retrieved.getItems());
        MainData.setIssueOrders(retrieved.getIssueOrders());
        MainData.setManagers(retrieved.getManagers());
        System.out.println(retrieved);
    }


    public static void saveAll(String filepath){
        var save = new SavedData();
        save.setCustomers(MainData.getCustomers());
        save.setIssueTickets(MainData.getIssueTickets());
        save.setItems(MainData.getItems());
        save.setIssueOrders(MainData.getIssueOrders());
        save.setManagers(MainData.getManagers());
        JsonUtil.writeJson(filepath, save);
    }
}