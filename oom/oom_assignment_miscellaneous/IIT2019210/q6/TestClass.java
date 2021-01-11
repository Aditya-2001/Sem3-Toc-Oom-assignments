package q6;
import q6.*;

import java.util.Scanner;

public class TestClass {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String name,address,number,department,specialization;
        int age;
        float salary;

        //For Employee object
        System.out.printf("Enter name of Employee: ");
        name = s.nextLine();
        System.out.printf("Enter Address of Employee: ");
        address = s.nextLine();
        System.out.printf("Enter phone number of Employee: ");
        number = s.nextLine();
        System.out.printf("Enter specialization of Employee: ");
        specialization = s.nextLine();
        System.out.printf("Enter age of Employee: ");
        age = s.nextInt();
        System.out.printf("Enter salary of Employee: ");
        salary = s.nextFloat();
        //Creating object of Employee type
        Employee emp = new Employee(name, number, address, age, salary);
        emp.specialization = specialization;
        //Employee created with given details

        //For manager object
        System.out.printf("Enter name of Manager: ");
        name = s.nextLine();        //To ignore the next line error in java scanner
        name = s.nextLine();
        System.out.printf("Enter Address of Manager: ");
        address = s.nextLine();
        System.out.printf("Enter phone number of Manager: ");
        number = s.nextLine();
        System.out.printf("Enter department of Manager: ");
        department = s.nextLine();
        System.out.printf("Enter age of Manager: ");
        age = s.nextInt();
        System.out.printf("Enter salary of Manager: ");
        salary = s.nextFloat();
        //Creating object of Manager type
        Manager man = new Manager(name, number, address, age, salary);
        man.department = department;
        //Manager created with given details

        //Now we can access them using objects emp and man

        //For employee
        emp.printDetails();

        //For manager
        man.printDetails();
    }
}