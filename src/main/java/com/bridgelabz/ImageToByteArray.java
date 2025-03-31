package com.bridgelabz;

import java.io.*;

public class ImageToByteArray {
    public static void main(String[] args) {
        String inputImage = "src/main/java/com/bridgelabz/download.jpeg";
        String outputImage = "src/main/java/com/bridgelabz/output.jpeg";
        File file = new File(inputImage);
        try (FileInputStream fis = new FileInputStream(file); ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[1024];
            int byteReader;

            while ((byteReader = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, byteReader);
            }

//            System.out.println(baos);

            try (ByteArrayInputStream bis = new ByteArrayInputStream(baos.toByteArray()); FileOutputStream fos = new FileOutputStream(outputImage)) {
                byte[] outputBuffer = new byte[1024];
                int byteRead;
                while ((byteRead = bis.read(outputBuffer)) != -1) {
                    fos.write(outputBuffer, 0, byteRead);
                }

            } catch (Exception e) {
                System.out.println("Exception while writing image");
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
