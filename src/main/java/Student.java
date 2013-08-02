package gradebook.model;

import java.util.HashMap;

/**
 * The Student class is the lowest object in the Composite design pattern
 * for the gradebook. It's manages individual student data.
 */
public class Student implements GradeReportInterface {
    private float d6;
    private float c7;
    private float b8;
    private float a9;

    private String name;
    private GradingScheme gradingScheme;
    private HashMap<String, Float> grades;

    public Student(String name, GradingScheme gradingScheme) {
        this.name = name;
        this.gradingScheme = gradingScheme;
        this.grades = new HashMap<String, Float>();
    }

    public void setGradeScale(float d, float c, float b, float a) {
        d6 = d;
        c7 = c;
        b8 = b;
        a9 = a;
    }

    public String getName() {
        return name;
    }

    public void enterScore(String assignmentName, float score) {
        grades.put(assignmentName, score);
    }

    public float getScore(String itemName) {
        Float aGrade = grades.get(itemName);
        float result = 0.0f;
        if (aGrade != null) {
            result = aGrade;
        }
        return aGrade;
    }

    public float avgScore() {
        // based on the GradingScheme
        return gradingScheme.calculatePercentage(this);
    }

    public String letterGrade() {
        float avgScore = gradingScheme.calculatePercentage(this);
        String result = "F";
        if (avgScore >= d6) {
            result = "D";
        } else if (avgScore >= c7) {
            result = "C";
        } else if (avgScore >= b8) {
            result = "B";
        } else if (avgScore >= a9) {
            result = "A";
        }
        return result;
    }
}
