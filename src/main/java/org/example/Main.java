package org.example;

import org.example.model.Course;
import org.example.model.Instructor;
import org.example.model.Student;
import org.example.model.Section;
import org.example.model.Department;
import org.example.model.TuitionFeePayment;
import org.example.service.impl.CourseServiceImpl;
import org.example.service.impl.InstructorServiceImpl;
import org.example.service.impl.StudentServiceImpl;
import org.example.service.impl.TuitionServiceImpl;
import org.example.service.impl.SectionServiceImpl;
import org.example.service.impl.DepartmentServiceImpl;
import org.example.service.impl.EnrollmentServiceImpl;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static StudentServiceImpl studentService = new StudentServiceImpl();
    static InstructorServiceImpl instructorService = new InstructorServiceImpl();
    static CourseServiceImpl courseService = new CourseServiceImpl();
    static SectionServiceImpl sectionService = new SectionServiceImpl();
    static DepartmentServiceImpl departmentService = new DepartmentServiceImpl();
    static EnrollmentServiceImpl enrollmentService = new EnrollmentServiceImpl();
    static TuitionServiceImpl tuitionService = new TuitionServiceImpl();

    public static void main(String[] args) {
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
                case "1" -> studentMenu();
                case "2" -> instructorMenu();
                case "3" -> courseMenu();
                case "4" -> sectionMenu();
                case "5" -> departmentMenu();
                case "6" -> enrollmentMenu();
                case "7" -> tuitionMenu();
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

                    Instructor targetI = null;
                    for (Instructor i : instructorService.getAllInstructors()) {
                        if (i.getID().equals(iid)) {
                            targetI = i;
                            break;
                        }
                    }
                    
                    Section targetS = null;
                    for (Section s : sectionService.getAllSections()) {
                        if (s.getSectionId().equals(sid)) {
                            targetS = s;
                            break;
                        }
                    }

                    if (targetI != null && targetS != null) {
                        instructorService.assignInstructorToSection(targetI, targetS);
                    } else {
                        System.out.println("Instructor or Section not found.");
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

    // ── SECTION MENU ──────────────────────────────────────
    static void sectionMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n=== SECTION MANAGEMENT ===");
            System.out.println("[0] Back  [1] Add  [2] View All  [3] Update  [4] Remove");
            System.out.print("Choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> {
                    System.out.print("Section ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Section Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Max Capacity: ");
                    int cap = Integer.parseInt(scanner.nextLine());

                    sectionService.addSection(new Section(id, name, cap));
                    System.out.println("Section added successfully.");
                }
                case "2" -> {
                    var list = sectionService.getAllSections();
                    if (list.isEmpty()) {
                        System.out.println("No sections found.");
                    } else {
                        System.out.println("\nList of Sections:");
                        list.forEach(System.out::println);
                    }
                }
                case "3" -> {
                    System.out.print("Section ID to update: ");
                    String id = scanner.nextLine();
                    System.out.print("New Name: ");
                    String name = scanner.nextLine();
                    System.out.print("New Capacity: ");
                    int cap = Integer.parseInt(scanner.nextLine());

                    sectionService.updateSection(new Section(id, name, cap));
                    System.out.println("Update attempt completed.");
                }
                case "4" -> {
                    System.out.print("Section ID to remove: ");
                    String id = scanner.nextLine();
                    String result = sectionService.removeSection(new Section(id, "", 0));
                    System.out.println("Result: " + result);
                }
                case "0" -> back = true;
                default -> System.out.println("Invalid Choice.");
            }
        }
    }

    // ── DEPARTMENT MENU ───────────────────────────────────
    static void departmentMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n=== DEPARTMENT MANAGEMENT ===");
            System.out.println("[0] Back  [1] Add  [2] View All  [3] Update  [4] Remove");
            System.out.print("Choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> {
                    System.out.print("Department ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Department Name: ");
                    String name = scanner.nextLine();

                    departmentService.addDepartment(new Department(id, name));
                    System.out.println("Department added successfully.");
                }
                case "2" -> {
                    var list = departmentService.getAllDepartments();
                    if (list.isEmpty()) {
                        System.out.println("No departments found.");
                    } else {
                        System.out.println("\nList of Departments:");
                        list.forEach(System.out::println);
                    }
                }
                case "3" -> {
                    System.out.print("Department ID to update: ");
                    String id = scanner.nextLine();
                    System.out.print("New Name: ");
                    String name = scanner.nextLine();

                    departmentService.updateDepartment(new Department(id, name));
                    System.out.println("Update attempt completed.");
                }
                case "4" -> {
                    System.out.print("Department ID to remove: ");
                    String id = scanner.nextLine();
                    String result = departmentService.removeDepartment(new Department(id, ""));
                    System.out.println("Result: " + result);
                }
                case "0" -> back = true;
                default -> System.out.println("Invalid Choice.");
            }
        }
    }

    // ── ENROLLMENT MENU ───────────────────────────────────
    static void enrollmentMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n=== ENROLLMENT MANAGEMENT ===");
            System.out.println("[1] Enroll Student in Section");
            System.out.println("[2] Add Section to Department");
            System.out.println("[3] View Institutional Hierarchy");
            System.out.println("[0] Back");
            System.out.print("Choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> {
                    System.out.print("Student ID: ");
                    String sid = scanner.nextLine();
                    System.out.print("Section ID: ");
                    String secId = scanner.nextLine();

                    Student student = null;
                    for (Student s : studentService.getAllStudents()) {
                        if (s.getID().equals(sid)) {
                            student = s;
                            break;
                        }
                    }

                    Section section = null;
                    for (Section s : sectionService.getAllSections()) {
                        if (s.getSectionId().equals(secId)) {
                            section = s;
                            break;
                        }
                    }

                    if (student != null && section != null) {
                        enrollmentService.enrollStudentInSection(student, section);
                    } else {
                        System.out.println("Student or Section not found.");
                    }
                }
                case "2" -> {
                    System.out.print("Section ID: ");
                    String secId = scanner.nextLine();
                    System.out.print("Department ID: ");
                    String deptId = scanner.nextLine();

                    Section section = null;
                    for (Section s : sectionService.getAllSections()) {
                        if (s.getSectionId().equals(secId)) {
                            section = s;
                            break;
                        }
                    }

                    Department department = null;
                    for (Department d : departmentService.getAllDepartments()) {
                        if (d.getDepartmentId().equals(deptId)) {
                            department = d;
                            break;
                        }
                    }

                    if (section != null && department != null) {
                        enrollmentService.addSectionToDepartment(section, department);
                    } else {
                        System.out.println("Section or Department not found.");
                    }
                }
                case "3" -> {
                    System.out.print("Department ID: ");
                    String deptId = scanner.nextLine();

                    Department department = null;
                    for (Department d : departmentService.getAllDepartments()) {
                        if (d.getDepartmentId().equals(deptId)) {
                            department = d;
                            break;
                        }
                    }

                    if (department != null) {
                        enrollmentService.viewDepartmentHierarchy(department);
                    } else {
                        System.out.println("Department not found.");
                    }
                }
                case "0" -> back = true;
                default -> System.out.println("Invalid Choice.");
            }
        }
    }

    // ── TUITION MENU ──────────────────────────────────────
    static void tuitionMenu() {
        TuitionFeePayment sessionPayment = new TuitionFeePayment(0, 0);
        boolean back = false;
        while (!back) {
            System.out.println("\n=== TUITION MANAGEMENT (Session-based) ===");
            System.out.println("[1] Calculate Fee  [2] Make Payment  [3] View Balance  [4] Check Status  [0] Back");
            System.out.print("Choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> {
                    System.out.print("Number of Units: ");
                    int units = Integer.parseInt(scanner.nextLine());
                    System.out.print("Discount Rate (e.g., 0.1 for 10%): ");
                    double discount = Double.parseDouble(scanner.nextLine());

                    double total = tuitionService.calculateFee(sessionPayment, units, discount);
                    System.out.println("Total Tuition Calculated: " + total);
                }
                case "2" -> {
                    System.out.print("Amount to Pay: ");
                    double amount = Double.parseDouble(scanner.nextLine());
                    tuitionService.makePayment(sessionPayment, amount);
                    System.out.println("Payment processed.");
                }
                case "3" -> {
                    System.out.println("Current Balance: " + tuitionService.getRemainingBalance(sessionPayment));
                }
                case "4" -> {
                    if (tuitionService.isFullyPaid(sessionPayment)) {
                        System.out.println("Status: Fully Paid.");
                    } else {
                        System.out.println("Status: Not Fully Paid.");
                    }
                }
                case "0" -> back = true;
                default -> System.out.println("Invalid Choice.");
            }
        }
    }
}