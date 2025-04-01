package com.bridgelabz;

import java.io.*;

public class LargeFileReader {
    public static void main(String[] args) {
        String filePath = "largefile.txt"; // Replace with actual file path
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.toLowerCase().contains("error")) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
