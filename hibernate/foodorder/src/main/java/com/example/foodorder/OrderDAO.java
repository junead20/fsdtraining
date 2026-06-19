package com.example.foodorder;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OrderDAO {

    private SessionFactory factory;

    public OrderDAO() {

        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Order.class)
                .buildSessionFactory();
    }

    // Insert Order
    public void insertOrder(Order order) {

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        session.save(order);

        tx.commit();
        session.close();

        System.out.println("Order Placed Successfully.");
    }

    // Display Order by ID
    public Order getOrder(int id) {

        Session session = factory.openSession();

        Order order = session.get(Order.class, id);

        session.close();

        return order;
    }

    // Display All Orders
    public List<Order> getAllOrders() {

        Session session = factory.openSession();

        List<Order> list = session.createQuery("from Order", Order.class).list();

        session.close();

        return list;
    }

    // Update Order
    public void updateOrder(Order order) {

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        session.update(order);

        tx.commit();
        session.close();

        System.out.println("Order Updated Successfully.");
    }

    // Delete Order
    public void deleteOrder(int id) {

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        Order order = session.get(Order.class, id);

        if (order != null) {
            session.delete(order);
            System.out.println("Order Deleted Successfully.");
        } else {
            System.out.println("Order Not Found.");
        }

        tx.commit();
        session.close();
    }

    public void closeFactory() {
        factory.close();
    }
}