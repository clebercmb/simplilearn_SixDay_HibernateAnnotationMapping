package com.example;

import com.example.model.Student;
import com.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DemoOnly {
    public static void main(String[] args) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Student s1 = new Student();
            s1.setFirstName("Steve");
            s1.setLastName("Rogers");
            s1.setEmail("rogers@gmail.com");
            session.save(s1);

            transaction.commit();
        } catch (Exception ex) {
            if(transaction != null) {
                transaction.rollback();
            }
            System.out.println(ex.getMessage());
        }
    }
}
