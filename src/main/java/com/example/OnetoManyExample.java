package com.example;

import com.example.model.Answer;
import com.example.model.Instructor;
import com.example.model.InstructorDetail;
import com.example.model.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;

public class OnetoManyExample {

    public static void main(String[] args) {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();
        Transaction tran = session.beginTransaction();

        Answer ans1 = new Answer();
        ans1.setAnswer("Asnwer 1");
        ans1.setPostedBy("Tom");

        Answer ans2 = new Answer();
        ans2.setAnswer("Asnwer 2");
        ans2.setPostedBy("Jerry");

        ArrayList<Answer> ansList = new ArrayList<>();
        ansList.add(ans1);
        ansList.add(ans2);

        Question question = new Question();

        question.setQuestion("What is hibernate?");
        question.setAnswers(ansList);

        session.save(question);

        tran.commit();
        System.out.println(">>>Question saved");

        factory.close();
        session.close();

    }
}
