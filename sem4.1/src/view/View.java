package view;

import controller.Controller;
import controller.CouldNotAddItemException;
import dbHandler.ItemDTO;
import dbHandler.ItemNotFoundException;
import util.Amount;

public class View {
    private Controller controller;

    /**
     *  a new instance is created and is represented as a view.
     */
    public View(Controller controller){
        this.controller = controller;
    }

    /**
     *  simulates the case where someone makes inputs
     */
    public void sampleExecution() throws CouldNotAddItemException, ItemNotFoundException {
        System.out.println("Cashier starts new sale.\n");
        controller.startNewSale();
        System.out.println("Cashier enter items. \n");
        ItemDTO out = controller.scanItem(2, new Amount(1));
        System.out.println(out);
        out = controller.scanItem(1, new Amount(4));
        System.out.println(out);
        out = controller.scanItem(5, new Amount(5));
        System.out.println(out);
        System.out.println("Cashier displays the total with taxes. \n");
       /* out = controller.displayTotalAndTax();
        System.out.println(out);
        System.out.println("Cashier enters the paid amount. \n");
        out = controller.pay(new Amount(2000));
        System.out.println(out);*/
    }
}
