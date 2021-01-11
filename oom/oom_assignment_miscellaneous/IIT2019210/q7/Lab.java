package q7;
import q7.Assignment;

public class Lab extends Assignment {
    String specification;
    Lab(String name,int month,int day, int hour,int minute, String spec){
        super(name, month,day, hour,minute);
        this.specification = spec;
    }

    public String toString(){
        return "\nLab {\n" +
                super.toString().substring(12,super.toString().length()-1)+     //Starting index is 12 because we want string from this index upto last index
                ",\n Specification='" + this.specification + '\'' +
                "\n}";
    }
}
