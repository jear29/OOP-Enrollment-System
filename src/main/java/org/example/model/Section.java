package org.example.model;

public class Section {
    private String sectionId;
    private int maxCapacity;

    public Section() {}

    public Section(String sectionId, int maxCapacity) {
        this.sectionId = sectionId;
        this.maxCapacity = maxCapacity;
    }

    public String getSectionId() {
        return sectionId;
    }

    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }
}
