package org.example.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TuitionFeePaymentTest {
    private TuitionFeePayment tuitionFeePayment;

    @BeforeEach
    void setup() {
        tuitionFeePayment = new TuitionFeePayment();
    }

    @Test
    @DisplayName("Calculation of Tuition Fee")
    void shouldReturnCorrectCalculationOfTuitionFee() {
        assertEquals(3000, tuitionFeePayment.calculateTuitionFee(3, 0));
    }

    @Test
    void shouldReturnCorrectCalculationOfTuitionFeeWithTenPercentDiscount() {
        assertEquals(2700, tuitionFeePayment.calculateTuitionFee(3, 0.10));
    }

    @Test
    void shoudMakeAPayment() {
        tuitionFeePayment.calculateTuitionFee(3, 0.10); // 2700
        // Act

        tuitionFeePayment.makePayment(1000);
        // Assert

        assertEquals(1700, tuitionFeePayment.getRemainingBalance());
    }

    @Test
    void shouldCheckIfTheTuitionFeeIsNotFullyPaid() {
        tuitionFeePayment.calculateTuitionFee(3, 0.10); // 2700

        // Act
        tuitionFeePayment.makePayment(1000);

        // Assert
        assertFalse(tuitionFeePayment.isFullyPaid());
    }
}