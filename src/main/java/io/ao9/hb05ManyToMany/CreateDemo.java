package io.ao9.hb05ManyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import io.ao9.hb05ManyToMany.entity.Course;
import io.ao9.hb05ManyToMany.entity.Instructor;
import io.ao9.hb05ManyToMany.entity.InstructorDetail;
import io.ao9.hb05ManyToMany.entity.Review;
import io.ao9.hb05ManyToMany.entity.Student;

public class CreateDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                                    .configure("hb-05-many-to-many.cfg.xml")
                                    .addAnnotatedClass(Instructor.class)
                                    .addAnnotatedClass(InstructorDetail.class)
                                    .addAnnotatedClass(Course.class)
                                    .addAnnotatedClass(Review.class)
                                    .addAnnotatedClass(Student.class)
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