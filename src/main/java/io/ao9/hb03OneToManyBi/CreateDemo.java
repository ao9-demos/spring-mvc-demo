package io.ao9.hb03OneToManyBi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import io.ao9.hb03OneToManyBi.entity.Course;
import io.ao9.hb03OneToManyBi.entity.Instructor;
import io.ao9.hb03OneToManyBi.entity.InstructorDetail;

public class CreateDemo {
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

            System.out.println("create instructor");
            Instructor tempInstructor = new Instructor("John", "Smith", "js@123.com");

            System.out.println("create and set instructorDetail");            
            InstructorDetail tempInstructorDetail = new InstructorDetail("www.youtube.com", "hobby");
            tempInstructor.setInstructorDetail(tempInstructorDetail);

            System.out.println("create and add courses");
            Course tempCourese = new Course("math");
            tempInstructor.add(tempCourese);

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