package model;

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

    public Customer() {
        this.firstName = "Joe";
        this.lastName = "Smith";
        this.email = "joesmith@gmail.com";
        this.username = "c1";
        this.password = "12";
        this.address = "543 Keswick Drive, Yardley, PA, 19067";
        this.custID = 23;
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
    
    

}
