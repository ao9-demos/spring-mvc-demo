package io.ao9.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import io.ao9.hibernatedemo.entity.Student;

public class PrimaryKeyDemo{
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                                    .configure("hibernateStudent.cfg.xml")
                                    .addAnnotatedClass(Student.class)
                                    .buildSessionFactory();
        
        Session session = factory.getCurrentSession();

        try {
            System.out.println("Creating 3 new student3");
            Student theStudent1 = new Student("Jim","Apple",DateUtils.parseDate("01/12/1998"), "ja@123.com");
            Student theStudent2 = new Student("Dug","Tree",DateUtils.parseDate("31/12/1988"), "dt@123.com");
            Student theStudent3 = new Student("Ace","Butter",DateUtils.parseDate("31/12/1990"), "ab@123.com");

            System.out.println("begin transaction");
            session.beginTransaction();

            System.out.println("saving the students");
            session.save(theStudent1);
            session.save(theStudent2);
            session.save(theStudent3);

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
