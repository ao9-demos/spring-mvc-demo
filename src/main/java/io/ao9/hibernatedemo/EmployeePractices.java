package io.ao9.hibernatedemo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import io.ao9.hibernatedemo.entity.Employee;

public class EmployeePractices {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernateEmployee.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            System.out.println("begin transaction");
            session.beginTransaction();

            System.out.println("create employees");
            Employee employee1 = new Employee("a", "11", "com1");
            Employee employee2 = new Employee("b", "22", "com2");
            Employee employee3 = new Employee("c", "33", "com3");

            System.out.println("save employees");
            session.save(employee1);
            session.save(employee2);
            session.save(employee3);

            System.out.println("commiting...");
            session.getTransaction().commit();
            System.out.println("done");

            session = factory.getCurrentSession();
            System.out.println("begin transaction");
            session.beginTransaction();

            System.out.println("retrieve employee id=2");
            int id = 2;
            Employee employee = session.get(Employee.class, id);
            System.out.println(employee.toString());            

            System.out.println("commiting...");
            session.getTransaction().commit();
            System.out.println("done");

            session = factory.getCurrentSession();
            System.out.println("begin transaction");
            session.beginTransaction();

            System.out.println("query employees company=com2");
            List<Employee> employees = session.createQuery("from Employee where company='com3'").list();
            for(Employee employeeEle : employees) {
                System.out.println(employeeEle.toString());                
            }

            System.out.println("commiting...");
            session.getTransaction().commit();
            System.out.println("done");

            session = factory.getCurrentSession();
            System.out.println("begin transaction");
            session.beginTransaction();

            System.out.println("retrieve employee id=2");
            id = 6;
            employee = session.get(Employee.class, id);
            try {
                session.delete(employee); 
            } catch (Exception e) {
                System.out.println("no such employee id = " + id);               
            }           

            System.out.println("commiting...");
            session.getTransaction().commit();
            System.out.println("done");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}