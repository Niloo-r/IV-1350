package model;



//import dbHandler.Item;
import util.Amount;
import dbHandler.*;

/**
 * total amount with tax is represented
 */
public class Total {
    private Amount total;
    private Amount totalTax;
    private ItemDTO itemDTO ;


    /**
     * a new instance is created and represents the total.
     */
    public Total(){
        this.total = new Amount(0);
        this.totalTax = new Amount(0);
    }

    /**
     * Gets the value of total and return it
     */
    public Amount getTotal() {
        return total;
    }

    /**
     * Gets the value the totalTax and return it.
     */
    public Amount getTotalTax() {
        return totalTax;
    }

    /**
     *  Adds the tax to the total
     * total amount with tax will be returned
     */
    public Amount getTotalAndTax(){
        return total.plus(totalTax);
    }

    /**
     * item price will be added to the total. items tax will be added to the total tax
     * the total and the totalTax will be updated
     */
    public void updateTotal(Item item){
        if(item == null){
            return;
        }
        Amount amountOfItems = item.getQuantity();
        Amount itemPrice = item.getItemDTO().getPrice();
        Amount itemTax = item.getItemDTO().getTaxAmount();

        this.totalTax = this.totalTax.plus(amountOfItems.multiply(itemTax));
        this.total = this.total.plus(amountOfItems.multiply(itemPrice));
    }
}
