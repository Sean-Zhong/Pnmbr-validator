import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PnmbrValidator {
    public static void main(String[] args) {
        String inputFilePath = "testData.csv";
        String outputFilePath = "output.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilePath))) {
            
            // Skip the header line in the input CSV file
            br.readLine();

            // Write the header to the output CSV file
            bw.write("PersonalNumber,NummerType,Valid");
            bw.newLine();

            String line;
            while ((line = br.readLine()) != null) {
                String result = processLine(line);
                bw.write(result);
                bw.newLine();
            }
        } catch (IOException e) {
            // Handle file IO exceptions
            e.printStackTrace();
        }
    }

    private static String processLine(String line) {
        Person person = PersonController.controll(line);
        return person.toString();
    }
}
