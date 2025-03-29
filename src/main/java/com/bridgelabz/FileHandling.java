package com.bridgelabz;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileHandling {
    public static void main(String[] args) {
        try( FileInputStream fis = new FileInputStream("src/main/java/com/bridgelabz/input.txt");
            FileOutputStream fos = new FileOutputStream("src/main/java/com/bridgelabz/output.txt")){
            int byteData;
            while ((byteData = fis.read()) != -1){
                fos.write(byteData);
            }

            System.out.println("File copied successfully.");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
