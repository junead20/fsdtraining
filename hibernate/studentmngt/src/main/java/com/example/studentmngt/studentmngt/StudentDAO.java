package com.example.studentmngt.studentmngt;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StudentDAO {

    private SessionFactory factory;

    public StudentDAO() {

        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
    }

    // Insert
    public void insertStudent(Student student) {

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        session.save(student);

        tx.commit();
        session.close();

        System.out.println("Student Inserted Successfully");
    }

    // Read by ID
    public Student getStudent(int id) {

        Session session = factory.openSession();

        Student student = session.get(Student.class, id);

        session.close();

        return student;
    }

    // Read All
    public List<Student> getAllStudents() {

        Session session = factory.openSession();

        List<Student> students =
                session.createQuery("from Student", Student.class).list();

        session.close();

        return students;
    }

    // Update
    public void updateStudent(Student student) {

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        session.update(student);

        tx.commit();
        session.close();

        System.out.println("Student Updated Successfully");
    }

    // Delete
    public void deleteStudent(int id) {

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        Student student = session.get(Student.class, id);

        if (student != null) {
            session.delete(student);
            System.out.println("Student Deleted Successfully");
        } else {
            System.out.println("Student Not Found");
        }

        tx.commit();
        session.close();
    }

    public void closeFactory() {
        factory.close();
    }
}