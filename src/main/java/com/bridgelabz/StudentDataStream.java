package com.bridgelabz;

import java.io.*;

class Student {
    int rollNumber;
    String name;
    double gpa;

    public Student(int rollNumber, String name, double gpa) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.gpa = gpa;
    }
}

public class StudentDataStream {
    private static final String FILE_NAME = "src/main/java/com/bridgelabz/students.dat";

    public static void writeStudentData(Student student) {
        try (DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(FILE_NAME,true)))) {
            dos.writeInt(student.rollNumber);
            dos.writeUTF(student.name);
            dos.writeDouble(student.gpa);
            System.out.println("Student data written successfully.");
        } catch (IOException e) {
            System.err.println("Error writing student data: " + e.getMessage());
        }
    }

    public static void readStudentData() {
        try (DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(FILE_NAME)))) {
            while (dis.available() > 0) {
                int rollNumber = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();
                
                System.out.println("Student Details:");
                System.out.println("Roll Number: " + rollNumber);
                System.out.println("Name: " + name);
                System.out.println("GPA: " + gpa);
            }
        } catch (IOException e) {
            System.err.println("Error reading student data: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Student student1 = new Student(101, "Alice", 3.8);
        Student student2 = new Student(102, "Bob", 3.5);
        
        writeStudentData(student1);
        writeStudentData(student2);
        readStudentData();
    }
}
