package org.example.service;

import org.example.exception.DuplicateIdException;
import org.example.model.Instructor;
import org.example.model.Section;

import java.util.List;

public interface IInstructorService {
    void addInstructor(Instructor instructor) throws DuplicateIdException;
    void assignInstructorToSection(Instructor instructor, Section section);

    String getInstructorDetails(Instructor instructor);
    void updateInstructor(Instructor instructor);
    String removeInstructor(Instructor instructor);
    List<Instructor> getAllInstructors();
}
