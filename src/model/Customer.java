package model;

/**
 * Object representation of customer
 * 
 * @author Michael Aboah, Nathan Carr, Lamees Eltohami, Henry Hoffman, Liam Kirkland, Edwin Reyes Rodriguez
 * @version 04/17/22
 * 
 */
public class Customer {
    private String firstName, lastName, email, 
        username, password, address;

    private Integer custID;

    /**
     * Creates Customer constructor
     * 
     * @param firstName     String representation of customer's documented first name
     * @param lastName      String representation of customer's documented last name
     * @param email         String representation of customer's documented email address
     * @param username      String representation of customer's documented username credential for CRM login
     * @param password      String representation of customer's documented password credential for CRM password
     * @param address       String representation of customer's documented physical address
     * @param custID        Integer representation of customer's documented Forest identification number
     */
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

        StringBuilder sb = new StringBuilder();

        sb.append("Customer [address=").append(address).append(", custID=").append(custID).append(", email=").append(email)
        .append(", firstName=").append(firstName).append(", lastName=").append(lastName).append(", password=").append(password)
        .append(", username=").append(username).append("]");

        return sb.toString();
    }



}