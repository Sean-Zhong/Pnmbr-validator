import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.*;

public class PnmbrValidator {
    private static final Logger logger = LoggingUtility.getLogger();
    public static void main(String[] args) {
        String inputFilePath = "input.csv";
        String outputFilePath = "output.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilePath))) {
            
            LoggingUtility.initializeLogger();

            // Skip the header line in the input CSV file
            br.readLine();

            // Write the header to the output CSV file
            bw.write("PersonalNumber,NumberType,Valid");
            bw.newLine();

            String line;
            while ((line = br.readLine()) != null) {
                String result = processLine(line);
                bw.write(result);
                bw.newLine();
            }
        } catch (IOException e) {
            // Handle file IO exceptions
            logger.log(Level.SEVERE, "Error occurred while reading/writing file", e);
        }
    }

    private static String processLine(String line) {
        try {
            Person person = new Person(line);
            return person.toString();
        } catch (Exception e) {
            // Handle exceptions from PersonController
            logger.log(Level.SEVERE, "Error occurred while processing line: " + line, e);
            return ""; // Return empty string or some placeholder for failed lines
        }
    }
}
