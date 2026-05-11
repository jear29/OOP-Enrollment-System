package org.example.service.impl;

import org.example.model.Student;
import org.example.service.IStudentService;

import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements IStudentService {
    private List<Student> studentList = new ArrayList<>();

    @Override
    public void addStudent(Student student) {
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
