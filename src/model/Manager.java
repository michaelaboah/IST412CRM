
package model;


/**
 * Object representation of a Forest manager
 * 
 * @author Michael Aboah, Nathan Carr, Lamees Eltohami, Henry Hoffman, Liam Kirkland, Edwin Reyes Rodriguez
 * @version 04/17/22
 * 
 */
public class Manager {
    
    private String fName, lName, username, password;
    private ManagerType managerType;
    private Integer managerID;


    /**
     * Categorization lables for the different types of managers
     * Used to differentiate confidentiality restrictions
     * 
     */
    public enum ManagerType {
        CRM, // Just to access one employee use case
        SHIPMENT, // For shipment issues
        BILLING, // For billing issues
        PRODUCT, // For item issues
        TECH_SUPPORT // For glitches/bug issues
    }


    /**
     * Create manager constructor
     * 
     * @param fName         String representation of the manager's first name
     * @param lName         String representation of the manager's last name
     * @param username      String representation of the manager's username to login into the CRM
     * @param password      String representation of the manager's password to login into the CRM
     * @param managerType   instance of categorization to which the manager resides within Forest
     * @param managerID     Integer identification of managger
     */
    public Manager(String fName, String lName, String username,
        String password, ManagerType managerType, Integer managerID) {
        this.fName = fName;
        this.lName = lName;
        this.username = username;
        this.password = password;
        this.managerType = managerType;
        this.managerID = managerID;
    }

    /**
     * If no manager specificaitons are made, program automatically uses these defualts
     * 
     */
    public Manager() {
        this.fName = "Joe";
        this.lName = "Dude";
        this.username = "m1";
        this.password = "12";
        this.managerType = ManagerType.CRM;
        this.managerID = 1;
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
        

        StringBuilder sb = new StringBuilder();

        sb.append("Manager [fName=").append(fName).append(", lName=").append(lName)
        .append(", managerID=").append(managerID).append(", managerType=").append(managerType)
        .append(", password=").append(password).append(", username=").append(username).append("]");
    
        return sb.toString();
    }

    

} 
