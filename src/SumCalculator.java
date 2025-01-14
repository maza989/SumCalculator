import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class SumCalculator {
    public static void main(String[] args) {
        // Provide the path to your data file
        String filePath = "data/numbers.txt";  // Make sure this is correct relative to the project folder
        try {
            int sum = calculateSum(filePath);
            System.out.println("The sum of numbers is: " + sum);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public static int calculateSum(String filePath) throws IOException {
        File file = new File(filePath);
        
        // Check if the file exists
        if (!file.exists()) {
            System.out.println("File not found: " + filePath);
            return 0;  // Return 0 if file is not found
        }

        Scanner scanner = new Scanner(file);
        int sum = 0;

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                sum += scanner.nextInt();
            } else {
                scanner.next();  // Skip non-integer values
            }
        }
        scanner.close();
        return sum;
    }
}
