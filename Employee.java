import java.util.*;

class Employee {
    int id;
    String name;
    double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee [ID=" + id + ", Name=" + name + ", Salary=" + salary + "]";
    }
}

public class EmployeeManagement {
    static Scanner sc = new Scanner(System.in);
    static Map<Integer, Employee> employees = new HashMap<>();

    public static void addEmployee() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();

        employees.put(id, new Employee(id, name, salary));
        System.out.println("✅ Employee added successfully!\n");
    }

    public static void viewEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.\n");
            return;
        }
        for (Employee e : employees.values()) {
            System.out.println(e);
        }
        System.out.println();
    }

    public static void updateSalary() {
        System.out.print("Enter Employee ID to update: ");
        int id = sc.nextInt();
        if (employees.containsKey(id)) {
            System.out.print("Enter new Salary: ");
            double salary = sc.nextDouble();
            employees.get(id).salary = salary;
            System.out.println("✅ Salary updated!\n");
        } else {
            System.out.println("❌ Employee not found!\n");
        }
    }

    public static void deleteEmployee() {
        System.out.print("Enter Employee ID to delete: ");
        int id = sc.nextInt();
        if (employees.remove(id) != null) {
            System.out.println("✅ Employee deleted!\n");
        } else {
            System.out.println("❌ Employee not found!\n");
        }
    }

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("=== Employee Management System ===");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Salary");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: addEmployee(); break;
                case 2: viewEmployees(); break;
                case 3: updateSalary(); break;
                case 4: deleteEmployee(); break;
                case 5: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice!\n");
            }
        } while (choice != 5);
    }
}
