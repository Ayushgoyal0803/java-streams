package com.bridgelabz;

import java.io.*;

public class BufferedStreams {
    public static void main(String[] args) {
        try(BufferedInputStream bin = new BufferedInputStream(new FileInputStream("src/main/java/com/bridgelabz/input.txt"));
            BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream("src/main/java/com/bridgelabz/output.txt"))){
            byte[] buffer = new byte[4096];
            int byteReads;
            while ((byteReads = bin.read(buffer)) !=-1){
                bout.write(buffer, 0, byteReads);
            }
            System.out.println("file copied successfully");
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
