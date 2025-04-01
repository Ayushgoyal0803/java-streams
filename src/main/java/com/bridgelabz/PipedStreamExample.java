package com.bridgelabz;

import java.io.*;

class WriterThread extends Thread {
    private PipedOutputStream pos;

    public WriterThread(PipedOutputStream pos) {
        this.pos = pos;
    }

    @Override
    public void run() {
        try {
            String message = "Hello from WriterThread!";
            pos.write(message.getBytes());
            pos.close();
        } catch (IOException e) {
            System.err.println("WriterThread Error: " + e.getMessage());
        }
    }
}

class ReaderThread extends Thread {
    private PipedInputStream pis;

    public ReaderThread(PipedInputStream pis) {
        this.pis = pis;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(pis));
            String receivedMessage = reader.readLine();
            System.out.println("ReaderThread received: " + receivedMessage);
            pis.close();
        } catch (IOException e) {
            System.err.println("ReaderThread Error: " + e.getMessage());
        }
    }
}

public class PipedStreamExample {
    public static void main(String[] args) {
        try {
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos);
            
            Thread writer = new WriterThread(pos);
            Thread reader = new ReaderThread(pis);
            
            writer.start();
            reader.start();
            
            writer.join();
            reader.join();
        } catch (IOException | InterruptedException e) {
            System.err.println("Main Thread Error: " + e.getMessage());
        }
    }
}
