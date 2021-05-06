package view;

import controller.Controller;
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
    public void sampleExecution(){
        System.out.println("Cashier starts new sale.\n");
        controller.startNewSale();
        System.out.println("Cashier enter items. \n");
        String out = controller.scanItem("tandkräm", new Amount(1));
        System.out.println(out);
        out = controller.scanItem("tandborste", new Amount(4));
        System.out.println(out);
        out = controller.scanItem("Tomat", new Amount(5));
        System.out.println(out);
        System.out.println("Cashier displays the total with taxes. \n");
        out = controller.displayTotalAndTax();
        System.out.println(out);
        System.out.println("Cashier enters the paid amount. \n");
        out = controller.pay(new Amount(2000));
        System.out.println(out);
    }
}
