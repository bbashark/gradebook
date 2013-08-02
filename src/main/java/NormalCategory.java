package gradebook.model;


/**
 * Shows the flexibility of the grading category grade calculation.
 */
public class NormalCategory extends GradebookCategory {

    public NormalCategory(float weight) {
        super(weight);
    }

    public float calculatePercentage(Student student) {
        float studentPoints = 0.0f;
        float totalMaxPoints = 0.0f;
        for (int i = 0; i < items.size(); i++) {
            GradebookItem curItem = items.get(i);
            float score = student.getScore(curItem.getItemName());
            float maxPoints = curItem.getMaxPoints();
            studentPoints += score;
            totalMaxPoints += maxPoints;
        }
        float result = 0.0f;
        if (totalMaxPoints > 0.0f) {
            result = weight * (studentPoints / totalMaxPoints);
        }

        return result;
    }
}
