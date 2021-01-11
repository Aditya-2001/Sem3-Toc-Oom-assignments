package q6;
import q6.Member;
public class Manager extends Member {
    String department;
    public Manager(String Name, String number, String Address, int Age, float Salary){
        super(Name, number, Address, Age, Salary);
    }

    void printDetails(){
        System.out.println("\nDetails of the Manager : ");
        super.printDetails("Manager");
    }
}
