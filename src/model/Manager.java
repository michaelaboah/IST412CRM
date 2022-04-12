
package model;

import java.util.ArrayList;


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

    

} 

