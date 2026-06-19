package com.example.librarymanagement;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class BookDAO {

    private SessionFactory factory;

    public BookDAO() {

        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Book.class)
                .buildSessionFactory();
    }

    // Insert Book
    public void insertBook(Book book) {

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        session.save(book);

        tx.commit();
        session.close();

        System.out.println("Book Added Successfully.");
    }

    // Display Book by ID
    public Book getBook(int id) {

        Session session = factory.openSession();

        Book book = session.get(Book.class, id);

        session.close();

        return book;
    }

    // Display All Books
    public List<Book> getAllBooks() {

        Session session = factory.openSession();

        List<Book> list = session.createQuery("from Book", Book.class).list();

        session.close();

        return list;
    }

    // Update Book
    public void updateBook(Book book) {

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        session.update(book);

        tx.commit();
        session.close();

        System.out.println("Book Updated Successfully.");
    }

    // Delete Book
    public void deleteBook(int id) {

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        Book book = session.get(Book.class, id);

        if (book != null) {
            session.delete(book);
            System.out.println("Book Deleted Successfully.");
        } else {
            System.out.println("Book Not Found.");
        }

        tx.commit();
        session.close();
    }

    public void closeFactory() {
        factory.close();
    }
}