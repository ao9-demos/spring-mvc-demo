package io.ao9.hb01OneToOneUni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import io.ao9.hb01OneToOneUni.entity.Instructor;
import io.ao9.hb01OneToOneUni.entity.InstructorDetail;

public class DeleteDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                                    .configure("hb-01-one-to-one-uni.cfg.xml")
                                    .addAnnotatedClass(Instructor.class)
                                    .addAnnotatedClass(InstructorDetail.class)
                                    .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            System.out.println("begin transaction");
            session.beginTransaction();

            System.out.println("delete instructor id=2");
            int id = 2;
            Instructor theInstructor = session.get(Instructor.class, id);
            session.delete(theInstructor);
            
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