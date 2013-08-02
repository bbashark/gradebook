package gradebook.model;


/**
 * Shows the flexibility of the grading category grade calculation.
 */
public class DropLowestCategory extends GradebookCategory {

    public DropLowestCategory(float weight) {
        super(weight);
    }

    public float calculatePercentage(Student student) {
        float studentPoints = 0.0f;
        float totalMaxPoints = 0.0f;
        float curLowestStudentPoints = 0.0f;
        float curLowestMaxPoints = 0.0f;
        for (int i = 0; i < items.size(); i++) {
            GradebookItem curItem = items.get(i);
            float score = student.getScore(curItem.getItemName());
            float maxPoints = curItem.getMaxPoints();
            studentPoints += score;
            totalMaxPoints += maxPoints;
            if (i == 0) {
                // initial item is the lowest score
                curLowestStudentPoints = score;
                curLowestMaxPoints = maxPoints;
            } else {
                if (maxPoints > 0 && curLowestMaxPoints > 0) {
                    if (score / maxPoints
                            < curLowestStudentPoints / curLowestMaxPoints) {
                        curLowestStudentPoints = score;
                        curLowestMaxPoints = maxPoints;
                    }
                }
            }
        }
        if (items.size() > 1) {
            // only drop the lowest score if there is more than one item.
            studentPoints -= curLowestStudentPoints;
            totalMaxPoints -= curLowestMaxPoints;
        }
        float result = 0.0f;
        if (totalMaxPoints > 0) {
            result = weight * (studentPoints / totalMaxPoints);
        }

        return result;
    }
}
