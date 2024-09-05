import java.io.*;
import java.util.*;

public class DataFromFile {

    // Static lists to store names and numbers
    static ArrayList<String> namesList = new ArrayList<>();
    static ArrayList<Double> numsList = new ArrayList<>();

    public static void main(String[] args) {
        // File handling and data reading
        File inputFile = new File ("input.txt");
        File duplicatesFile = new File("duplicates.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;

            // Reading the file and categorizing the input into lists
            while ((line = br.readLine()) != null) {
                try {
                    // Try parsing it as a number
                    double num = Double.parseDouble(line);
                    numsList.add(num);
                } catch (NumberFormatException e) {
                    // It's not a number, so treat it as a name
                    namesList.add(line);
                }
            }

            // Sort names alphabetically
            Collections.sort(namesList);

            // Sort numbers from smallest to largest
            Collections.sort(numsList);

            // Display sorted names
            System.out.println("Names sorted: " + String.join(", ", namesList));

            // Display sorted numbers
            System.out.println("Numbers sorted: " + numsList.toString().replace("[", "").replace("]", ""));

            // Calculate and display average name length
            double avgLength = namesList.stream().mapToInt(String::length).average().orElse(0);
            System.out.printf("Average length of names: %.2f%n", avgLength);

            // Find and display duplicate names
            Set<String> duplicateNames = findDuplicates(namesList);
            if (!duplicateNames.isEmpty()) {
                System.out.println("Duplicate names: " + String.join(", ", duplicateNames));

                // Write duplicates to the file (append mode)
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(duplicatesFile, true))) {
                    for (String name : duplicateNames) {
                        bw.write(name);
                        bw.newLine();
                    }
                } catch (IOException e) {
                    System.out.println("Error writing to duplicates.txt: " + e.getMessage());
                }
            } else {
                System.out.println("No duplicates found.");
            }

        } catch (IOException e) {
            System.out.println("Error reading input.txt: " + e.getMessage());
        }
    }

    // Helper method to find duplicates in a list of names
    private static Set<String> findDuplicates(List<String> list) {
        Set<String> duplicates = new HashSet<>();
        Set<String> uniqueNames = new HashSet<>();

        for (String name : list) {
            if (!uniqueNames.add(name)) {
                duplicates.add(name);
            }
        }
        return duplicates;
    }
}