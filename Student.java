import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable {
    private String name;
    private String id;
    private String className;

    private double gradePointSum = 0;
    private double creditSum = 0;

    private ArrayList<ScoredModule> modules;

    public Student(String name, String id, String className) {
        this.name = name;
        this.id = id;
        this.className = className;
        this.modules = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void addScoredModule(ScoredModule module) {
        this.modules.add(module);
        this.gradePointSum += module.getGradePoint();
        this.creditSum += module.getCredit();
    }

    public double getGpa() {
        if (this.gradePointSum == 0)
            return 0;
        return this.gradePointSum / this.creditSum;
    }

    public String toString() {
        return String.format("%s (%s) [%s] - %.2f/4", this.name, this.id, this.className, this.getGpa());
    }
}