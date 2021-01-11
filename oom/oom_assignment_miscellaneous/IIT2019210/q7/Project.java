package q7;
import q7.Assignment;

public class Project extends Assignment {
    String specification;
    String dataFile;

    Project(String name,int month,int day, int hour,int minute, String spec, String dataFile){
        super(name, month,day, hour,minute);
        this.specification = spec;
        this.dataFile = dataFile;
    }

    public String toString() {
        return "\nProject {\n" +
                super.toString().substring(12,super.toString().length()-1)+
                ",\nSpecification='" + specification + '\'' +
                ",\nData File='" + dataFile + '\'' +
                "\n}";
    }
}
