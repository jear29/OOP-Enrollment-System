package org.example.cli;

import org.example.model.Instructor;
import org.example.model.Section;
import org.example.service.impl.InstructorServiceImpl;
import org.example.service.impl.SectionServiceImpl;

import java.util.Scanner;

public class InstructorMenu {
    private final Scanner scanner;
    private final InstructorServiceImpl instructorService;
    private final SectionServiceImpl sectionService;

    public InstructorMenu(Scanner scanner, InstructorServiceImpl instructorService, SectionServiceImpl sectionService) {
        this.scanner = scanner;
        this.instructorService = instructorService;
        this.sectionService = sectionService;
    }

    public void show() {
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
}
