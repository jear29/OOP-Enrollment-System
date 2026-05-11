package org.example;

import org.example.model.Course;
import org.example.model.Instructor;
import org.example.model.Student;
import org.example.model.Section;
import org.example.service.impl.CourseServiceImpl;
import org.example.service.impl.InstructorServiceImpl;
import org.example.service.impl.StudentServiceImpl;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static StudentServiceImpl studentService = new StudentServiceImpl();
    static InstructorServiceImpl instructorService = new InstructorServiceImpl();
    static CourseServiceImpl courseService = new CourseServiceImpl();

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("\n======================================");
            System.out.println("===      ENROLLMENT SYSTEM         ===");
            System.out.println("======================================");
            System.out.println("[1] Student Management");
            System.out.println("[2] Instructor Management");
            System.out.println("[3] Course Management");
            System.out.println("[0] Exit");
            System.out.print("Choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> studentMenu();
                case "2" -> instructorMenu();
                case "3" -> courseMenu();
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

    // ── INSTRUCTOR MENU ───────────────────────────────────
    static void instructorMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n=== INSTRUCTOR MANAGEMENT ===");
            System.out.println("[1] Add Instructor");
            System.out.println("[2] View All Instructors");
            System.out.println("[3] View Instructor Details");
            System.out.println("[4] Assign Instructor to Section");
            System.out.println("[5] Update Instructor");
            System.out.println("[6] Remove Instructor");
            System.out.println("[0] Back to Main Menu");
            System.out.print("Choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> {
                    System.out.print("ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Department: ");
                    String department = scanner.nextLine();

                    instructorService.addInstructor(new Instructor(id, name, department));
                    System.out.println("Instructor added successfully.");
                }
                case "2" -> {
                    var list = instructorService.getAllInstructors();
                    if (list.isEmpty()) {
                        System.out.println("No instructors found.");
                    } else {
                        System.out.println("\nList of Instructors:");
                        list.forEach(System.out::println);
                    }
                }
                case "3" -> {
                    System.out.print("Enter Instructor ID: ");
                    String id = scanner.nextLine();
                    String details = instructorService.getInstructorDetails(new Instructor(id, "", ""));
                    System.out.println("\nDetails: " + details);
                }
                case "4" -> {
                    System.out.print("Instructor ID: ");
                    String iid = scanner.nextLine();
                    System.out.print("Section ID: ");
                    String sid = scanner.nextLine();

                    Instructor target = null;
                    for (Instructor i : instructorService.getAllInstructors()) {
                        if (i.getID().equals(iid)) {
                            target = i;
                            break;
                        }
                    }

                    if (target != null) {
                        instructorService.assignInstructorToSection(target, new Section(sid, 0));
                    } else {
                        System.out.println("Instructor not found.");
                    }
                }
                case "5" -> {
                    System.out.print("ID to update: ");
                    String id = scanner.nextLine();
                    System.out.print("New Name: ");
                    String name = scanner.nextLine();
                    System.out.print("New Department: ");
                    String department = scanner.nextLine();

                    instructorService.updateInstructor(new Instructor(id, name, department));
                    System.out.println("Update attempt completed.");
                }
                case "6" -> {
                    System.out.print("ID to remove: ");
                    String id = scanner.nextLine();
                    String result = instructorService.removeInstructor(new Instructor(id, "", ""));
                    System.out.println("Result: " + result);
                }
                case "0" -> back = true;
                default -> System.out.println("Invalid Choice.");
            }
        }
    }

    // ── COURSE MENU ───────────────────────────────────────
    static void courseMenu() {
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