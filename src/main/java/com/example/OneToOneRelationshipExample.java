package com.example;

import com.example.model.Instructor;
import com.example.model.InstructorDetail;
import com.example.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class OneToOneRelationshipExample {

    public static void main(String[] args) {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();
        Transaction tran = session.beginTransaction();

        InstructorDetail instructorDetail = new InstructorDetail();
        instructorDetail.setExperience("12 years");
        instructorDetail.setTechnology("Sfotware Development");

        Instructor instructor = new Instructor();
        instructor.setFirstName("Tom");
        instructor.setLastName("Jerry");
        instructor.setEmail("jerry@gmail.com");
        instructor.setInstructorDetail(instructorDetail);

        session.save(instructor);

        tran.commit();

        System.out.println(">>>Instructor saved");


        factory.close();
        session.close();
    }
}
