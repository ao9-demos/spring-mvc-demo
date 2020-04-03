package io.ao9.hb02OneToOneBi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import io.ao9.hb02OneToOneBi.entity.Instructor;
import io.ao9.hb02OneToOneBi.entity.InstructorDetail;

public class CreateDemo {
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

            System.out.println("create instructor");
            Instructor tempInstructor = new Instructor("John", "Smith", "js@123.com");
            InstructorDetail tempInstructorDetail = new InstructorDetail("www.youtube.com", "hobby");
            tempInstructor.setInstructorDetail(tempInstructorDetail);

            System.out.println("save instructor");
            session.save(tempInstructor);

            System.out.println("create instructor");
            tempInstructor = new Instructor("Apple", "Tree", "at@123.com");
            tempInstructorDetail = new InstructorDetail("www.youtube.com", "hobby2");
            tempInstructor.setInstructorDetail(tempInstructorDetail);

            System.out.println("save instructor");
            session.save(tempInstructor);

            System.out.println("create instructor");
            tempInstructor = new Instructor("Cookie", "Box", "cb@123.com");
            tempInstructorDetail = new InstructorDetail("www.youtube.com", "hobby3");
            tempInstructor.setInstructorDetail(tempInstructorDetail);

            System.out.println("save instructor");
            session.save(tempInstructor);

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