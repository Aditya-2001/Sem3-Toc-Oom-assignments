package q6;
import q6.Member;
public class Employee extends Member {
    String specialization;
    public Employee(String Name, String number, String Address, int Age, float Salary){
        super(Name, number, Address, Age, Salary);
    }

    void printDetails(){
        System.out.println("\nDetails of the Employee : ");
        super.printDetails("Employee");
    }
}
