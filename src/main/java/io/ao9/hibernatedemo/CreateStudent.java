package io.ao9.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import io.ao9.hibernatedemo.entity.Student;

public class CreateStudent {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            System.out.println("Creating a new student");
            Student theStudent = new Student("John", "Smith", DateUtils.parseDate("31/12/1998"), "jsmith@123.com");

            System.out.println("begin transaction");
            session.beginTransaction();

            System.out.println("saving the student");
            session.save(theStudent);

            System.out.println("commiting...");
            session.getTransaction().commit();
            System.out.println("done");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            factory.close();
        }

    }

}