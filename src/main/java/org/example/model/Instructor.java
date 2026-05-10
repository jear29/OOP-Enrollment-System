package org.example.model;

public class Instructor extends Person {
    private String course;

    public Instructor() {
    }

    public Instructor(String ID, String name, String course) {
        super(ID, name);
        this.course = course;
    }

    public String getProgram() {
        return course;
    }

    public void setProgram(String program) {
        this.course = course;
    }

    public void display() {
        System.out.printf("\nInstructor ID: %s\n", super.getID());
        System.out.printf("Instructor Name: %s\n", super.getName());
        System.out.printf("Program: %s\n", getProgram());
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "instructorID='" + super.getID() + '\'' +
                ", instructorName='" + super.getName() + '\'' +
                ", program='" + course + '\'' +
                '}';
    }

    @Override
    public void mainTask() {
        System.out.println("I teach.");
    }
}
