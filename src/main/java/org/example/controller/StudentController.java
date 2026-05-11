package org.example.controller;

import org.example.model.Student;
import org.example.service.IStudentService;
import org.example.service.impl.StudentServiceImpl;

import java.util.List;
import java.util.Scanner;

public class StudentController {
    private final Scanner scanner;
    private final IStudentService studentService;

    public StudentController(Scanner scanner) {
        this.scanner = scanner;
        this.studentService = new StudentServiceImpl();
    }

    public void handleStudentMenu() {
        while (true) {
            System.out.println("\n=========================================");
            System.out.println("           STUDENT MANAGEMENT");
            System.out.println("=========================================");
            System.out.println("[1] Add Student");
            System.out.println("[2] Update Student");
            System.out.println("[3] Remove Student");
            System.out.println("[4] View All Students");
            System.out.println("[0] Back to Main Menu");
            System.out.println("=========================================");
            System.out.print("Enter choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addStudent();
                    break;
                case "2":
                    updateStudent();
                    break;
                case "3":
                    removeStudent();
                    break;
                case "4":
                    viewAllStudents();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addStudent() {
        System.out.println("\n--- Add New Student ---");
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Full Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Program: ");
        String program = scanner.nextLine();

        Student student = new Student(id, name, program);
        studentService.addStudent(student);
        System.out.println("Student added successfully!");
    }

    private void updateStudent() {
        System.out.println("\n--- Update Student ---");
        System.out.print("Enter Student ID to update: ");
        String id = scanner.nextLine();
        System.out.print("Enter New Full Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter New Program: ");
        String program = scanner.nextLine();

        Student student = new Student(id, name, program);
        studentService.updateStudent(student);
        System.out.println("Student updated successfully!");
    }

    private void removeStudent() {
        System.out.println("\n--- Remove Student ---");
        System.out.print("Enter Student ID to remove: ");
        String id = scanner.nextLine();
        
        Student student = new Student(id, "", "");
        String result = studentService.removeStudent(student);
        System.out.println(result);
    }

    private void viewAllStudents() {
        System.out.println("\n--- All Registered Students ---");
        List<Student> students = studentService.getAllStudents();
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            students.forEach(System.out::println);
        }
    }
}
