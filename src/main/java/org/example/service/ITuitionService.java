package org.example.service;

import org.example.model.ScholarshipType;
import org.example.model.TuitionFeePayment;

public interface ITuitionService {
    double calculateFee(TuitionFeePayment payment, int units, double discountRate);

    double calculateFee(TuitionFeePayment payment, int units, ScholarshipType scholarshipType);

    void makePayment(TuitionFeePayment payment, double amount);

    double getRemainingBalance(TuitionFeePayment payment);

    boolean isFullyPaid(TuitionFeePayment payment);
}
