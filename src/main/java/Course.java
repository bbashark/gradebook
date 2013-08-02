package gradebook.model;

import java.util.ArrayList;

/**
 * Course represents the top level of the Composite design
 * pattern used for this gradebook
 *
 * It's children are made up of Class objects.
 *
 */
public class Course implements GradeReportInterface {
    private float d6;
    private float c7;
    private float b8;
    private float a9;

    private String subject;
    private int courseNumber;
    private String name;
    private ArrayList<String> prereqs;

    private ArrayList<GradebookClass> classes;


    public Course(String subject, int courseNumber, String name,
                    ArrayList<String> prereqs) {
        this.subject = subject;
        this.courseNumber = courseNumber;
        this.name = name;
        this.prereqs = prereqs; // prerequisite courses

        this.classes = new ArrayList<GradebookClass>();
    }

    public void setGradeScale(float d, float c, float b, float a) {
        d6 = d;
        c7 = c;
        b8 = b;
        a9 = a;
    }

    public String getSubject() {
        return subject;
    }

    public int getCourseNumber() {
        return courseNumber;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getPrereqs() {
        return prereqs;
    }

    public ArrayList<GradebookClass> getClasses() {
        return classes;
    }

    public void addClass(GradebookClass aClass) {
        classes.add(aClass);
    }

    public float avgScore() {
        float scoreTotal = 0.0f;
        for (int i = 0; i < classes.size(); i++) {
            scoreTotal += classes.get(i).avgScore();
        }
        float avgScore = 0.0f;
        if (classes.size() > 0) {
            avgScore = scoreTotal / (float) classes.size();
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
