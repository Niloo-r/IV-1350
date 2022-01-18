package view;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * This class creates a logger that writes a string to a file.
 */
public class FileLogger {
    private PrintWriter logStream;
    private PrintWriter logStreamPayment;


    /**
     * Constructor for FileLogger. Creates a new PrintWriter to logStream.
     */
    public FileLogger() {
        try {
            logStream = new PrintWriter(new FileWriter("log.txt", true), true);
        } catch (IOException e) {
            System.out.println("Unable to log");
            e.printStackTrace();
        }
    }

    /**
     * Writes a String to the file connected to the logStream.
     *
     * @param message The String to be written to the file.
     */
    public void log(String message) {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());

        logStream.println(timeStamp); //Print time
        logStream.println(message);
    }
}
