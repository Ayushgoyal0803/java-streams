package com.bridgelabz;

import java.io.*;

public class UppercaseToLowercase {
    public static void main(String[] args) {
        String inputFile = "src/main/java/com/bridgelabz/input.txt";
        String outputFile = "src/main/java/com/bridgelabz/output.txt";

        try (
                FileReader fr = new FileReader(inputFile);
                BufferedReader br = new BufferedReader(fr);
                FileWriter fw = new FileWriter(outputFile);
                BufferedWriter bw = new BufferedWriter(fw)
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line.toLowerCase());
                bw.newLine(); // Maintain line breaks
            }
            System.out.println("File conversion completed successfully!");
        } catch (IOException e) {
            System.err.println("Error processing the file: " + e.getMessage());
        }
    }
}


