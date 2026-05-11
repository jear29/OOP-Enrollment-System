package org.example.service;

import org.example.exception.DuplicateIdException;
import org.example.model.Student;
import org.example.service.impl.StudentServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StudentServiceTest {

    @Test
    public void testAddStudent_DuplicateId_ThrowsException() throws DuplicateIdException {
        IStudentService studentService = new StudentServiceImpl();
        Student student1 = new Student("S1", "John", "IT");
        Student student2 = new Student("S1", "Jane", "CS");

        studentService.addStudent(student1);

        assertThrows(DuplicateIdException.class, () -> {
            studentService.addStudent(student2);
        }, "Should throw DuplicateIdException when adding a student with an existing ID.");
    }

    @Test
    public void testAddStudent_Successful() throws DuplicateIdException {
        IStudentService studentService = new StudentServiceImpl();
        Student student = new Student("S1", "John", "IT");

        studentService.addStudent(student);

        assertEquals(1, studentService.getAllStudents().size());
        assertEquals("John", studentService.getAllStudents().get(0).getName());
    }
}
