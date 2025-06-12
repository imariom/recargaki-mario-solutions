package com.mario;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Test2 {
    /*
     * Give a HashMap it will write all the contents of it to a filen named filename.
     * 
     * @param filename The file to which to write the contents.
     * @param column The last column of the CSV file.
     * @param map The HashMap to be persisted to the file.
     */
    private static void writeFile(String fileName, String column, Map<String, String> map) {
        try (FileWriter csvWriter = new FileWriter(fileName)) {
            // Write header row
            csvWriter.append("Product code," + column + "\n");

            // Write data row
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();

                csvWriter.append(key).append(",");
                csvWriter.append(value).append("\n");
            }

            // Close the csvWriter to save the data
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        String csvFile = "products.csv";
        String delimiter = ",";

        Map<String, String> prodDesc = new HashMap<>();
        Map<String, String> prodCost = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            // Skip the header (not necessary)
            br.readLine(); // this line will make sure we read the header and ignore it

            while ((line = br.readLine()) != null) {
                String[] fields = line.split(delimiter);
                if (fields.length >= 2) {
                    String code = fields[0].trim();
                    String description = fields[1].trim();
                    String cost = fields[2].trim();

                    // product code as the key and product description
                    prodDesc.put(code, description);

                    // product code as the key and cost (amount)
                    prodCost.put(code, cost);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Write Product and Description to a file
        writeFile("product-desc.csv", "Description", prodDesc);

        // Write Product and Description to a file
        writeFile("product-amount.csv", "Cost", prodCost);
    }
}