package dbHandler;

import model.Receipt;

/**
 * Represents a printer.
 */
public class Printer {

    /**
     * an instance is created representing a printer
     */
    public Printer(){ }

    /**
     * the printer will print out the receipt.
     */
    public void printReceipt(Receipt receipt){
        System.out.println(receipt.toString());
    }
}
