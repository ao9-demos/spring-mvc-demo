package io.ao9.hibernatedemo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import io.ao9.hibernatedemo.entity.Student;

public class UpdateStudentDemo {
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
            int studentID = 2;
            Student theStudent = session.get(Student.class, studentID);
            System.out.println(theStudent.toString());

            System.out.println("update the student");
            theStudent.setFirstName("j");
            theStudent.setLastName("d");            
            
            System.out.println("commiting...");
            session.getTransaction().commit();
            System.out.println("done");

            session = factory.getCurrentSession();
            System.out.println("begin transaction");
            session.beginTransaction();

            System.out.println("update emails");
            session.createQuery("update Student set email='ace@gmail.com'").executeUpdate();
            

            System.out.println("commiting...");
            session.getTransaction().commit();
            System.out.println("done");
            
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

    private static void print(List<Student> theStudents) {
        for(Student student : theStudents) {
            System.out.println(student.toString());
        }
        System.out.println("-----------");
        
    }
}