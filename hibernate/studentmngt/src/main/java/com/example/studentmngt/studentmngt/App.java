package com.example.studentmngt.studentmngt;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        int choice;

        do {

            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Insert Student");
            System.out.println("2. Display Student By ID");
            System.out.println("3. Display All Students");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

            case 1:

                System.out.print("Enter Student ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Student Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Email: ");
                String email = sc.nextLine();

                System.out.print("Enter Course: ");
                String course = sc.nextLine();

                System.out.print("Enter Age: ");
                int age = sc.nextInt();

                Student s = new Student(id, name, email, course, age);

                dao.insertStudent(s);

                break;

            case 2:

                System.out.print("Enter Student ID: ");
                int sid = sc.nextInt();

                Student student = dao.getStudent(sid);

                if (student != null)
                    System.out.println(student);
                else
                    System.out.println("Student Not Found");

                break;

            case 3:

                List<Student> list = dao.getAllStudents();

                if (list.isEmpty()) {
                    System.out.println("No Students Found");
                } else {

                    for (Student st : list) {
                        System.out.println(st);
                    }
                }

                break;

            case 4:

                System.out.print("Enter Student ID to Update: ");
                int uid = sc.nextInt();

                Student st = dao.getStudent(uid);

                if (st != null) {

                    sc.nextLine();

                    System.out.print("Enter New Name: ");
                    st.setStudentName(sc.nextLine());

                    System.out.print("Enter New Email: ");
                    st.setEmail(sc.nextLine());

                    System.out.print("Enter New Course: ");
                    st.setCourse(sc.nextLine());

                    System.out.print("Enter New Age: ");
                    st.setAge(sc.nextInt());

                    dao.updateStudent(st);

                } else {

                    System.out.println("Student Not Found");
                }

                break;

            case 5:

                System.out.print("Enter Student ID to Delete: ");
                int did = sc.nextInt();

                dao.deleteStudent(did);

                break;

            case 6:

                System.out.println("Thank You!");

                dao.closeFactory();

                break;

            default:

                System.out.println("Invalid Choice");

            }

        } while (choice != 6);

        sc.close();
    }
}