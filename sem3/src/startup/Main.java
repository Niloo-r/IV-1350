package startup;

import controller.Controller;
import dbHandler.CatalogCreator;
import dbHandler.Printer;
import dbHandler.SystemCreator;
import view.View;

/**
 * the startup of the process and application
 */
public class Main {

    /**
     * the application is started.
     */
    public static void main(String[] args) {
        SystemCreator systemCreator = new SystemCreator();
        CatalogCreator catalogCreator = new CatalogCreator();
        Printer printer = new Printer();
        Controller controller = new Controller(systemCreator, catalogCreator, printer);
        View view = new View(controller);
        view.sampleExecution();
    }
}
