package org.example.model;

public class Section {
    private String sectionId;
    private String sectionName;
    private int maxCapacity;

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

    @Override
    public String toString() {
        return "Section{" +
                "sectionId='" + sectionId + '\'' +
                ", sectionName='" + sectionName + '\'' +
                ", maxCapacity=" + maxCapacity +
                '}';
    }
}

