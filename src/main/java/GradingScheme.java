package gradebook.model;

import java.util.ArrayList;

/**
 * GradingScheme adheres to the Decorator pattern, allowing for
 * customization of catagories, items, and weights.
 */
public class GradingScheme {

    private ArrayList<GradebookCategory> categories;

    public GradingScheme() {
        categories = new ArrayList<GradebookCategory>();
    }

    public void addCategory(GradebookCategory category) {
        categories.add(category);
    }

    public float calculatePercentage(Student student) {
        float totalPercentage = 0.0f;
        for (int i = 0; i < categories.size(); i++) {
            totalPercentage += categories.get(i).calculatePercentage(student);
        }
        return totalPercentage;
    }
}
