class Employee {

    private int employeeId;
    private String name;
    private String position;
    private double salary;

    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void displayEmployee() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Position: " + position);
        System.out.println("Salary: " + salary);
        System.out.println();
    }
}

class EmployeeManagement {

    private Employee[] employees;
    private int count;

    public EmployeeManagement(int size) {
        employees = new Employee[size];
        count = 0;
    }

    public void addEmployee(Employee employee) {

        if (count < employees.length) {
            employees[count] = employee;
            count++;
            System.out.println("Employee added successfully.");
        } else {
            System.out.println("Array is full.");
        }
    }

    public Employee searchEmployee(int employeeId) {

        for (int i = 0; i < count; i++) {

            if (employees[i].getEmployeeId() == employeeId) {
                return employees[i];
            }
        }

        return null;
    }

    public void traverseEmployees() {

        for (int i = 0; i < count; i++) {
            employees[i].displayEmployee();
        }
    }

    public void deleteEmployee(int employeeId) {

        int index = -1;

        for (int i = 0; i < count; i++) {

            if (employees[i].getEmployeeId() == employeeId) {
                index = i;
                break;
            }
        }

        if (index != -1) {

            for (int i = index; i < count - 1; i++) {
                employees[i] = employees[i + 1];
            }

            employees[count - 1] = null;
            count--;

            System.out.println("Employee deleted successfully.");
        } else {
            System.out.println("Employee not found.");
        }
    }
}

public class EmployeeMgmtSystem {

    public static void main(String[] args) {

        EmployeeManagement management = new EmployeeManagement(10);

        management.addEmployee(new Employee(101, "Arun", "Manager", 50000));
        management.addEmployee(new Employee(102, "Kavin", "Developer", 40000));
        management.addEmployee(new Employee(103, "Priya", "Tester", 35000));

        System.out.println("Employee Records:");
        management.traverseEmployees();

        System.out.println("Searching Employee 102:");
        Employee employee = management.searchEmployee(102);

        if (employee != null) {
            employee.displayEmployee();
        } else {
            System.out.println("Employee not found.");
        }

        management.deleteEmployee(103);

        System.out.println("Employee Records After Deletion:");
        management.traverseEmployees();
    }
}