package gradebook.model;


/**
 * Straightforward, concrete class that defines an item
 * to be graded. Part of the decorator pattern used by GradingScheme.
 */
public class GradebookItem {

    private String itemName;
    private float maxPoints;

    public GradebookItem(String itemName, float maxPoints) {
        this.itemName = itemName;
        this.maxPoints = maxPoints;
    }

    public String getItemName() {
        return itemName;
    }

    public float getMaxPoints() {
        return maxPoints;
    }
}
