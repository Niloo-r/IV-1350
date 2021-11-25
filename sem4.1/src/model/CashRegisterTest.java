package model;

import static org.junit.jupiter.api.Assertions.*;


import dbHandler.Item;
import dbHandler.ItemDTO;
import org.junit.Test;
import util.Amount;

import static org.junit.Assert.*;

public class CashRegisterTest {

    private int item;
    private Amount tax;
    private Amount price;
    private int quantity;

    @Test
    public void testAddPayment() {
        CashRegister cashRegister = new CashRegister();
        Amount price = new Amount(10);
        Amount tax = new Amount(4);
        String itemNameAndIdentifier = "Tändkräm";
        ItemDTO itemDescription = new ItemDTO(price, item, tax, quantity);
        Amount quantity = new Amount(1);
        Item item = new Item(itemDescription, itemNameAndIdentifier, quantity);
        Total total = new Total();
        total.updateTotal(item);
        Amount paidAmount = new Amount(30);
        Payment payment = new Payment(paidAmount, total);
        cashRegister.addPayment(payment);
        Amount expectedResult = new Amount(0).plus(payment.getTotal().getTotalAndTax());
        Amount actualResult = cashRegister.getBalance();
        assertEquals((Object) expectedResult, actualResult, "oops! Balance Registration invalid!");
    }
}