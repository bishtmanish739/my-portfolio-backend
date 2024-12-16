package com.my_porfolio.myportfolio.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Document(collection = "profiles")
public class Profile implements Serializable {
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Skill getSkills() {
        return skills;
    }

    public void setSkills(Skill skills) {
        this.skills = skills;
    }

    public List<WorkExperience> getWorkExperiences() {
        return workExperiences;
    }

    public void setWorkExperiences(List<WorkExperience> workExperiences) {
        this.workExperiences = workExperiences;
    }

    public String getProfileSummery() {
        return profileSummery;
    }

    public void setProfileSummery(String profileSummery) {
        this.profileSummery = profileSummery;
    }

    public String getProfileHeadline() {
        return profileHeadline;
    }

    public void setProfileHeadline(String profileHeadline) {
        this.profileHeadline = profileHeadline;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", location='" + location + '\'' +
                ", contact=" + contact +
                ", skills=" + skills +
                ", workExperiences=" + workExperiences +
                ", profileSummery='" + profileSummery + '\'' +
                ", profileHeadline='" + profileHeadline + '\'' +
                '}';
    }
}