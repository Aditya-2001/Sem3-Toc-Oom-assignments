package mypac;
import mypac.MyArrayList;

import java.util.Scanner;

public class TestClass{
    public static void main(String[] args) {
        System.out.println("Implementation of ArrayList:");
        //Let us take an ArrayList of people with their name as the value.
        MyArrayList<String> people = new MyArrayList<String>();
        boolean flag=true;
        while(flag){
            System.out.println();
            System.out.println("Enter 1 to add a person at the end");
            System.out.println("Enter 2 to set name of a person at the given index");
            System.out.println("Enter 3 to print name of a person at given index");
            System.out.println("Enter 4 to remove a person from the ArrayList");
            System.out.println("Enter 5 to clear the whole ArrayList");
            System.out.println("Enter 6 to print the size of ArrayList");
            System.out.println("Enter 7 to print the whole ArrayList");
            System.out.println("Enter 8 to exit");
            Scanner sc=new Scanner(System.in);
            int x=sc.nextInt();
            String name;
            Integer index;
            switch(x){
                case 1:     System.out.printf("Enter name of person: ");
                            name=sc.next();
                            people.add(name);
                            System.out.println("Person is added with name: " + name);
                            break;
                case 2:     System.out.printf("Enter name of person: ");
                            name=sc.next();
                            System.out.printf("Enter index where this person is to be added: ");
                            index=sc.nextInt();
                            people.set(index, name);
                            System.out.printf("Person at index " + index + " is: " + people.get(index));
                            break;
                case 3:     System.out.printf("Enter index from where person name is to be displayed: ");
                            index=sc.nextInt();
                            System.out.println("Person at index " + index + " is: " + people.get(index));
                            break;
                case 4:     System.out.printf("Enter index from where person is to be removed: ");
                            index=sc.nextInt();
                            people.remove(index);
                            System.out.println("Person at index " + index + " is successfully removed from the arraylist");
                            break;
                case 5:     people.clear();
                            System.out.println("ArrayList is cleared");
                            break;
                case 6:     if(people.size()==0) {
                                System.out.println("No person in the arraylist");
                                break;
                            }
                            System.out.println("Number of persons in arraylist are: " + people.size());
                            break;
                case 7:     if(people.size()==0) {
                                System.out.println("No person in the ArrayList");
                                break;
                            }
                            System.out.printf("The ArrayList is: ");
                            people.display();
                            break;
                case 8:    flag=false;
                           break;
                default:   System.out.println("Not a valid option, try another option!!!");
            }
        }
    }
}