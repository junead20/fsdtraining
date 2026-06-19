package com.example.employeepayroll;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmployeeDAO {

    private SessionFactory factory;

    public EmployeeDAO() {

        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
    }

    // Insert Employee
    public void insertEmployee(Employee employee) {

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        session.save(employee);

        tx.commit();
        session.close();

        System.out.println("Employee Inserted Successfully.");
    }

    // Get Employee By ID
    public Employee getEmployee(int id) {

        Session session = factory.openSession();

        Employee employee = session.get(Employee.class, id);

        session.close();

        return employee;
    }

    // Display All Employees
    public List<Employee> getAllEmployees() {

        Session session = factory.openSession();

        List<Employee> list = session.createQuery("from Employee", Employee.class).list();

        session.close();

        return list;
    }

    // Update Employee
    public void updateEmployee(Employee employee) {

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        session.update(employee);

        tx.commit();
        session.close();

        System.out.println("Employee Updated Successfully.");
    }

    // Delete Employee
    public void deleteEmployee(int id) {

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        Employee employee = session.get(Employee.class, id);

        if (employee != null) {
            session.delete(employee);
            System.out.println("Employee Deleted Successfully.");
        } else {
            System.out.println("Employee Not Found.");
        }

        tx.commit();
        session.close();
    }

    public void closeFactory() {
        factory.close();
    }
}