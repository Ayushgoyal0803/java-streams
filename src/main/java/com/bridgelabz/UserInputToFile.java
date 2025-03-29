package com.bridgelabz;

import java.io.*;

public class UserInputToFile {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileWriter writer = new FileWriter("src/main/java/com/bridgelabz/user_data.txt")) {

            System.out.print("Enter your name: ");
            String name = reader.readLine();

            System.out.print("Enter your age: ");
            int age = Integer.parseInt(reader.readLine());

            System.out.print("Enter your favorite programming language: ");
            String language = reader.readLine();

            writer.write("Name: " + name + "\n");
            writer.write("Age: " + age + "\n");
            writer.write("Favorite Programming Language: " + language + "\n");

            System.out.println("User information saved to user_data.txt");
        } catch (IOException e) {
            System.err.println("Error reading input or writing to file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Invalid age input. Please enter a valid number.");
        }
    }
}
