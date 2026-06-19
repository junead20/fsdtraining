package com.example.foodorder;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        OrderDAO dao = new OrderDAO();

        int choice;

        do {

            System.out.println("\n========= ONLINE FOOD ORDERING SYSTEM =========");
            System.out.println("1. Place Order");
            System.out.println("2. Display Order By ID");
            System.out.println("3. Display All Orders");
            System.out.println("4. Update Order");
            System.out.println("5. Delete Order");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

            case 1:

                System.out.print("Enter Order ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Customer Name: ");
                String customer = sc.nextLine();

                System.out.print("Enter Food Item: ");
                String food = sc.nextLine();

                System.out.print("Enter Quantity: ");
                int quantity = sc.nextInt();

                System.out.print("Enter Total Amount: ");
                double amount = sc.nextDouble();
                sc.nextLine();

                System.out.print("Enter Order Date (YYYY-MM-DD): ");
                String date = sc.nextLine();

                System.out.print("Enter Order Status: ");
                String status = sc.nextLine();

                Order order = new Order(id, customer, food, quantity,
                        amount, date, status);

                dao.insertOrder(order);

                break;

            case 2:

                System.out.print("Enter Order ID: ");
                int oid = sc.nextInt();

                Order ord = dao.getOrder(oid);

                if (ord != null)
                    System.out.println(ord);
                else
                    System.out.println("Order Not Found.");

                break;

            case 3:

                List<Order> list = dao.getAllOrders();

                if (list.isEmpty()) {
                    System.out.println("No Orders Found.");
                } else {

                    System.out.println("\n------ Order List ------");

                    for (Order o : list) {
                        System.out.println(o);
                        System.out.println("--------------------------");
                    }
                }

                break;

            case 4:

                System.out.print("Enter Order ID to Update: ");
                int uid = sc.nextInt();

                Order updateOrder = dao.getOrder(uid);

                if (updateOrder != null) {

                    sc.nextLine();

                    System.out.print("Enter Customer Name: ");
                    updateOrder.setCustomerName(sc.nextLine());

                    System.out.print("Enter Food Item: ");
                    updateOrder.setFoodItem(sc.nextLine());

                    System.out.print("Enter Quantity: ");
                    updateOrder.setQuantity(sc.nextInt());

                    System.out.print("Enter Total Amount: ");
                    updateOrder.setTotalAmount(sc.nextDouble());
                    sc.nextLine();

                    System.out.print("Enter Order Date: ");
                    updateOrder.setOrderDate(sc.nextLine());

                    System.out.print("Enter Order Status: ");
                    updateOrder.setOrderStatus(sc.nextLine());

                    dao.updateOrder(updateOrder);

                } else {

                    System.out.println("Order Not Found.");

                }

                break;

            case 5:

                System.out.print("Enter Order ID to Delete: ");
                int did = sc.nextInt();

                dao.deleteOrder(did);

                break;

            case 6:

                dao.closeFactory();
                System.out.println("Thank You!");
                break;

            default:

                System.out.println("Invalid Choice.");

            }

        } while (choice != 6);

        sc.close();
    }
}