package com.example.model;

import javax.persistence.*;

@Entity
@Table (name="instructor_detail")
public class InstructorDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String experience;
    private String technology;

    public InstructorDetail() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    @Override
    public String toString() {
        return "InstructorDetail{" +
                "id=" + id +
                ", experience='" + experience + '\'' +
                ", technology='" + technology + '\'' +
                '}';
    }
}
