package gradebook.model;

import java.util.ArrayList;

/**
 * The Class object manages section objects, and is the second
 * level down in the Composite design pattern.
 *
 */
public class GradebookClass implements GradeReportInterface {
    private float d6;
    private float c7;
    private float b8;
    private float a9;

    private ArrayList<Section> sections;

    public GradebookClass() {
        sections = new ArrayList<Section>();
    }

    public void setGradeScale(float d, float c, float b, float a) {
        d6 = d;
        c7 = c;
        b8 = b;
        a9 = a;
    }

    public void addSection(Section section) {
        sections.add(section);
    }

    public float avgScore() {
        float scoreTotal = 0.0f;
        for (int i = 0; i < sections.size(); i++) {
            scoreTotal += sections.get(i).avgScore();
        }
        float avgScore = 0.0f;
        if (sections.size() > 0) {
            avgScore = scoreTotal / (float) sections.size();
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
