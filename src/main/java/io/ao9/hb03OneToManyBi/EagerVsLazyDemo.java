package io.ao9.hb03OneToManyBi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import io.ao9.hb03OneToManyBi.entity.Course;
import io.ao9.hb03OneToManyBi.entity.Instructor;
import io.ao9.hb03OneToManyBi.entity.InstructorDetail;

public class EagerVsLazyDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                                    .configure("hb-03-one-to-many-bi.cfg.xml")
                                    .addAnnotatedClass(Instructor.class)
                                    .addAnnotatedClass(InstructorDetail.class)
                                    .addAnnotatedClass(Course.class)
                                    .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            System.out.println("begin transaction");
            session.beginTransaction();

            System.out.println("get instructor");
            int id = 2;
            Instructor tempInstructor = session.get(Instructor.class, id);

            System.out.println("Print instructor-------------------");           
            System.out.println(tempInstructor);
            System.out.println("Print courses-------------------");
            System.out.println(tempInstructor.getCourses());
            
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