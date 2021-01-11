package q7;
import q7.*;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        AssignmentList items = new AssignmentList();
        Scanner sc = new Scanner(System.in);
        String name, specialization, dataFile;
        int month, day, hour, minute, totalItems=0;
        boolean var=true;
        while(var){
            System.out.println("\nWhich type of assignment details do you want to give?");
            System.out.println("1. Lab Assignment");
            System.out.println("2. Project Assignment");
            System.out.println("0. Exit");
            System.out.printf("Enter your choice : ");
            int choice = sc.nextInt();
            switch (choice){
                case 1:
                case 2:     totalItems++;
                            System.out.print("Enter Name : ");
                            name = sc.next();
                            System.out.print("Enter month : ");
                            month = sc.nextInt();
                            System.out.print("Enter Day : ");
                            day = sc.nextInt();
                            System.out.print("Enter hour : ");
                            hour = sc.nextInt();
                            System.out.print("Enter minute : ");
                            minute = sc.nextInt();
                            System.out.print("Enter the specialization : ");
                            specialization = sc.next();
                            if(choice==1) {
                                Assignment lab = new Lab(name, month, day, hour, minute, specialization);
                                scanSetItems(lab);
                                items.addItem(lab);
                                break;
                            }
                            else{
                                System.out.print("Enter Data File : ");
                                dataFile = sc.next();
                                Assignment project = new Project(name, month, day, hour, minute, specialization, dataFile);
                                scanSetItems(project);
                                items.addItem(project);
                                break;
                            }
                case 0:     var=false;
                            break;
                default:    System.out.println("Invalid Choice!!! TRY AGAIN!!!");
            }
        }
        for(int i=0;i<totalItems;++i){
            System.out.println(items.listItems.get(i).toString());
        }

        double grade = items.computeCourseGrade();
        System.out.println("\nCourse Grade : "+ grade);

    }
    static void scanSetItems(Assignment assignment){
        Scanner sc1 = new Scanner(System.in);
        System.out.print("Enter Score : ");
        assignment.setScore(sc1.nextDouble());
        System.out.print("Enter total Points : ");
        assignment.setTotalPoints(sc1.nextDouble());
        System.out.print("Enter total Weight : ");
        assignment.setTotalWeight(sc1.nextDouble());
    }

}
