package org.example.service;

import org.example.exception.InvalidPaymentAmountException;
import org.example.model.ScholarshipType;
import org.example.model.TuitionFeePayment;
import org.example.service.impl.TuitionServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TuitionServiceTest {

    @Test
    public void testCalculateFee_AcademicScholarship_ReturnsZero() {
        // ARRANGE
        ITuitionService tuitionService = new TuitionServiceImpl();
        TuitionFeePayment payment = new TuitionFeePayment(0, 0);
        int units = 10;

        // ACT
        double fee = tuitionService.calculateFee(payment, units, ScholarshipType.ACADEMIC);

        // ASSERT
        assertEquals(0.0, fee, "Academic scholarship should result in 0 tuition fee.");
        assertEquals(0.0, payment.getBalance(), "Balance should be 0.");
    }

    @Test
    public void testCalculateFee_NoScholarship_ReturnsFullPrice() {
        // ARRANGE
        ITuitionService tuitionService = new TuitionServiceImpl();
        TuitionFeePayment payment = new TuitionFeePayment(0, 0);
        int units = 10; // 10 * 1000 = 10000

        // ACT
        double fee = tuitionService.calculateFee(payment, units, ScholarshipType.NONE);

        // ASSERT
        assertEquals(10000.0, fee);
    }

    @Test
    public void testMakePayment_NegativeAmount_ThrowsException() {
        // ARRANGE
        ITuitionService tuitionService = new TuitionServiceImpl();
        TuitionFeePayment payment = new TuitionFeePayment(10000, 10000);

        // ACT & ASSERT
        assertThrows(InvalidPaymentAmountException.class, () -> {
            tuitionService.makePayment(payment, -500);
        }, "Should throw InvalidPaymentAmountException for negative payment.");
    }
}
