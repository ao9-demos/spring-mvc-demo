package io.ao9.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import io.ao9.hibernatedemo.entity.Student;

public class ReadStudent{
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                                    .configure("hibernate.cfg.xml")
                                    .addAnnotatedClass(Student.class)
                                    .buildSessionFactory();

        try {
            System.out.println("getting a session");
            Session session = factory.getCurrentSession();
            
            System.out.println("creating a new student");
            Student theStudent = new Student("Waffle","Dog","wd@123.com");

            System.out.println("beginning transaction");
            session.beginTransaction();

            System.out.println("saving the student");
            System.out.println(theStudent);
            session.save(theStudent);

            System.out.println("commiting...");
            session.getTransaction().commit();
            
            System.out.println("saved student id: " + theStudent.getId());
            
            System.out.println("getting a session");
            session = factory.getCurrentSession();
            
            System.out.println("beginning transaction");
            session.beginTransaction();
            
            System.out.println("getting the student by id "+theStudent.getId());
            Student gotStudent = session.get(Student.class, theStudent.getId());
            
            System.out.println("get complete:");
            System.out.println(gotStudent);
            
            System.out.println("commiting...");
            session.getTransaction().commit();
            
            System.out.println("are the two objects the same - " + (theStudent == gotStudent));
            
            System.out.println("done");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            factory.close();
        }

    }

}