package com.my_porfolio.myportfolio.domain;

import lombok.Data;

import java.util.List;

@Data
public class WorkExperience {
    private String companyName;
    private String location;
    private String designation;
    private String startDate;
    private String endDate;
    private boolean currentlyWorking;
    private String workDescription;
    private String companyLogoUrl;
    private String jobType;


}
