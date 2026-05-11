package org.example.service.impl;

import org.example.exception.SectionFullException;
import org.example.model.Department;
import org.example.model.Section;
import org.example.model.Student;
import org.example.service.IEnrollmentService;

public class EnrollmentServiceImpl implements IEnrollmentService {

    @Override
    public void enrollStudentInSection(Student student, Section section) throws SectionFullException {
        if (section.getEnrolledStudents().size() >= section.getMaxCapacity()) {
            throw new SectionFullException("Enrollment failed: " + section.getSectionName() + " is currently full.");
        }
        
        section.getEnrolledStudents().add(student);
        System.out.println("Successfully enrolled student " + student.getName() + " into section " + section.getSectionName());
    }


    @Override
    public void addSectionToDepartment(Section section, Department department) {
        department.addSection(section);
        System.out.println("Added section " + section.getSectionName() + " to department " + department.getDepartmentName());
    }

    @Override
    public void viewDepartmentHierarchy(Department department) {
        System.out.println("\n--- Institutional Hierarchy ---");
        System.out.println("Department: " + department.getDepartmentName() + " (" + department.getDepartmentId() + ")");
        
        if (department.getSections().isEmpty()) {
            System.out.println("  [No Sections Found]");
        } else {
            for (Section section : department.getSections()) {
                System.out.println("  └── Section: " + section.getSectionName() + " (Capacity: " + section.getEnrolledStudents().size() + "/" + section.getMaxCapacity() + ")");
                
                String instructor = (section.getAssignedInstructor() != null) 
                        ? section.getAssignedInstructor().getName() 
                        : "None Assigned";
                System.out.println("      ├── Instructor: " + instructor);
                
                if (section.getEnrolledStudents().isEmpty()) {
                    System.out.println("      └── Students: [None]");
                } else {
                    System.out.println("      └── Students:");
                    for (Student s : section.getEnrolledStudents()) {
                        System.out.println("          • " + s.getName() + " (" + s.getID() + ")");
                    }
                }
            }
        }
    }
}
