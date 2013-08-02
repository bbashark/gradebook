package gradebook.model;

import java.util.ArrayList;

/**
 * The Section objects are managed by class objects, and
 * are the third level down the hierarchy for a gradebook in the
 * Composite design pattern. It manages students.
 */
public class Section implements GradeReportInterface {
    private float d6;
    private float c7;
    private float b8;
    private float a9;

    private ArrayList<Student> students;

    public Section() {
        students = new ArrayList<Student>();
    }

    public void setGradeScale(float d, float c, float b, float a) {
        d6 = d;
        c7 = c;
        b8 = b;
        a9 = a;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public float avgScore() {
        float scoreTotal = 0.0f;
        for (int i = 0; i < students.size(); i++) {
            scoreTotal += students.get(i).avgScore();
        }
        float avgScore = 0.0f;
        if (students.size() > 0) {
            avgScore = scoreTotal / (float) students.size();
        }
        return avgScore;
    }

    public String letterGrade() {
        float avgScore = avgScore();
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
