package gradebook.model;

import java.util.ArrayList;

/**
 * GradebookCategory is an abstract class that allows for
 * user defined catagories with custom weight of the total
 * grade. Part of the Decorator pattern used by GradingScheme.
 */
public abstract class GradebookCategory {

    protected float weight;
    protected ArrayList<GradebookItem> items;

    public GradebookCategory(float weight) {
        this.weight = weight;
        this.items = new ArrayList<GradebookItem>();
    }

    public void addGradebookItem(GradebookItem item) {
        items.add(item);
    }

    /**
     * Calculates the percentage of this catagory
     * the student has completed.
     */
    public abstract float calculatePercentage(Student student);
}
