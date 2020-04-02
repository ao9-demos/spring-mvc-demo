package io.ao9.hibernatedemo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import io.ao9.hibernatedemo.entity.Student;

public class QueryStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                                    .configure("hibernateStudent.cfg.xml")
                                    .addAnnotatedClass(Student.class)
                                    .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            System.out.println("begin transaction");
            session.beginTransaction();

            System.out.println("load the students");
            List<Student> theStudents = session
                                        .createQuery("from Student")
                                        .getResultList();
            print(theStudents);

            theStudents = session
                        .createQuery("from Student s where s.lastName='Tree'")
                        .list();
            print(theStudents);
            
            theStudents = session
                        .createQuery("from Student s where"
                                    + " s.lastName='Tree'"
                                    + " or s.firstName='Waffle'")
                        .list();
            print(theStudents);

            theStudents = session
                        .createQuery("from Student s where"
                                    + " s.email like 'dt@%'")
                        .list();
            print(theStudents);

            System.out.println("commiting...");
            session.getTransaction().commit();
            System.out.println("done");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

    private static void print(List<Student> theStudents) {
        for(Student student : theStudents) {
            System.out.println(student.toString());
        }
        System.out.println("-----------");
        
    }
}