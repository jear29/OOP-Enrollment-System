package org.example.service;

import org.example.model.Department;
import org.example.model.Section;
import org.example.service.impl.EnrollmentServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DepartmentServiceTest {

    @Test
    public void testAddSectionToDepartment_Successful() {
        IEnrollmentService enrollmentService = new EnrollmentServiceImpl();
        Department dept = new Department("D1", "College of Engineering");
        Section sec = new Section("S1", "BSCE-1A", 40);

        enrollmentService.addSectionToDepartment(sec, dept);

        assertEquals(1, dept.getSections().size(), "Department should have 1 section.");
        assertEquals("BSCE-1A", dept.getSections().get(0).getSectionName(), "Section name should match.");
    }
}
