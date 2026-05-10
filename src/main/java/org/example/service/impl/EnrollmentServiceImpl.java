package org.example.service.impl;

import org.example.model.Department;
import org.example.model.Section;
import org.example.model.Student;
import org.example.service.IEnrollmentService;

public class EnrollmentServiceImpl implements IEnrollmentService {

    @Override
    public void enrollStudentInSection(Student student, Section section) {
        System.out.println("Enrolling student " + student.getName() + " into section " + section.getSectionId());
    }

    @Override
    public void viewDepartmentHierarchy(Department department) {
        System.out.println("Viewing hierarchy for department: " + department.getDepartmentName());
    }
}
