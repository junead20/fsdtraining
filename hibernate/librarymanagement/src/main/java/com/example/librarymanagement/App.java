package com.example.librarymanagement;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BookDAO dao = new BookDAO();

        int choice;

        do {

            System.out.println("\n========= LIBRARY BOOK MANAGEMENT SYSTEM =========");
            System.out.println("1. Add Book");
            System.out.println("2. Display Book By ID");
            System.out.println("3. Display All Books");
            System.out.println("4. Update Book");
            System.out.println("5. Delete Book");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

            case 1:

                System.out.print("Enter Book ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Title: ");
                String title = sc.nextLine();

                System.out.print("Enter Author: ");
                String author = sc.nextLine();

                System.out.print("Enter Category: ");
                String category = sc.nextLine();

                System.out.print("Enter Price: ");
                double price = sc.nextDouble();

                System.out.print("Enter Available Copies: ");
                int copies = sc.nextInt();

                Book b = new Book(id, title, author, category, price, copies);

                dao.insertBook(b);

                break;

            case 2:

                System.out.print("Enter Book ID: ");
                int bid = sc.nextInt();

                Book book = dao.getBook(bid);

                if (book != null)
                    System.out.println(book);
                else
                    System.out.println("Book Not Found");

                break;

            case 3:

                List<Book> list = dao.getAllBooks();

                if (list.isEmpty()) {
                    System.out.println("No Books Found");
                } else {

                    System.out.println("\n------ Book List ------");

                    for (Book bk : list) {
                        System.out.println(bk);
                        System.out.println("----------------------------");
                    }
                }

                break;

            case 4:

                System.out.print("Enter Book ID to Update: ");
                int uid = sc.nextInt();

                Book updateBook = dao.getBook(uid);

                if (updateBook != null) {

                    sc.nextLine();

                    System.out.print("Enter New Title: ");
                    updateBook.setTitle(sc.nextLine());

                    System.out.print("Enter New Author: ");
                    updateBook.setAuthor(sc.nextLine());

                    System.out.print("Enter New Category: ");
                    updateBook.setCategory(sc.nextLine());

                    System.out.print("Enter New Price: ");
                    updateBook.setPrice(sc.nextDouble());

                    System.out.print("Enter New Available Copies: ");
                    updateBook.setAvailableCopies(sc.nextInt());

                    dao.updateBook(updateBook);

                } else {

                    System.out.println("Book Not Found");

                }

                break;

            case 5:

                System.out.print("Enter Book ID to Delete: ");
                int did = sc.nextInt();

                dao.deleteBook(did);

                break;

            case 6:

                dao.closeFactory();
                System.out.println("Thank You!");
                break;

            default:

                System.out.println("Invalid Choice");

            }

        } while (choice != 6);

        sc.close();
    }
}