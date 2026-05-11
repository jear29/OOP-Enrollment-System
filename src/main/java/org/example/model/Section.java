package org.example.model;

public class Section {
    private String sectionId;
    private String sectionName;
    private int maxCapacity;
    private Instructor assignedInstructor;
    private java.util.List<Student> enrolledStudents = new java.util.ArrayList<>();

    public Section() {}

    public Section(String sectionId, String sectionName, int maxCapacity) {
        this.sectionId = sectionId;
        this.sectionName = sectionName;
        this.maxCapacity = maxCapacity;
    }

    public String getSectionId() {
        return sectionId;
    }

    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public Instructor getAssignedInstructor() {
        return assignedInstructor;
    }

    public void setAssignedInstructor(Instructor assignedInstructor) {
        this.assignedInstructor = assignedInstructor;
    }

    public java.util.List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    @Override
    public String toString() {
        return "Section{" +
                "sectionId='" + sectionId + '\'' +
                ", sectionName='" + sectionName + '\'' +
                ", maxCapacity=" + maxCapacity +
                '}';
    }
}

