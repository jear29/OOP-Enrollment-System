package org.example.service;

import org.example.exception.DuplicateIdException;
import org.example.model.Instructor;
import org.example.service.impl.InstructorServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InstructorServiceTest {

    @Test
    public void testAddInstructor_DuplicateId_ThrowsException() throws DuplicateIdException {
        IInstructorService instructorService = new InstructorServiceImpl();
        Instructor i1 = new Instructor("I1", "Dr. Smith", "CS");
        Instructor i2 = new Instructor("I1", "Prof. Jones", "IT"); // Duplicate ID

        instructorService.addInstructor(i1);

        assertThrows(DuplicateIdException.class, () -> {
            instructorService.addInstructor(i2);
        }, "Should throw DuplicateIdException when adding an instructor with an existing ID.");
    }
}
