package com.my_porfolio.myportfolio.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Skill implements Serializable {
    private List<String> technicalSkills;
    private List<String> softSkills;

}
