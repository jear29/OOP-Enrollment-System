package org.example.service;

import org.example.model.Student;
import java.util.List;

public interface IStudentService {
    void addStudent(Student student);
    void updateStudent(Student student);
    String removeStudent(Student student);
    List<Student> getAllStudents();
}
