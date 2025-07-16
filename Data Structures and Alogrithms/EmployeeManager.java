// EmployeeManager.java - Managing employees using an array

import java.util.Scanner;

class Employee {
    int employeeId;
    String name;
    String position;
    double salary;

    public Employee(int id, String name, String position, double salary) {
        this.employeeId = id;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public String toString() {
        return employeeId + " | " + name + " | " + position + " | ₹" + salary;
    }
}

public class EmployeeManager {
    static Employee[] employees = new Employee[100];  // Max 100 employees
    static int count = 0;

    public static void addEmployee(Employee emp) {
        if (count < employees.length) {
            employees[count++] = emp;
            System.out.println("Employee added: " + emp.name);
        } else {
            System.out.println("Employee list is full.");
        }
    }

    public static void showAllEmployees() {
        System.out.println("\n--- Employee List ---");
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i]);
        }
    }

    public static void searchEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                System.out.println("Found: " + employees[i]);
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    public static void deleteEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                // Shift all remaining employees left
                for (int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--count] = null;
                System.out.println("Employee deleted.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        addEmployee(new Employee(1, "Nandani", "Manager", 50000));
        addEmployee(new Employee(2, "Daksh", "Developer", 40000));
        addEmployee(new Employee(3, "Abhinav", "Analyst", 35000));
        addEmployee(new Employee(4, "Shikha", "HR", 30000));

        showAllEmployees();

        System.out.println("\nSearching for employee with ID 2:");
        searchEmployee(2);

        System.out.println("\nDeleting employee with ID 3:");
        deleteEmployee(3);

        showAllEmployees();
    }
}

