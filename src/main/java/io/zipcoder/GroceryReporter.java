package io.zipcoder;

import io.zipcoder.utils.FileReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;

public class GroceryReporter {
    private final String originalFileText;

    public GroceryReporter(String jerksonFileName) {
        this.originalFileText = FileReader.readFile(jerksonFileName);
    }

    @Override
    public String toString() {
        StringBuilder fileContent = new StringBuilder();
        GroceryReporter reporter = new GroceryReporter(originalFileText);
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(originalFileText))){
            String line;
            while ((line = reader.readLine()) != null){
                fileContent.append(line).append(System.lineSeparator());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return fileContent.toString();
    }
}
