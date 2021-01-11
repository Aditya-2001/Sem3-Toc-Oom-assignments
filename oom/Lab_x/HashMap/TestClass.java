package mypack;
import mypack.MyHashMap;

import java.util.Scanner;

public class TestClass{
        public static void main(String[] args) {
            System.out.println("Implementation of HashMap:");
            //Let us take an HashMap of people with their name as Key and age as Value.
            MyHashMap<String, Integer> people = new MyHashMap<String, Integer>();
            boolean flag=true;
            while(flag){
                System.out.println();
                System.out.println("Enter 1 to add a person");
                System.out.println("Enter 2 to print age of a person");
                System.out.println("Enter 3 to remove a person from the hashmap");
                System.out.println("Enter 4 to clear the whole hashmap");
                System.out.println("Enter 5 to print the size of hashmap");
                System.out.println("Enter 6 to print the whole hashmap");
                System.out.println("Enter 7 to print key at a specific index");
                System.out.println("Enter 8 to print value at a specific index");
                System.out.println("Enter 9 to print all keys using a loop");
                System.out.println("Enter 10 to print all values using a loop");
                System.out.println("Enter 11 to exit");
                Scanner sc=new Scanner(System.in);
                int x=sc.nextInt();
                String name;
                Integer age,index;
                switch(x){
                    case 1:     System.out.printf("Enter name of person: ");
                                name=sc.next();
                                System.out.printf("Enter age of person: ");
                                age=sc.nextInt();
                                people.put(name,age);
                                System.out.println("Person is added with name: " + name + " and age: " + age);
                                break;
                    case 2:     System.out.printf("Enter name of person whose age is to be displayed: ");
                                name=sc.next();
                                if(people.get(name)==null)
                                    System.out.println("No such person in hashmap");
                                else
                                    System.out.println("Age of " + name + " is " + people.get(name));
                                break;
                    case 3:     System.out.printf("Enter name of person to be removed: ");
                                name=sc.next();
                                boolean var=people.remove(name);
                                if(!var)
                                    System.out.println("No such person in hashmap");
                                else
                                    System.out.println(name + " is successfully removed from the hashmap");
                                break;
                    case 4:     people.clear();
                                System.out.println("HashMap is cleared");
                                break;
                    case 5:     if(people.size()==0) {
                                    System.out.println("No person in the HashMap");
                                    break;
                                }
                                System.out.println("Number of (key, value) pairs in hashmap are: " + people.size());
                                break;
                    case 6:     if(people.size()==0) {
                                    System.out.println("No person in the HashMap");
                                    break;
                                }
                                System.out.printf("The HashMap is: ");
                                people.display();
                                break;
                    case 7:     if(people.size()==0) {
                                    System.out.println("No person in the HashMap");
                                    break;
                                }
                                System.out.printf("Enter specific index at which name would be displayed: ");
                                index=sc.nextInt();
                                System.out.println("Name at index " + index + " is: " + people.getKey(index));
                                break;
                    case 8:     if(people.size()==0) {
                                    System.out.println("No person in the HashMap");
                                    break;
                                }
                                System.out.printf("Enter specific index at which age would be displayed: ");
                                index=sc.nextInt();
                                System.out.println("Age at index " + index + " is: " + people.getValue(index));
                                break;
                    case 9:     if(people.size()==0) {
                                    System.out.println("No person in the HashMap");
                                    break;
                                }
                                System.out.printf("Names are: ");
                                for(int i=0;i<people.size();i++) {
                                    System.out.printf(people.getKey(i));
                                    if(i!=people.size()-1)
                                        System.out.printf(",  ");
                                }
                                break;
                    case 10:    if(people.size()==0) {
                                    System.out.println("No person in the HashMap");
                                    break;
                                }
                                System.out.printf("Ages are: ");
                                for(int i=0;i<people.size();i++) {
                                    System.out.print(people.getValue(i));
                                    if(i!=people.size()-1)
                                        System.out.printf(",  ");
                                }
                                break;
                    case 11:    flag=false;
                                break;
                    default:    System.out.println("Not a valid option, try another option!!!");
                }
            }
        }
}