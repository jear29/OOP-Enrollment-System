package org.example;

import org.example.model.Student;
import org.example.service.impl.StudentServiceImpl;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static StudentServiceImpl studentService = new StudentServiceImpl();

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("\n======================================");
            System.out.println("===      ENROLLMENT SYSTEM         ===");
            System.out.println("======================================");
            System.out.println("[1] Student Management");
            System.out.println("[0] Exit");
            System.out.print("Choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> studentMenu();
                case "0" -> {
                    System.out.println("Goodbye!");
                    running = false;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    // ── STUDENT MENU ──────────────────────────────────────
    static void studentMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n=== STUDENT MANAGEMENT ===");
            System.out.println("[0] Back  [1] Add  [2] View All  [3] Update  [4] Remove");
            System.out.print("Choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> {
                    System.out.print("ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Program: ");
                    String program = scanner.nextLine();

                    studentService.addStudent(new Student(id, name, program));
                    System.out.println("Student added successfully.");
                }
                case "2" -> {
                    var list = studentService.getAllStudents();
                    if (list.isEmpty()) {
                        System.out.println("No students found.");
                    } else {
                        System.out.println("\nList of Students:");
                        list.forEach(System.out::println);
                    }
                }
                case "3" -> {
                    System.out.print("ID to update: ");
                    String id = scanner.nextLine();
                    System.out.print("New Name: ");
                    String name = scanner.nextLine();
                    System.out.print("New Program: ");
                    String program = scanner.nextLine();

                    studentService.updateStudent(new Student(id, name, program));
                    System.out.println("Update attempt completed.");
                }
                case "4" -> {
                    System.out.print("ID to remove: ");
                    String id = scanner.nextLine();
                    String result = studentService.removeStudent(new Student(id, "", ""));
                    System.out.println("Result: " + result);
                }
                case "0" -> back = true;
                default -> System.out.println("Invalid Choice.");
            }
        }
    }
}