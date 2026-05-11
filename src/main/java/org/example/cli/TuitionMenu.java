package org.example.cli;

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
