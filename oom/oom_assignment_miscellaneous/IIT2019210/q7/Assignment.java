package q7;

public class Assignment {
    String name;
    int month, day, hour, minute;
    double score, totalPoints, totalWeight;

    public Assignment(String name, int month, int day, int hour, int min) {
        this.name = name;
        this.month = month;
        this.hour = hour;
        this.day = day;
        this.minute = min;
    }
    void setScore(double score){
        this.score = score;
    }
    void setTotalPoints(double tp){
        this.totalPoints = tp;
    }
    void setTotalWeight(double tw){
        this.totalWeight = tw;
    }
    String getName(){
        return name;
    }
    int getMonth(){
        return month;
    }
    int getDay(){
        return day;
    }
    int getHour(){
        return hour;
    }
    int getMinute(){
        return minute;
    }
    double getScore(){
        return score;
    }
    double getTotalPoints(){
        return totalPoints;
    }
    double getTotalWeight(){
        return totalWeight;
    }
    public String toString() {
        return "Assignment {" +
                "Name='" + getName()+ '\'' +
                ",\n Month=" + getMonth() +
                ",\n Day=" + getDay() +
                ",\n Hour=" + getHour() +
                ",\n Minute=" + getMinute() +
                ",\n Score=" + getScore() +
                ",\n Total Points=" + getTotalPoints() +
                ",\n Total Weight=" + getTotalWeight() +
                '}';
    }
}
