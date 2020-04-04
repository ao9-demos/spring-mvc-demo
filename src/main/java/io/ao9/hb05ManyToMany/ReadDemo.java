package io.ao9.hb05ManyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import io.ao9.hb05ManyToMany.entity.Course;
import io.ao9.hb05ManyToMany.entity.Instructor;
import io.ao9.hb05ManyToMany.entity.InstructorDetail;
import io.ao9.hb05ManyToMany.entity.Review;
import io.ao9.hb05ManyToMany.entity.Student;

public class ReadDemo {
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

            System.out.println("\nget course\n");
            int id = 10;
            Course tempCourse = session.get(Course.class, id);
            
            System.out.println(tempCourse);
            System.out.println(tempCourse.getStudents());

            System.out.println("\nget student\n");
            id = 10;
            Student tempStudent = session.get(Student.class, id);
            
            System.out.println(tempStudent);
            System.out.println(tempStudent.getCourses());
            

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