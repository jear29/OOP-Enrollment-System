package org.example.model;

public class Instructor extends Person {
    private String course;

    public Instructor() {
    }

    public Instructor(String ID, String name, String course) {
        super(ID, name);
        this.course = course;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "instructorID='" + super.getID() + '\'' +
                ", instructorName='" + super.getName() + '\'' +
                ", course='" + course + '\'' +
                '}';
    }

    @Override
    public void mainTask() {
        System.out.println("I teach.");
    }
}
