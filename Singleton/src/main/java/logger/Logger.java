package logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {

    private static Logger instance;

    private BufferedWriter writer;
    private String fileName = "default_log.txt";  // Default file name

    // Private constructor (Singleton)
    private Logger() {
        openFile();
    }

    // Get instance (Singleton)
    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // Open file for writing
    private void openFile() {
        try {
            writer = new BufferedWriter(new FileWriter(fileName, true)); // append mode
        } catch (IOException e) {
            System.out.println("Error opening log file: " + e.getMessage());
        }
    }

    // Change log file
    public synchronized void setFileName(String newFileName) {
        try {
            // Close the current file if open
            if (writer != null) {
                writer.close();
            }
        } catch (IOException e) {
            System.out.println("Error closing old log file: " + e.getMessage());
        }

        // Set new file name + open new file
        this.fileName = newFileName;
        openFile();
    }

    // Write a log message
    public synchronized void write(String message) {
        try {
            writer.write(message);
            writer.newLine();   // Each message on new line
            writer.flush();
        } catch (IOException e) {
            System.out.println("Error writing log: " + e.getMessage());
        }
    }

    // Close the logger manually
    public synchronized void close() {
        try {
            if (writer != null) {
                writer.close();
            }
        } catch (IOException e) {
            System.out.println("Error closing log file: " + e.getMessage());
        }
    }
}
