import java.io.Serializable;

public class ScoredModule implements Serializable {
    private double score;
    private Module module;

    public ScoredModule(double score, Module module) {
        this.score = score;
        this.module = module;
    }

    private double toGrade() {
        return Math.floor(Math.max((this.score / 5.0) - 9.0, 0)) / 2;
    }

    public double getGradePoint() {
        return this.toGrade() * this.getCredit();
    }

    public double getCredit() {
        return this.module.getCredit();
    }
}
