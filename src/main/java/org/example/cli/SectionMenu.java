package org.example.cli;

import org.example.model.Section;
import org.example.service.impl.SectionServiceImpl;

import java.util.Scanner;

public class SectionMenu {
    private final Scanner scanner;
    private final SectionServiceImpl sectionService;

    public SectionMenu(Scanner scanner, SectionServiceImpl sectionService) {
        this.scanner = scanner;
        this.sectionService = sectionService;
    }

    public void show() {
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
}
