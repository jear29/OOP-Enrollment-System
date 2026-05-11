package org.example.service.impl;

import org.example.model.Course;
import org.example.service.ICourseService;

import java.util.ArrayList;
import java.util.List;

public class CourseServiceImpl implements ICourseService {
    private List<Course> courseList = new ArrayList<>();

    @Override
    public void addCourse(Course course) {
        courseList.add(course);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseList;
    }

    @Override
    public void updateCourse(Course course) {
        for (int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i).getCourseID().equals(course.getCourseID())) {
                courseList.set(i, course);
                break;
            }
        }
    }

    @Override
    public String removeCourse(Course course) {
        for (int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i).getCourseID().equals(course.getCourseID())) {
                courseList.remove(i);
                return "Successfully removed";
            }
        }
        return "Error";
    }
}
