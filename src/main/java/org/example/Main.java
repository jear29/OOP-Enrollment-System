package org.example;

import org.example.model.Course;
import org.example.model.Instructor;
import org.example.model.Student;
import org.example.service.CourseRegistration;
import org.example.service.IStudentService;
import org.example.service.StudentServiceImpl;
import org.example.service.TuitionFeePayment;

import javax.swing.plaf.BorderUIResource;

public class Main {
    public static void main(String[] args) {

        // STUDENT REGISTRATION
        IStudentService studentService = new StudentServiceImpl();

        // create
        studentService.addStudent(new Student("000123", "John Doe", "Information Technology"));

        // read
        System.out.println(studentService.getAllStudents());

        // update
        studentService.updateStudent(new Student("000123", "John Doe", "Computer Science"));

        // delete
        studentService.removeStudent(new Student("000123", "John Doe", "Computer Science"));

        // COURSE REGISTRATION
        CourseRegistration courseRegistration = new CourseRegistration();

        // create
        courseRegistration.save(new Course("00001", "Integrative Programming", "Information Technology"));

        // read
        courseRegistration.displayAll();

        // update
        courseRegistration.updateCourse(new Course("00001", "Information Management", "Information Technology"));

        // delete
        courseRegistration.removeCourse(new Course("00001", "Information Management", "Information Technology"));
        TuitionFeePayment tuitionFeePayment = new TuitionFeePayment();

        System.out.println(tuitionFeePayment.calculateTuitionFee(3, .10));
        tuitionFeePayment.makePayment(2700);
        System.out.println(tuitionFeePayment.getRemainingBalance());
        System.out.println(tuitionFeePayment.isFullyPaid());

        Student student = new Student();
        student.mainTask();

        Instructor instructor = new Instructor();
        instructor.mainTask();
    }
}