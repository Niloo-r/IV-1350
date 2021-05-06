package util;

import java.util.Objects;

/**
 * a customers identification .
 */
public class CustomerID {
    private String customerIdentificationNumber;

    /**
     * an instance is created  ans represents identification of a customer
     */
    public CustomerID(String customerIdentificationNumber){
        this.customerIdentificationNumber = customerIdentificationNumber;
    }

    /**
     * Get the value of customerIdentificationNumber and return it
     */
    public String getCustomerIdentificationNumber() {
        return customerIdentificationNumber;
    }

    /**
     * compares this instance to another instance
     * returns true if attributes are the same
     * otherwise false
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }
        if (getClass() != obj.getClass()){
            return false;
        }
        final CustomerID other = (CustomerID) obj;
        if (!Objects.equals(this.customerIdentificationNumber, other.customerIdentificationNumber)) {
            return false;
        }
        return true;
    }
}
