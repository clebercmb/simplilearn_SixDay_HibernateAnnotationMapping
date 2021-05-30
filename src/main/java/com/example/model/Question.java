package com.example.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name="question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="question")
    private String question;

    @OneToMany(targetEntity = Answer.class, cascade = CascadeType.ALL)
    @JoinColumn(name="qid")
    @OrderColumn(name="type")
    private List<Answer> answers;

    public Question() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", answers=" + answers +
                '}';
    }





}
