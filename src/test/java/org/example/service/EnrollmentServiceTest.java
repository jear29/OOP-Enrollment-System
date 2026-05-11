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
        Section testSection = new Section("SEC1", "BSIT-1A", 2);
        Student student1 = new Student("S01", "Alice", "IT");
        Student student2 = new Student("S02", "Bob", "IT");
        Student student3 = new Student("S03", "Charlie", "IT");

        IEnrollmentService enrollmentService = new EnrollmentServiceImpl();

        enrollmentService.enrollStudentInSection(student1, testSection);
        enrollmentService.enrollStudentInSection(student2, testSection);

        assertThrows(SectionFullException.class, () -> {
            enrollmentService.enrollStudentInSection(student3, testSection);
        }, "Should throw SectionFullException when section is full");

        assertEquals(2, testSection.getEnrolledStudents().size(), "Section size should remain 2.");
    }
}
