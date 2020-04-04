package io.ao9.hb05ManyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import io.ao9.hb05ManyToMany.entity.Course;
import io.ao9.hb05ManyToMany.entity.Instructor;
import io.ao9.hb05ManyToMany.entity.InstructorDetail;
import io.ao9.hb05ManyToMany.entity.Review;
import io.ao9.hb05ManyToMany.entity.Student;

public class UpdateDemo {
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

            System.out.println("create courses and add reviews");
            Course tempCourese1 = new Course("js");
            tempCourese1.addReview(new Review("good course"));
            tempCourese1.addReview(new Review("alright"));
            tempCourese1.addReview(new Review("it's OK"));
            Course tempCourese2 = new Course("fun");
            tempCourese2.addReview(new Review("good course"));
            tempCourese2.addReview(new Review("alright"));
            tempCourese2.addReview(new Review("it's OK"));

            System.out.println("\nget student\n");
            int id = 10;
            Student tempStudent = session.get(Student.class, id);
            
            System.out.println("\nadd courses to student\n");
            tempStudent.add(tempCourese1);
            tempStudent.add(tempCourese2);            

            System.out.println("\nsave courses\n");
            session.save(tempCourese1);            
            session.save(tempCourese2);

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