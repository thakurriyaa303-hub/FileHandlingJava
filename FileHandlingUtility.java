import java.io.*;

public class FileHandlingUtility {

    // Method to write data to a file
    public static void writeToFile(String fileName, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(content);
            System.out.println("Data written to file successfully.");
        } catch (IOException e) {
            System.out.println("Error while writing to file.");
            e.printStackTrace();
        }
    }

    // Method to read data from a file
    public static void readFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("\nReading data from file:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error while reading file.");
            e.printStackTrace();
        }
    }

    // Method to modify file content (append text)
    public static void modifyFile(String fileName, String newContent) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.newLine();
            writer.write(newContent);
            System.out.println("\nFile modified successfully.");
        } catch (IOException e) {
            System.out.println("Error while modifying file.");
            e.printStackTrace();
        }
    }

    // Main method
    public static void main(String[] args) {

        String fileName = "sample.txt";

        // Writing to file
        writeToFile(fileName, "Hello! This is the first line of the file.");

        // Reading file
        readFromFile(fileName);

        // Modifying file
        modifyFile(fileName, "This line is added later to modify the file.");

        // Reading file again after modification
        readFromFile(fileName);
    }
}