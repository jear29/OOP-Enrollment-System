package org.example.cli;

import org.example.model.Department;
import org.example.service.impl.DepartmentServiceImpl;

import java.util.Scanner;

public class DepartmentMenu {
    private final Scanner scanner;
    private final DepartmentServiceImpl departmentService;

    public DepartmentMenu(Scanner scanner, DepartmentServiceImpl departmentService) {
        this.scanner = scanner;
        this.departmentService = departmentService;
    }

    public void show() {
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
}
