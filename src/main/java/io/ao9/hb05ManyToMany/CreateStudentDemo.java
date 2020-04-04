package io.ao9.hb05ManyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import io.ao9.hb05ManyToMany.entity.Course;
import io.ao9.hb05ManyToMany.entity.Instructor;
import io.ao9.hb05ManyToMany.entity.InstructorDetail;
import io.ao9.hb05ManyToMany.entity.Review;
import io.ao9.hb05ManyToMany.entity.Student;

public class CreateStudentDemo {
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

            System.out.println("create students");
            Student tempStudent1 = new Student("jhon", "doe", "jd@123.com");
            Student tempStudent2 = new Student("ace", "arm", "aa@123.com");
            Student tempStudent3 = new Student("fancy", "card", "fc@123.com");

            System.out.println("get course and add student");
            int id = 10;
            Course tempCourese = session.get(Course.class, id);
            tempCourese.addStudent(tempStudent1);
            tempCourese.addStudent(tempStudent3);

            id = 11;
            tempCourese = session.get(Course.class, id);
            tempCourese.addStudent(tempStudent2);
            tempCourese.addStudent(tempStudent3);

            id = 12;
            tempCourese = session.get(Course.class, id);
            tempCourese.addStudent(tempStudent1);
            tempCourese.addStudent(tempStudent2);

            System.out.println("save students");
            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);

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