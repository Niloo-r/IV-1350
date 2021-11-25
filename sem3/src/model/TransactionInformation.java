package model;

import java.util.LinkedList;

import DTO.TransactionInformationDTO;

public class TransactionInformation {
    LinkedList<Item> cart = new LinkedList<Item>();
    double payment = 0;
    double change = 0;

    public TransactionInformation(LinkedList<Item> cart) {
        this.cart = cart;
    }

    /**
     * Greates an DTO for the transaction information:
     *
     * @return the DTO
     */
    public TransactionInformationDTO toDTO() {
        TransactionInformationDTO transactionInformationDTO = new TransactionInformationDTO(this.cart, this.payment,
                this.change);
        return transactionInformationDTO;
    }

    /**
     * Updates the customers cart.
     *
     * @param cart The cart
     */
    public void updateCart(LinkedList<Item> cart) {
        this.cart = cart;

    }

    /**
     * Sets the payment.
     *
     * @param payment the payment
     */
    public void setPayment(double payment) {
        this.payment = payment;
    }

    /**
     * Set the change.
     *
     * @param change The change.
     */
    public void setChange(double change) {
        this.change = change;
    }

    /**
     * Gets the change.
     *
     * @return The Change
     */
    public double getChange() {
        return this.change;
    }

    /**
     * Gets the payment.
     *
     * @return The payment
     */
    public double getPayment() {
        return this.payment;
    }

}
