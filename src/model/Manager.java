
package model;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Manager {
    
    private String fName, lName, username, password;
    private ManagerType managerType;
    private Integer managerID;



    public enum ManagerType {
        CRM, // Just to access one employee use case
        SHIPMENT, // For shipment issues
        BILLING, // For billing issues
        PRODUCT, // For item issues
        TECH_SUPPORT // For glitches/bug issues
    }

    public Manager(String fName, String lName, String username,
        String password, ManagerType managerType, Integer managerID) {
        this.fName = fName;
        this.lName = lName;
        this.username = username;
        this.password = password;
        this.managerType = managerType;
        this.managerID = managerID;
    }

    public Manager() {
        this.fName = "Joe";
        this.lName = "Dude";
        this.username = "m1";
        this.password = "12";
        this.managerType = ManagerType.CRM;
        this.managerID = 7;
    }


    public String getFName() {
        return this.fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getLName() {
        return this.lName;
    }

    public void setLName(String lName) {
        this.lName = lName;
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

    public ManagerType getManagerType() {
        return this.managerType;
    }

    public void setManagerType(ManagerType managerType) {
        this.managerType = managerType;
    }

    public Integer getManagerID() {
        return this.managerID;
    }

    public void setManagerID(Integer managerID) {
        this.managerID = managerID;
    }

    public static ManagerType assignManagerType(String assignedType) {
        switch (assignedType) {
            case "CRM":
            return ManagerType.CRM;

            case "SHIPMENT":
            return ManagerType.SHIPMENT;

            case "BILLING":
                return ManagerType.BILLING;
            
            case "PRODUCT":
                return ManagerType.PRODUCT;

            case "TECH_SUPPORT":
                return ManagerType.TECH_SUPPORT;

            default:
                return null;
        }
    }

    @Override
    public String toString() {
        return "Manager [fName=" + fName + ", lName=" + lName + ", managerID=" + managerID + ", managerType="
                + managerType + ", password=" + password + ", username=" + username + "]";
    }

<<<<<<< HEAD
    
=======
    public static JSONObject managerToJson(Manager man){
        var jObject = new JSONObject();
        jObject.put("Manager FirstName", man.fName);
        jObject.put("Manager LastName", man.lName);
        jObject.put("Manager Username", man.username);
        jObject.put("Manager Password", man.password);
        jObject.put("Manager Type", man.managerType.toString());
        jObject.put("ManagerID", man.managerID);
        return jObject;
    }

    public static Manager jsonToManager(JSONObject json){
        var man = new Manager();
        man.fName = json.get("Manager FirstName").toString();
        man.lName = json.get("Manager LastName").toString();
        man.username = json.get("Manager Username").toString();
        man.password = json.get("Manager Password").toString();
        ManagerType assignedManagerType = assignManagerType(json.get("Manager Type").toString());
        man.setManagerType(assignedManagerType);
        
        man.managerID = Integer.parseInt(json.get("ManagerID").toString());
        return man;
    }

    public static JSONArray managerJsonArray(ArrayList<Manager> testArr){
        var jsonArray = new JSONArray();
        for (Manager element : testArr) {
            jsonArray.add(managerToJson(element));
        }
    return jsonArray;
    }
>>>>>>> 44ee4e99287d2237053ae58589f3c3ba7b20f671

} 

