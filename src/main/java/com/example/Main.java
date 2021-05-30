package com.example;

import com.example.model.Student;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        logger.setLevel(Level.DEBUG);
        System.out.println("Hi");
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();

        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();

        Session session = factory.openSession();
        Transaction tran = session.beginTransaction();

        Student s1 = new Student();
        s1.setFirstName("Tom");
        s1.setLastName("Jerry");
        s1.setEmail("jerry@gmail.com");

        Student s2 = new Student();
        s2.setFirstName("Steve");
        s2.setLastName("Rogers");
        s2.setEmail("rogers@gmail.com");

        session.save(s1);
        session.save(s2);

        tran.commit();

        System.out.println(">>>Students saved");
        logger.debug("Students saved");

        factory.close();
        session.close();


    }
}
