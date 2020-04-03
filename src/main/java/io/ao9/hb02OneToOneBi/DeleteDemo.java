package io.ao9.hb02OneToOneBi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import io.ao9.hb02OneToOneBi.entity.Instructor;
import io.ao9.hb02OneToOneBi.entity.InstructorDetail;

public class DeleteDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                                    .configure("hb-02-one-to-one-bi.cfg.xml")
                                    .addAnnotatedClass(Instructor.class)
                                    .addAnnotatedClass(InstructorDetail.class)
                                    .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            System.out.println("begin transaction");
            session.beginTransaction();

            System.out.println("delete instructorDetail id=2");
            int id = 2;
            InstructorDetail theInstructorDetail = session.get(InstructorDetail.class, id);
            session.delete(theInstructorDetail);
            
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