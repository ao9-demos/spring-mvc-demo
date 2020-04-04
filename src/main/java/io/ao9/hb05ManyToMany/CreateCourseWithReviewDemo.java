package io.ao9.hb05ManyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import io.ao9.hb05ManyToMany.entity.Course;
import io.ao9.hb05ManyToMany.entity.Instructor;
import io.ao9.hb05ManyToMany.entity.InstructorDetail;
import io.ao9.hb05ManyToMany.entity.Review;
import io.ao9.hb05ManyToMany.entity.Student;

public class CreateCourseWithReviewDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                                    .configure("hb-04-one-to-many-uni.cfg.xml")
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

            System.out.println("get instructor");
            int id = 1;
            Instructor tempInstructor = session.get(Instructor.class, id);

            System.out.println("create and add courses");
            Course tempCourese = new Course("python");
            tempCourese.add(new Review("good course"));
            tempCourese.add(new Review("alright"));
            tempCourese.add(new Review("it's OK"));
            tempInstructor.add(tempCourese);

            System.out.println("save course");
            session.save(tempCourese);

            System.out.println("create and add courses");
            tempCourese = new Course("java");
            tempCourese.add(new Review("good course"));
            tempCourese.add(new Review("alright"));
            tempCourese.add(new Review("it's OK"));
            tempInstructor.add(tempCourese);

            System.out.println("save course");
            session.save(tempCourese);

            System.out.println("create and add courses");
            tempCourese = new Course("game");
            tempCourese.add(new Review("good course"));
            tempCourese.add(new Review("alright"));
            tempCourese.add(new Review("it's OK"));
            tempInstructor.add(tempCourese);

            System.out.println("save course");
            session.save(tempCourese);

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