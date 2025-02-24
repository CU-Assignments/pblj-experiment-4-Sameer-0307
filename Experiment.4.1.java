package College;

import java.util.*;

class Employee {
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Salary: " + salary;
    }
}

public class EmployeeManagement {
    static List<Employee> employees = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Add  2. Update  3. Remove  4. Search  5. Display  6. Exit");
            System.out.print("Choose an option: ");

            int choice;
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
            } else {
                System.out.println("Invalid choice! Enter a number.");
                scanner.nextLine();
                continue;
            }

            switch (choice) {
                case 1 -> addEmployee();
                case 2 -> updateEmployee();
                case 3 -> removeEmployee();
                case 4 -> searchEmployee();
                case 5 -> displayEmployees();
                case 6 -> {
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    static void addEmployee() {
        System.out.print("Enter ID: ");
        int id = scanner.hasNextInt() ? scanner.nextInt() : -1;
        scanner.nextLine();

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Salary: ");
        double salary = scanner.hasNextDouble() ? scanner.nextDouble() : -1;
        scanner.nextLine();

        if (id < 0 || salary < 0) {
            System.out.println("Invalid ID or Salary. Try again.");
            return;
        }

        employees.add(new Employee(id, name, salary));
        System.out.println("Employee added successfully!");
    }

    static void updateEmployee() {
        System.out.print("Enter Employee ID to update: ");
        int id = scanner.hasNextInt() ? scanner.nextInt() : -1;
        scanner.nextLine();

        for (Employee emp : employees) {
            if (emp.id == id) {
                System.out.print("Enter new Name: ");
                emp.name = scanner.nextLine();

                System.out.print("Enter new Salary: ");
                double salary = scanner.hasNextDouble() ? scanner.nextDouble() : emp.salary;
                scanner.nextLine();

                if (salary < 0) {
                    System.out.println("Invalid salary. Update failed.");
                    return;
                }

                emp.salary = salary;
                System.out.println("Employee updated successfully!");
                return;
            }
        }
        System.out.println("Employee not found!");
    }

    static void removeEmployee() {
        System.out.print("Enter Employee ID to remove: ");
        int id = scanner.hasNextInt() ? scanner.nextInt() : -1;
        scanner.nextLine();

        boolean removed = employees.removeIf(emp -> emp.id == id);

        if (removed) {
            System.out.println("Employee removed successfully!");
        } else {
            System.out.println("Employee not found!");
        }
    }

    static void searchEmployee() {
        System.out.print("Enter Employee ID to search: ");
        int id = scanner.hasNextInt() ? scanner.nextInt() : -1;
        scanner.nextLine();

        employees.stream()
                .filter(emp -> emp.id == id)
                .findFirst()
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("Employee not found!")
                );
    }

    static void displayEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees to display.");
        } else {
            employees.forEach(System.out::println);
        }
    }
}
