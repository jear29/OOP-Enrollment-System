package org.example.service;

import org.example.model.Instructor;
import org.example.model.Section;

public interface IInstructorService {
    void addInstructor(Instructor instructor);
    void assignInstructorToSection(Instructor instructor, Section section);
    String getInstructorDetails(Instructor instructor);
}
