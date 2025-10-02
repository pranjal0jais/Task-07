import com.sun.source.tree.WhileLoopTree;

import java.sql.Connection;
import java.util.Scanner;

public class EmployeeManagementSystem {
    static Scanner sc = new Scanner(System.in);
    public void addEmployee(){
        sc.nextLine();
        System.out.println("Enter Employee Name");
        String name = sc.nextLine();
        System.out.println("Enter Employee Department");
        String department = sc.nextLine();
        System.out.println("Enter Employee Salary");
        Double salary = sc.nextDouble();

        Service service = new Service();
        service.addEmployee(name, department, salary);
    }

    public void getEmployeeById(){
        System.out.println("Enter Employee Id");
        int id = sc.nextInt();
        Service service = new Service();
        service.getEmployeeById(id);
    }

    public void getAllEmployees(){
        Service service = new Service();
        service.getAllEmployees();
    }

    public void updateEmployee(){
        System.out.println("Enter Employee Id");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Employee Name");
        String name = sc.nextLine();
        System.out.println("Enter Employee Department");
        String department = sc.nextLine();
        System.out.println("Enter Employee Salary");
        Double salary = sc.nextDouble();
        Service service = new Service();
        service.updateEmployee(id, name, department, salary);
    }

    public void deleteEmployee(){
        System.out.println("Enter Employee Id");
        int id = sc.nextInt();
        Service service = new Service();
        service.deleteEmployee(id);
    }


    public static void main(String[] args) {
        while(true){
            //menu
            System.out.println("""
                    1. Add Employee\s
                    2. Get Employee By Id\s
                    3. Get All Employees\s
                    4. Update Employee\s
                    5. Delete Employee\s
                    6. Exit""");
            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();

            switch(choice){
                case 1:
                    new EmployeeManagementSystem().addEmployee();
                    break;
                case 2:
                    new EmployeeManagementSystem().getEmployeeById();
                    break;
                case 3:
                    new EmployeeManagementSystem().getAllEmployees();
                    break;
                case 4:
                    new EmployeeManagementSystem().updateEmployee();
                    break;
                case 5:
                    new EmployeeManagementSystem().deleteEmployee();
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
}
