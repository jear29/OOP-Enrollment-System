package org.example.cli;

import org.example.model.ScholarshipType;
import org.example.model.TuitionFeePayment;
import org.example.service.impl.TuitionServiceImpl;

import java.util.Scanner;

public class TuitionMenu {
    private final Scanner scanner;
    private final TuitionServiceImpl tuitionService;

    public TuitionMenu(Scanner scanner, TuitionServiceImpl tuitionService) {
        this.scanner = scanner;
        this.tuitionService = tuitionService;
    }

    public void show() {
        TuitionFeePayment sessionPayment = new TuitionFeePayment(0, 0);
        boolean back = false;
        while (!back) {
            System.out.println("\n=== TUITION MANAGEMENT (Session-based) ===");
            System.out.println("[1] Calculate Fee (Manual Discount)");
            System.out.println("[2] Calculate Fee (Scholarship)");
            System.out.println("[3] Make Payment");
            System.out.println("[4] View Balance");
            System.out.println("[5] Check Status");
            System.out.println("[0] Back");
            System.out.print("Choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> {
                    System.out.print("Number of Units: ");
                    int units = Integer.parseInt(scanner.nextLine());
                    System.out.print("Manual Discount Rate (e.g., 0.1 for 10%): ");
                    double discount = Double.parseDouble(scanner.nextLine());

                    double total = tuitionService.calculateFee(sessionPayment, units, discount);
                    System.out.println("Total Tuition Calculated: " + total);
                }
                case "2" -> {
                    System.out.print("Number of Units: ");
                    int units = Integer.parseInt(scanner.nextLine());
                    System.out.println("Select Scholarship Type:");
                    System.out.println("[1] Academic (100% Discount)");
                    System.out.println("[2] Partial (50% Discount)");
                    System.out.println("[3] Athletic (25% Discount)");
                    System.out.println("[4] None (0% Discount)");
                    System.out.print("Choice: ");
                    String sChoice = scanner.nextLine();
                    
                    ScholarshipType type = switch (sChoice) {
                        case "1" -> ScholarshipType.ACADEMIC;
                        case "2" -> ScholarshipType.PARTIAL;
                        case "3" -> ScholarshipType.ATHLETIC;
                        default -> ScholarshipType.NONE;
                    };

                    double total = tuitionService.calculateFee(sessionPayment, units, type);
                    System.out.println("Total Tuition Calculated (" + type + "): " + total);
                }
                case "3" -> {
                    System.out.print("Amount to Pay: ");
                    double amount = Double.parseDouble(scanner.nextLine());
                    tuitionService.makePayment(sessionPayment, amount);
                    System.out.println("Payment processed.");
                }
                case "4" -> {
                    System.out.println("Current Balance: " + tuitionService.getRemainingBalance(sessionPayment));
                }
                case "5" -> {
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
