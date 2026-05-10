package org.example.model;

public class Student extends Person {
    private String program;

    public Student() {
    }

    public Student(String ID, String name, String program) {
        super(ID, name);
        this.program = program;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }


    @Override
    public String toString() {
        return "Student{" +
                "studentID='" + super.getID() + '\'' +
                ", studentName='" + super.getName() + '\'' +
                ", program='" + program + '\'' +
                '}';
    }

    @Override
    public void mainTask() {
        System.out.println("I study.");
    }
}
