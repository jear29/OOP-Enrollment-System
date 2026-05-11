package org.example.cli;

import org.example.model.Department;
import org.example.model.Section;
import org.example.model.Student;
import org.example.service.impl.DepartmentServiceImpl;
import org.example.service.impl.EnrollmentServiceImpl;
import org.example.service.impl.SectionServiceImpl;
import org.example.service.impl.StudentServiceImpl;

import java.util.Scanner;

public class EnrollmentMenu {
    private final Scanner scanner;
    private final EnrollmentServiceImpl enrollmentService;
    private final StudentServiceImpl studentService;
    private final SectionServiceImpl sectionService;
    private final DepartmentServiceImpl departmentService;

    public EnrollmentMenu(Scanner scanner, 
                          EnrollmentServiceImpl enrollmentService,
                          StudentServiceImpl studentService,
                          SectionServiceImpl sectionService,
                          DepartmentServiceImpl departmentService) {
        this.scanner = scanner;
        this.enrollmentService = enrollmentService;
        this.studentService = studentService;
        this.sectionService = sectionService;
        this.departmentService = departmentService;
    }

    public void show() {
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
}
