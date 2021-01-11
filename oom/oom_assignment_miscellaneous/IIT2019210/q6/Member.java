package q6;

public class Member {
    String name, phoneNumber, address;
    int age;
    float salary;
    public Member(String Name, String number, String Address, int Age, float Salary){
        this.name = Name;
        this.salary = Salary;
        this.address = Address;
        this.age = Age;
        this.phoneNumber = number;
    }

    public void printSalary(){
        System.out.println("Salary is: " + this.salary);
    }

    public void printDetails(String x){
        System.out.println("Name : "+ this.name);
        System.out.println("Age : "+ this.age);
        System.out.println("Phone Number : "+ this.phoneNumber);
        System.out.println("Address : "+ this.address);
        printSalary();
    }
}
