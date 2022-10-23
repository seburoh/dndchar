import java.text.DecimalFormat;

/**
 * Object class for Items
 */

public class Item {
    //item properties
    private String name;
    private double weight;
    private String description;
    private int amount;
    public static DecimalFormat df = new DecimalFormat("#.#"); //df.format(inv.getWeight())

    /**
     * Constructor
     * </br> Zero amount allowed on purpose
     * </br> Negative/Zero weight allowed on purpose
     * @param n name
     * @param w weight
     * @param d description
     * @param a amount
     */
    public Item(String n, double w, String d, int a){
        if (n == null || n.equals("")){ //name given?
            throw new IllegalArgumentException("Name empty");
        }
        if (a < 0){
            throw new IllegalArgumentException("Negative amount given");
        }
        if (d == null || d.equals("")){ //desc given?
            throw new IllegalArgumentException("No description given");
        }

        this.name = n;
        this.weight = w;
        this.description = d;
        this.amount = a;
    }

    /**
     * Set new amount of item
     * @param a amount to set to
     */
    public void setAmount(int a){
        if (a < 0){
            throw new IllegalArgumentException("Negative amount given");
        }
        this.amount = a;
    }

    /**
     * Set new name of item
     * @param n new name
     */
    public void setName(String n){
        if (n == null || n.equals("")){ //name given?
            throw new IllegalArgumentException("Name empty");
        }
        this.name = n;
    }

    /**
     * Set new description of item
     * @param d new description
     */
    public void setDescription(String d) {
        if (d == null || d.equals("")) { //desc given?
            throw new IllegalArgumentException("No description given");
        }
        this.description = d;
    }

    /**
     * Set new weight of item
     * @param w weight
     */
    public void setWeight(double w) {
        this.weight = w;
    }

    /**
     * Return name of item
     * @return name
     */
    public String getName(){
        return this.name;
    }

    /**
     * Return weight of item
     * @return weight
     */
    public double getSingleWeight() {
        return this.weight;
    }

    /**
     * Return weight of single item as string
     * @return string
     */
    public String singleWeightToString(){
        return df.format(this.getSingleWeight());
    }

    /**
     * Return weight of stack of items as string
     * @return string
     */
    public String totalWeightToString(){
        return df.format(this.getTotalWeight());
    }

    /**
     * Return total weight of an item considering it's amount
     * @return total weight
     */
    public double getTotalWeight(){
        return this.weight * this.amount;
    }

    /**
     * Return description of item
     * @return description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Return amount of item
     * @return amount
     */
    public int getAmount() {
        return this.amount;
    }

    /**
     * Print item to String
     * @return formatted String
     */
    @Override
    public String toString() {
        return "Name: " + name +
                ", Weight: " + getSingleWeight() +
                ", Amount: " + amount +
                ", Description: " + description;
    }

}