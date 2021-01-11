package q7;

import java.util.ArrayList;

public class AssignmentList {
    ArrayList<Assignment> listItems;

    public AssignmentList(){
        System.out.println("Creating new Assignment List");
        listItems = new ArrayList<Assignment>();
    }

    void addItem(Assignment item){
        listItems.add(item);
    }

    double computeCourseGrade(){
        double grade = 0.0;     //initialize to 0
        double sum = 0.0;       //initialize to 0
        int n = listItems.size();   //taking size of list
        for(int i=0;i<n;++i){
            double Score = listItems.get(i).score;
            double TotalPoints = listItems.get(i).totalPoints;
            double TotalWeight = listItems.get(i).totalWeight;
            sum += TotalWeight;
            grade += (TotalWeight*Score)/TotalPoints;
        }
        if(sum != 0.0)
            grade = (grade/sum) * 10;
        return grade;
    }
}
