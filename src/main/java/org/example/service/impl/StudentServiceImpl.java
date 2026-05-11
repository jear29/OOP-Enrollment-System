package org.example.service.impl;

import org.example.exception.DuplicateIdException;
import org.example.model.Student;
import org.example.service.IStudentService;

import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements IStudentService {
    private List<Student> studentList = new ArrayList<>();

    @Override
    public void addStudent(Student student) throws DuplicateIdException {
        for (Student s : studentList) {
            if (s.getID().equals(student.getID())) {
                throw new DuplicateIdException("Student ID " + student.getID() + " already exists.");
            }
        }
        studentList.add(student);
    }


    @Override
    public List<Student> getAllStudents() {
        return studentList;
    }

    @Override
    public void updateStudent(Student student) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getID().equals(student.getID())) {
                studentList.set(i, student);
                break;
            }
        }
    }

    @Override
    public String removeStudent(Student student) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getID().equals(student.getID())) {
                studentList.remove(i);
                return "Successfully removed";
            }
        }
        return "Error";
    }
}
