package com.example.productdemo;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        SessionFactory factory = Utility.getSessionFactory();

        while (true) {

            System.out.println("\n===== PRODUCT MENU =====");
            System.out.println("1. Insert");
            System.out.println("2. Find By Id");
            System.out.println("3. Find All");
            System.out.println("4. Update");
            System.out.println("5. Delete");
            System.out.println("6. Exit");

            System.out.print("Enter Choice : ");
            int choice = sc.nextInt();

            switch (choice) {

            case 1:

                Session session1 = factory.openSession();

                Product p = new Product();

                System.out.print("Enter Id : ");
                p.setId(sc.nextInt());

                sc.nextLine();

                System.out.print("Enter Name : ");
                p.setName(sc.nextLine());

                System.out.print("Enter Price : ");
                p.setPrice(sc.nextDouble());

                session1.beginTransaction();
                session1.persist(p);
                session1.getTransaction().commit();
                session1.close();

                System.out.println("Product Inserted Successfully");

                break;

            case 2:

                Session session2 = factory.openSession();

                System.out.print("Enter Id : ");
                int id = sc.nextInt();

                Product product = session2.get(Product.class, id);

                if (product != null) {

                    System.out.println("Id : " + product.getId());
                    System.out.println("Name : " + product.getName());
                    System.out.println("Price : " + product.getPrice());

                } else {

                    System.out.println("Product Not Found");

                }

                session2.close();

                break;

            case 3:

                Session session3 = factory.openSession();

                List<Product> list = session3.createQuery("from Product", Product.class).list();

                if (list.isEmpty()) {

                    System.out.println("No Records Found");

                } else {

                    for (Product pro : list) {

                        System.out.println("--------------------------------");

                        System.out.println("Id : " + pro.getId());

                        System.out.println("Name : " + pro.getName());

                        System.out.println("Price : " + pro.getPrice());

                    }

                }

                session3.close();

                break;

            case 4:

                Session session4 = factory.openSession();

                System.out.print("Enter Product Id : ");

                int uid = sc.nextInt();

                Product up = session4.get(Product.class, uid);

                if (up != null) {

                    sc.nextLine();

                    System.out.print("Enter New Name : ");

                    up.setName(sc.nextLine());

                    System.out.print("Enter New Price : ");

                    up.setPrice(sc.nextDouble());

                    session4.beginTransaction();

                    session4.merge(up);

                    session4.getTransaction().commit();

                    System.out.println("Updated Successfully");

                } else {

                    System.out.println("Product Not Found");

                }

                session4.close();

                break;

            case 5:

                Session session5 = factory.openSession();

                System.out.print("Enter Product Id : ");

                int did = sc.nextInt();

                Product del = session5.get(Product.class, did);

                if (del != null) {

                    session5.beginTransaction();

                    session5.remove(del);

                    session5.getTransaction().commit();

                    System.out.println("Deleted Successfully");

                } else {

                    System.out.println("Product Not Found");

                }

                session5.close();

                break;

            case 6:

                factory.close();

                sc.close();

                System.out.println("Thank You");

                System.exit(0);

            default:

                System.out.println("Invalid Choice");

            }

        }

    }

}