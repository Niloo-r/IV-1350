package model;

public class Customer {
    private int customerID=0;

    public Customer(int customerID) {
        this.customerID = customerID;
    }
    public int getCustomerID() {
        return customerID;
    }
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

}
