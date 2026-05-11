package org.example;

import org.example.model.Course;
import org.example.model.Department;
import org.example.model.Instructor;
import org.example.model.Student;
import org.example.model.Section;
import org.example.service.ICourseService;
import org.example.service.IEnrollmentService;
import org.example.service.IInstructorService;
import org.example.service.IStudentService;
import org.example.service.impl.CourseServiceImpl;
import org.example.service.impl.EnrollmentServiceImpl;
import org.example.service.impl.InstructorServiceImpl;
import org.example.service.impl.StudentServiceImpl;
import org.example.service.TuitionFeePayment;

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

        // INSTRUCTOR REGISTRATION
        IInstructorService instructorService = new InstructorServiceImpl();

        // create
        Instructor newInstructor = new Instructor("I-001", "Jane Smith", "Software Engineering");
        instructorService.addInstructor(newInstructor);

        // assign to section
        Section section = new Section("SE-101", 30);
        instructorService.assignInstructorToSection(newInstructor, section);

        // read
        System.out.println(instructorService.getInstructorDetails(newInstructor));

        // COURSE REGISTRATION
        ICourseService courseService = new CourseServiceImpl();

        // create
        courseService.addCourse(new Course("00001", "Integrative Programming", "Information Technology"));

        // read
        System.out.println(courseService.getAllCourses());

        // update
        courseService.updateCourse(new Course("00001", "Information Management", "Information Technology"));

        // delete
        courseService.removeCourse(new Course("00001", "Information Management", "Information Technology"));

        // ENROLLMENT / DEPARTMENT SERVICE
        IEnrollmentService enrollmentService = new EnrollmentServiceImpl();
        Student currentStudent = new Student("000123", "John Doe", "Information Technology");
        Section currentSection = new Section("IT-101", 40);

        // enroll
        enrollmentService.enrollStudentInSection(currentStudent, currentSection);

        // department hierarchy
        Department compSciDept = new Department("D-01", "Computer Science");
        enrollmentService.viewDepartmentHierarchy(compSciDept);
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