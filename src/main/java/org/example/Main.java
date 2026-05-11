package org.example;

import org.example.cli.*;
import org.example.service.impl.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StudentServiceImpl studentService = new StudentServiceImpl();
        InstructorServiceImpl instructorService = new InstructorServiceImpl();
        CourseServiceImpl courseService = new CourseServiceImpl();
        SectionServiceImpl sectionService = new SectionServiceImpl();
        DepartmentServiceImpl departmentService = new DepartmentServiceImpl();
        EnrollmentServiceImpl enrollmentService = new EnrollmentServiceImpl();
        TuitionServiceImpl tuitionService = new TuitionServiceImpl();

        StudentMenu studentMenu = new StudentMenu(scanner, studentService);
        InstructorMenu instructorMenu = new InstructorMenu(scanner, instructorService, sectionService);
        CourseMenu courseMenu = new CourseMenu(scanner, courseService);
        SectionMenu sectionMenu = new SectionMenu(scanner, sectionService);
        DepartmentMenu departmentMenu = new DepartmentMenu(scanner, departmentService);
        EnrollmentMenu enrollmentMenu = new EnrollmentMenu(scanner, enrollmentService, studentService, sectionService,
                departmentService);
        TuitionMenu tuitionMenu = new TuitionMenu(scanner, tuitionService);

        boolean running = true;
        while (running) {
            System.out.println("\n======================================");
            System.out.println("===      ENROLLMENT SYSTEM         ===");
            System.out.println("======================================");
            System.out.println("[1] Student Management");
            System.out.println("[2] Instructor Management");
            System.out.println("[3] Course Management");
            System.out.println("[4] Section Management");
            System.out.println("[5] Department Management");
            System.out.println("[6] Enrollment Management");
            System.out.println("[7] Tuition Management");
            System.out.println("[0] Exit");
            System.out.print("Choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> studentMenu.show();
                case "2" -> instructorMenu.show();
                case "3" -> courseMenu.show();
                case "4" -> sectionMenu.show();
                case "5" -> departmentMenu.show();
                case "6" -> enrollmentMenu.show();
                case "7" -> tuitionMenu.show();
                case "0" -> {
                    System.out.println("Goodbye!");
                    running = false;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
        scanner.close();
    }
}