package com.my_porfolio.myportfolio.domain;

import lombok.Data;

import java.util.List;

@Data
public class Skill {
    private List<String> technicalSkills;
    private List<String> softSkills;

}
