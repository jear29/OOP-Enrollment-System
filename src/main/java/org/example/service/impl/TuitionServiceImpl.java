package org.example.service.impl;

import org.example.exception.InvalidPaymentAmountException;
import org.example.model.TuitionFeePayment;
import org.example.service.ITuitionService;

public class TuitionServiceImpl implements ITuitionService {
    private final double PRICE_PER_UNIT = 1000.00;

    @Override
    public double calculateFee(TuitionFeePayment payment, int units, double discountRate) {
        double totalTuition = units * PRICE_PER_UNIT;
        if (discountRate != 0) {
            totalTuition = totalTuition - (totalTuition * discountRate);
        }
        payment.setTotalTuition(totalTuition);
        // Set the initial balance to the calculated total
        payment.setBalance(totalTuition);
        return totalTuition;
    }

    @Override
    public double calculateFee(TuitionFeePayment payment, int units, org.example.model.ScholarshipType scholarshipType) {
        return calculateFee(payment, units, scholarshipType.getDiscountRate());
    }

    @Override
    public void makePayment(TuitionFeePayment payment, double amount) throws InvalidPaymentAmountException {
        if (amount <= 0) {
            throw new InvalidPaymentAmountException("Payment failed: Amount must be greater than zero.");
        }
        double currentBalance = payment.getBalance();
        payment.setBalance(currentBalance - amount);
    }


    @Override
    public double getRemainingBalance(TuitionFeePayment payment) {
        return payment.getBalance();
    }

    @Override
    public boolean isFullyPaid(TuitionFeePayment payment) {
        return payment.getBalance() <= 0;
    }
}
