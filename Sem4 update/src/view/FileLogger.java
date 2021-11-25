package view;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * This class creates a logger that writes a string to a file.
 */
public class FileLogger {
    private PrintWriter logStream;

    /**
     * Constructor for FileLogger. Creates a new PrintWriter to logStream.
     */
    public FileLogger() {
        try {
            logStream = new PrintWriter(new FileWriter("log.txt"), true);
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
        logStream.println(message);
    }
}
