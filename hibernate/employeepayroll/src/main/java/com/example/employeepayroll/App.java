package com.example.employeepayroll;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EmployeeDAO dao = new EmployeeDAO();

        int choice = 0;

        do {

            System.out.println("\n========== EMPLOYEE PAYROLL SYSTEM ==========");
            System.out.println("1. Add Employee");
            System.out.println("2. Display Employee by ID");
            System.out.println("3. Display All Employees");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.print("Please enter a valid choice: ");
                sc.next();
            }

            choice = sc.nextInt();

            switch (choice) {

            case 1:

                int id;

                while (true) {
                    System.out.print("Enter Employee ID: ");
                    if (sc.hasNextInt()) {
                        id = sc.nextInt();
                        sc.nextLine();
                        break;
                    } else {
                        System.out.println("Invalid ID. Enter numbers only.");
                        sc.next();
                    }
                }

                System.out.print("Enter Employee Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Department: ");
                String department = sc.nextLine();

                double salary;

                while (true) {
                    System.out.print("Enter Salary: ");
                    if (sc.hasNextDouble()) {
                        salary = sc.nextDouble();
                        sc.nextLine();
                        break;
                    } else {
                        System.out.println("Invalid Salary.");
                        sc.next();
                    }
                }

                System.out.print("Enter Joining Date (YYYY-MM-DD): ");
                String joiningDate = sc.nextLine();

                Employee emp = new Employee(id, name, department, salary, joiningDate);

                dao.insertEmployee(emp);

                break;

            case 2:

                System.out.print("Enter Employee ID: ");

                int searchId = sc.nextInt();

                Employee employee = dao.getEmployee(searchId);

                if (employee != null)
                    System.out.println(employee);
                else
                    System.out.println("Employee Not Found.");

                break;

            case 3:

                List<Employee> employees = dao.getAllEmployees();

                if (employees.isEmpty()) {
                    System.out.println("No Employees Found.");
                } else {

                    System.out.println("\nEmployee Details\n");

                    for (Employee e : employees) {
                        System.out.println(e);
                    }
                }

                break;

            case 4:

                System.out.print("Enter Employee ID to Update: ");

                int updateId = sc.nextInt();

                Employee updateEmp = dao.getEmployee(updateId);

                if (updateEmp != null) {

                    sc.nextLine();

                    System.out.print("Enter New Employee Name: ");
                    updateEmp.setEmployeeName(sc.nextLine());

                    System.out.print("Enter New Department: ");
                    updateEmp.setDepartment(sc.nextLine());

                    System.out.print("Enter New Salary: ");
                    updateEmp.setSalary(sc.nextDouble());
                    sc.nextLine();

                    System.out.print("Enter New Joining Date: ");
                    updateEmp.setJoiningDate(sc.nextLine());

                    dao.updateEmployee(updateEmp);

                } else {

                    System.out.println("Employee Not Found.");

                }

                break;

            case 5:

                System.out.print("Enter Employee ID to Delete: ");

                int deleteId = sc.nextInt();

                dao.deleteEmployee(deleteId);

                break;

            case 6:

                System.out.println("Thank You!");

                dao.closeFactory();

                break;

            default:

                System.out.println("Invalid Choice.");

            }

        } while (choice != 6);

        sc.close();

    }
}