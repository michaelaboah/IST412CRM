package model;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Customer {
    private String firstName, lastName, email, 
        username, password, address;

    private Integer custID;

    public Customer(String firstName, String lastName, String email, 
        String username, String password, String address, Integer custID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.address = address;
        this.custID = custID;
    }

    // public Customer() {
    //     this.firstName = "Joe";
    //     this.lastName = "Smith";
    //     this.email = "joesmith@gmail.com";
    //     this.username = "c1";
    //     this.password = "12";
    //     this.address = "543 Keswick Drive, Yardley, PA, 19067";
    //     this.custID = 23;
    // }


    public Customer() {
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getCustID() {
        return this.custID;
    }

    public void setCustID(Integer custID) {
        this.custID = custID;
    }

    @Override
    public String toString() {
        return "Customer [address=" + address + ", custID=" + custID + ", email=" + email + ", firstName=" + firstName
                + ", lastName=" + lastName + ", password=" + password + ", username=" + username + "]";
    }
    
    public static JSONObject customerToJson(Customer cus){
        var jObject = new JSONObject();
        jObject.put("First Name", cus.firstName);
        jObject.put("Last Name", cus.lastName);
        jObject.put("Email", cus.email);
        jObject.put("UserName", cus.username);
        jObject.put("Password", cus.password);
        jObject.put("Address", cus.address);
        jObject.put("CustomerID", cus.custID);
        return jObject;
    }

    public static Customer jsonToCustomer(JSONObject jsonObject){
        var cus = new Customer();
        cus.firstName = jsonObject.get("First Name").toString();
        cus.lastName = jsonObject.get("Last Name").toString();
        cus.email = jsonObject.get("Email").toString();
        cus.username = jsonObject.get("UserName").toString();
        cus.password = jsonObject.get("Password").toString();
        cus.address = jsonObject.get("Address").toString();
        cus.custID = Integer.parseInt(jsonObject.get("CustomerID").toString());
        return cus;
    }


    public static JSONObject customerJsonArray(ArrayList<Customer> testArr){
        JSONArray jsonArray = new JSONArray();
        for (Customer element : testArr) {
            jsonArray.add(customerToJson(element));
        }
        JSONObject jObject = new JSONObject();
        jObject.put("Customers", jsonArray);
    return jObject;
    }


}
