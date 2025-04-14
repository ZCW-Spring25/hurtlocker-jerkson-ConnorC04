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
        int errorCount = 0;

        return null;
    }
}
