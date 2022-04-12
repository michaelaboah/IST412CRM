package model;

import java.util.ArrayList;

import utility.JsonUtil;
import utility.MainData;

public class SavedData{

    private  ArrayList<Customer> customers = new ArrayList<>();
    private  ArrayList<Item> items = new ArrayList<>();
    private  ArrayList<IssueTicket> issueTickets = new ArrayList<>();

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

    @Override
    public String toString() {
        return "SavedData [customers=" + customers + ", issueTickets=" + issueTickets + ", items=" + items + "]";
    }

    public static void readAll(String filePath){
        SavedData retrieved = (SavedData) JsonUtil.readJson(filePath, new SavedData());
        
        MainData.setCustomers(retrieved.getCustomers());
        MainData.setIssueTickets(retrieved.getIssueTickets());
        System.out.println(retrieved.getIssueTickets());
        MainData.setItems(retrieved.getItems());
    }


    public static void saveAll(String filepath){
        var save = new SavedData();
        save.setCustomers(MainData.getCustomers());
        save.setIssueTickets(MainData.getIssueTickets());
        save.setItems(MainData.getItems());
        JsonUtil.writeJson(filepath, save);
    }
}
