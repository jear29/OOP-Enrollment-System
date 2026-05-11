package org.example.cli;

import org.example.model.Course;
import org.example.service.impl.CourseServiceImpl;

import java.util.Scanner;

public class CourseMenu {
    private final Scanner scanner;
    private final CourseServiceImpl courseService;

    public CourseMenu(Scanner scanner, CourseServiceImpl courseService) {
        this.scanner = scanner;
        this.courseService = courseService;
    }

    public void show() {
        boolean back = false;
        while (!back) {
            System.out.println("\n=== COURSE MANAGEMENT ===");
            System.out.println("[0] Back  [1] Add  [2] View All  [3] Update  [4] Remove");
            System.out.print("Choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> {
                    System.out.print("Course ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Course Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Program: ");
                    String program = scanner.nextLine();

                    courseService.addCourse(new Course(id, name, program));
                    System.out.println("Course added successfully.");
                }
                case "2" -> {
                    var list = courseService.getAllCourses();
                    if (list.isEmpty()) {
                        System.out.println("No courses found.");
                    } else {
                        System.out.println("\nList of Courses:");
                        list.forEach(System.out::println);
                    }
                }
                case "3" -> {
                    System.out.print("Course ID to update: ");
                    String id = scanner.nextLine();
                    System.out.print("New Name: ");
                    String name = scanner.nextLine();
                    System.out.print("New Program: ");
                    String program = scanner.nextLine();

                    courseService.updateCourse(new Course(id, name, program));
                    System.out.println("Update attempt completed.");
                }
                case "4" -> {
                    System.out.print("Course ID to remove: ");
                    String id = scanner.nextLine();
                    String result = courseService.removeCourse(new Course(id, "", ""));
                    System.out.println("Result: " + result);
                }
                case "0" -> back = true;
                default -> System.out.println("Invalid Choice.");
            }
        }
    }
}
