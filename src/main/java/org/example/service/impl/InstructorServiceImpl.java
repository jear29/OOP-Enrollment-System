package org.example.service.impl;

import org.example.exception.DuplicateIdException;
import org.example.model.Instructor;
import org.example.model.Section;
import org.example.service.IInstructorService;

import java.util.ArrayList;
import java.util.List;

public class InstructorServiceImpl implements IInstructorService {
    private List<Instructor> instructorList = new ArrayList<>();

    @Override
    public void addInstructor(Instructor instructor) throws DuplicateIdException {
        for (Instructor i : instructorList) {
            if (i.getID().equals(instructor.getID())) {
                throw new DuplicateIdException("Instructor ID " + instructor.getID() + " already exists.");
            }
        }
        instructorList.add(instructor);
    }


    @Override
    public void assignInstructorToSection(Instructor instructor, Section section) {
        section.setAssignedInstructor(instructor);
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

    @Override
    public void updateInstructor(Instructor instructor) {
        for (int i = 0; i < instructorList.size(); i++) {
            if (instructorList.get(i).getID().equals(instructor.getID())) {
                instructorList.set(i, instructor);
                break;
            }
        }
    }

    @Override
    public String removeInstructor(Instructor instructor) {
        for (int i = 0; i < instructorList.size(); i++) {
            if (instructorList.get(i).getID().equals(instructor.getID())) {
                instructorList.remove(i);
                return "Successfully removed";
            }
        }
        return "Error";
    }

    @Override
    public List<Instructor> getAllInstructors() {
        return instructorList;
    }
}
