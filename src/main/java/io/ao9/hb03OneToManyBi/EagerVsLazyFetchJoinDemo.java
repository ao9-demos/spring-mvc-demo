package io.ao9.hb03OneToManyBi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import io.ao9.hb03OneToManyBi.entity.Course;
import io.ao9.hb03OneToManyBi.entity.Instructor;
import io.ao9.hb03OneToManyBi.entity.InstructorDetail;

public class EagerVsLazyFetchJoinDemo {
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
            int theId = 2;
            Query<Instructor> query = 
                            session.createQuery("select i from Instructor i "
                                                + "join fetch i.courses "
                                                + "where i.id=:theId",
                                                Instructor.class);
            query.setParameter("theId", theId);
            
            Instructor tempInstructor = query.uniqueResult();
            
            System.out.println("commiting...");
            session.getTransaction().commit();
            System.out.println("done");

            System.out.println("\nclose session\n");            
            session.close();

            System.out.println("Print instructor-------------------");           
            System.out.println(tempInstructor);
            
            System.out.println("Print courses-------------------");
            System.out.println(tempInstructor.getCourses());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
}