package com.example.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

    private static StandardServiceRegistry registery;
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {

        try {
            if(sessionFactory == null) {

                //Create registry
                registery =  new StandardServiceRegistryBuilder().configure().build();

                // Create Metadata
                MetadataSources sources = new MetadataSources(registery);
                Metadata metadata = sources.getMetadataBuilder().build();

                // Create SessionFactory
                sessionFactory = metadata.getSessionFactoryBuilder().build();

            }
        } catch (Exception ex) {
            if(registery != null) {
                StandardServiceRegistryBuilder.destroy(registery);
            }
            System.out.println(ex.getMessage());
        }
        return sessionFactory;
    }

    public static void shutDown() {
        if(registery != null) {
            StandardServiceRegistryBuilder.destroy(registery);
        }
    }
}
