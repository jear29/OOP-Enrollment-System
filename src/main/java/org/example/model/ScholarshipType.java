package org.example.model;

public enum ScholarshipType {
    NONE(0.0),
    ACADEMIC(1.0),
    PARTIAL(0.5),
    ATHLETIC(0.25);

    private final double discountRate;

    ScholarshipType(double discountRate) {
        this.discountRate = discountRate;
    }

    public double getDiscountRate() {
        return discountRate;
    }
}
