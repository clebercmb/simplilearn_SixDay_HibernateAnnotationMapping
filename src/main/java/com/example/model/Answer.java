package com.example.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name="answers")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="answer")
    private String answer;

    @Column(name="postedBy")
    private String postedBy;

    public Answer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(String postedBy) {
        this.postedBy = postedBy;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", answer='" + answer + '\'' +
                ", postedBy='" + postedBy + '\'' +
                '}';
    }
}
