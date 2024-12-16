package com.my_porfolio.myportfolio.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "profile")
@Data
public class Profile {
    @Id
    private String id;
    private String name;
    private int age;

   private String location;
   private Contact contact;
   private Skill skills;
   private List<WorkExperience> workExperiences;
private String profileSummery;
private String profileHeadline;


}