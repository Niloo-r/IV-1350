package util;

import java.util.Objects;

/**
 * all sort of amount is represented, money or items.
 */
public class Amount {
    private final int amount;

    /**
     * Creates an instance, representing the specified amount.
     * an instance is created and represents a specific amount.
     */
    public Amount(int amount){
        this.amount = amount;
    }

    /**
     * Get the value of amount and return it.
     */
    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return Integer.toString(amount);
    }

    /**
     * Compares the specified amount and this amount
     * return false if its not the same kind of object
     * otherwise true
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }
        if (getClass() != obj.getClass()){
            return false;
        }
        final Amount other = (Amount) obj;
        if (!Objects.equals(this.amount, other.amount)){
            return false;
        }
        return true;
    }

    /**
     * will perform subtraction
     */
    public Amount minus(Amount other){
        return new Amount(this.amount - other.amount);
    }

    /**
     * Will perform addition
     */
    public Amount plus(Amount other){
        return new Amount(this.amount + other.amount);
    }

    /**
     * Will perform multiplication
     */
    public Amount multiply(Amount other){ return new Amount(this.amount * other.amount);}

}
