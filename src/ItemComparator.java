import java.util.Comparator;

/**
 * Comparator tool for Items, sorts by Name
 */

public class ItemComparator implements Comparator<Item> {

    /**
     * Compare based on name field
     * @param o1 first Item
     * @param o2 second Item
     * @return comparison
     */
    @Override
    public int compare(Item o1, Item o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
