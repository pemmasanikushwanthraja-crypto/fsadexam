package com.klef.fsad.exam;

import jakarta.persistence.*;
import java.util.Date;

public class ClientDemo
{
    public static void main(String[] args)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("fsadexam");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        Course c = new Course();
        c.setName("Java Programming");
        c.setDescription("Core Java Course");
        c.setDate(new Date());
        c.setStatus("Active");

        em.persist(c);

        tx.commit();

        System.out.println("Record Inserted Successfully");

        Course course = em.find(Course.class, c.getId());

        System.out.println("Course ID: " + course.getId());
        System.out.println("Name: " + course.getName());

        em.close();
        emf.close();
    }
}
