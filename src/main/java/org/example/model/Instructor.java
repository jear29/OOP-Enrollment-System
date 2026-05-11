package org.example.model;

public class Instructor extends Person {
    private String department;

    public Instructor() {
    }

    public Instructor(String ID, String name, String department) {
        super(ID, name);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "instructorID='" + super.getID() + '\'' +
                ", instructorName='" + super.getName() + '\'' +
                ", department='" + department + '\'' +
                '}';
    }

    @Override
    public void mainTask() {
        System.out.println("I teach.");
    }
}
