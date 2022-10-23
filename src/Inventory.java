import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Inventory management
 */

public class Inventory {
    private TreeSet<Item> inven;

    /**
     * Constructor for inventory
     */
    public Inventory(){
        this.inven = new TreeSet<>(new ItemComparator());
    }

    /**
     * Add item to set
     * @param i item
     */
    public void addItem(Item i){
        if (!this.contains(i.getName())){
            inven.add(i);
        }
        else {
            throw new IllegalArgumentException("Already have this item!");
        }
    }

    /**
     * Add list of items to set
     * @param items ArrayList of items to add
     */
    public void addItems(ArrayList<Item> items){
        for (Item i:items) {
            this.addItem(i);
        }
    }

    /**
     * Remove item from set
     * @param n name of item to remove
     */
    public void removeItem(String n){
        if (!this.contains(n)){
            throw new IllegalArgumentException("No such item found!");
        }
        inven.removeIf(i -> i.getName().equals(n));
    }

    /**
     * [OLD] Checks by name if TreeSet contains item
     * @param n name to check
     * @return boolean of result
     */
    private boolean containsOld(String n){
        for (Item i:inven) {
            if (i.getName().equals(n)){
                return true;
            }
        }
        return false;
    }

    /**
     * Checks by name if TreeSet contains item
     * @param n name to check
     * @return boolean of result
     */
    public boolean contains(String n){
        Item test = new Item(n,0,"a",0);
        return inven.contains(test);
    }

    /**
     * Print inventory to string
     * @return string
     */
    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        for (Item i:inven) { //add each item as new line
            str.append(i.toString()).append("\n");
        }
        return str.toString().substring(0, str.length()-1); //remove the last linebreak
    }

    /**
     * Return weight of inventory
     * @return total weight
     */
    public double getWeight(){

        double w = 0.0;

        for (Item i:inven) {
            w += i.getTotalWeight();
        }

        return w;
    }
}
