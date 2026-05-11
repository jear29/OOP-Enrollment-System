package org.example.service;

import org.example.exception.SectionFullException;
import org.example.model.Section;
import org.example.model.Student;
import org.example.service.impl.EnrollmentServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EnrollmentServiceTest {

    @Test
    public void testEnrollStudent_SectionIsFull_ThrowsException() throws SectionFullException {
        // ARRANGE: Set up a section with a max capacity of 2
        Section testSection = new Section("SEC1", "BSIT-1A", 2);
        Student student1 = new Student("S01", "Alice", "IT");
        Student student2 = new Student("S02", "Bob", "IT");
        Student student3 = new Student("S03", "Charlie", "IT");

        IEnrollmentService enrollmentService = new EnrollmentServiceImpl();

        // Fill the section to capacity
        enrollmentService.enrollStudentInSection(student1, testSection);
        enrollmentService.enrollStudentInSection(student2, testSection);

        // ACT & ASSERT: Try to add a 3rd student and expect an exception
        assertThrows(SectionFullException.class, () -> {
            enrollmentService.enrollStudentInSection(student3, testSection);
        }, "Should throw SectionFullException when section is full");

        assertEquals(2, testSection.getEnrolledStudents().size(), "Section size should remain 2.");
    }
}
