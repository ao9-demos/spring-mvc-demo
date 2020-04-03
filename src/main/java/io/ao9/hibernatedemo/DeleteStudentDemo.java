package io.ao9.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import io.ao9.hibernatedemo.entity.Student;

public class DeleteStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                                .configure("hibernateStudent.cfg.xml")
                                .addAnnotatedClass(Student.class)
                                .buildSessionFactory();
    
        Session session = factory.getCurrentSession();

        try {
            System.out.println("begin transaction");
            session.beginTransaction();

            System.out.println("load the student");
            int studentID = 1;
            Student theStudent = session.get(Student.class, studentID);
            System.out.println(theStudent.toString());

            System.out.println("delete the student");
            session.delete(theStudent);           
            
            System.out.println("commiting...");
            session.getTransaction().commit();
            System.out.println("done");

            session = factory.getCurrentSession();
            System.out.println("begin transaction");
            session.beginTransaction();

            System.out.println("delete student id=3");
            session.createQuery("delete from Student where id='3'").executeUpdate();
            

            System.out.println("commiting...");
            session.getTransaction().commit();
            System.out.println("done");
            
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
}