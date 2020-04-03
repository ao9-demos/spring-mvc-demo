package io.ao9.hb03OneToManyBi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import io.ao9.hb03OneToManyBi.entity.Instructor;
import io.ao9.hb03OneToManyBi.entity.InstructorDetail;

public class ReadDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                                    .configure("hb-03-one-to-many-bi.cfg.xml")
                                    .addAnnotatedClass(Instructor.class)
                                    .addAnnotatedClass(InstructorDetail.class)
                                    .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            System.out.println("begin transaction");
            session.beginTransaction();

            System.out.println("read instructor id=3");
            int id = 3;
            Instructor theInstructor = session.get(Instructor.class, id);
            System.out.println(theInstructor);
            System.out.println(theInstructor.getInstructorDetail());
            
            System.out.println("read instructorDetail id=3");
            id = 3;
            InstructorDetail theInstructorDetail = session.get(InstructorDetail.class, id);
            System.out.println(theInstructorDetail);
            System.out.println(theInstructorDetail.getInstructor());
            
            System.out.println("commiting...");
            session.getTransaction().commit();
            System.out.println("done");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
}