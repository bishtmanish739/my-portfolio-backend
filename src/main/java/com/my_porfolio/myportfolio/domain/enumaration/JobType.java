package com.my_porfolio.myportfolio.domain.enumaration;

public enum JobType {
    FULL_TIME("Full Time"),
    INTERNSHIP("Internship");
    private final String upper;

    JobType(String s) {
        this.upper = s;
    }

    public String getUpper() {
        return upper;
    }

}
