package model;


/**
 * Discount rules are represented.
 */
public class DiscountRules
{
    /**
     * the discounted price of the sale will be calculated by the rules and
     * the value of the discounted price will be returned
     */
    public static double calcDiscountedPrice(double totalPrice)
    {
        return 0.8*totalPrice;
    }
}

