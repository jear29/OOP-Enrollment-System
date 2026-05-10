package org.example.service;

import org.example.model.Course;
import java.util.List;

public interface ICourseService {
    void addCourse(Course course);
    void updateCourse(Course course);
    String removeCourse(Course course);
    List<Course> getAllCourses();
}
