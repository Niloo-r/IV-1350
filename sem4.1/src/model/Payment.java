package model;

import util.Amount;

/**
 *  payment of a specific sale is represented
 */
public class Payment {
    private Amount paidAmount;
    private Total total;

    /**
     * paidAmount represents the amount of money that the customer have given.
     * total is simply the total amount.
     */
    public Payment(Amount paidAmount, Total total){
        this.paidAmount = paidAmount;
        this.total = total;
    }

    /**
     * gets the total and return the value.
     */
    Total getTotal() {
        return total;
    }

    /**
     * the amount of change will be calculated and returned
     */
    public Amount getChange(){
        return paidAmount.minus(total.getTotalAndTax());
    }



}
