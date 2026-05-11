package org.example.service.impl;

import org.example.model.Instructor;
import org.example.model.Section;
import org.example.service.IInstructorService;

import java.util.ArrayList;
import java.util.List;

public class InstructorServiceImpl implements IInstructorService {
    private List<Instructor> instructorList = new ArrayList<>();

    @Override
    public void addInstructor(Instructor instructor) {
        instructorList.add(instructor);
    }

    @Override
    public void assignInstructorToSection(Instructor instructor, Section section) {
        System.out.println("Assigned instructor " + instructor.getName() + " to section " + section.getSectionId());
    }

    @Override
    public String getInstructorDetails(Instructor instructor) {
        for (Instructor i : instructorList) {
            if (i.getID().equals(instructor.getID())) {
                return i.toString();
            }
        }
        return "Instructor not found.";
    }
}
