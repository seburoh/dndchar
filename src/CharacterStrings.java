import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * Elements of a Character which don't interact with anything else
 */

public class CharacterStrings {
    //elements of a character which don't interact
    private String name;
    private String cClass;
    private String background;
    private String race;
    private String alignment;
    private String age; //set as string to allow for role-playing freedom
    private String height; //set as string to allow for role-playing freedom
    private String weight; //set as string to allow for role-playing freedom
    private String eyeColor;
    private String skinColor;
    private String hairColor;
    private String backstory;

    private PriorityQueue<String> proficiencies = new PriorityQueue<>(String.CASE_INSENSITIVE_ORDER);
    private TreeMap<String,String> features = new TreeMap<>();

    /**
     * Constructor
     * @param n name to start with
     */
    public CharacterStrings(String n){
        if (n == null || n.equals("")){
            throw new IllegalArgumentException("Empty Field");
        }
        this.name = n;
    }

    /**
     * Get name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Set name again
     * @param name to set
     */
    public void setName(String name) {
        if (name == null || name.equals("")){
            throw new IllegalArgumentException("Empty Field");
        }
        this.name = name;
    }

    /**
     * Get character class
     * @return class
     */
    public String getcClass() {
        return cClass;
    }

    /**
     * Set character class
     * @param cClass class
     */
    public void setcClass(String cClass) {
        if (cClass == null || cClass.equals("")){
            throw new IllegalArgumentException("Empty Field");
        }
        this.cClass = cClass;
    }

    /**
     * Get background
     * @return background
     */
    public String getBackground() {
        return background;
    }

    /**
     * Set background
     * @param background to set
     */
    public void setBackground(String background) {
        if (background == null || background.equals("")){
            throw new IllegalArgumentException("Empty Field");
        }
        this.background = background;
    }

    /**
     * Get race
     * @return race
     */
    public String getRace() {
        return race;
    }

    /**
     * Set race
     * @param race to set
     */
    public void setRace(String race) {
        if (race == null || race.equals("")){
            throw new IllegalArgumentException("Empty Field");
        }
        this.race = race;
    }

    /**
     * Get alignment
     * @return alignment
     */
    public String getAlignment() {
        return alignment;
    }

    /**
     * Set alignment
     * @param alignment to set
     */
    public void setAlignment(String alignment) {
        if (alignment == null || alignment.equals("")){
            throw new IllegalArgumentException("Empty Field");
        }
        this.alignment = alignment;
    }

    /**
     * Get age
     * @return age
     */
    public String getAge() {
        return age;
    }

    /**
     * Set age
     * </br> Negatives are ok, let people time travel if that's their jam
     * @param age to set
     */
    public void setAge(String age) {
        if (age == null || age.equals("")){
            throw new IllegalArgumentException("Empty Field");
        }
        this.age = age;
    }

    /**
     * Get height
     * @return height
     */
    public String getHeight() {
        return height;
    }

    /**
     * Set height
     * @param height to set
     */
    public void setHeight(String height) {
        if (height == null || height.equals("")){
            throw new IllegalArgumentException("Empty Field");
        }
        this.height = height;
    }

    /**
     * Get weight
     * @return weight
     */
    public String getWeight() {
        return weight;
    }

    /**
     * Set weight
     * @param weight to set
     */
    public void setWeight(String weight) {
        if (weight == null || weight.equals("")){
            throw new IllegalArgumentException("Empty Field");
        }
        this.weight = weight;
    }

    /**
     * Get eye color
     * @return eye color
     */
    public String getEyeColor() {
        return eyeColor;
    }

    /**
     * Set eye color
     * @param eyeColor to set
     */
    public void setEyeColor(String eyeColor) {
        if (eyeColor == null || eyeColor.equals("")){
            throw new IllegalArgumentException("Empty Field");
        }
        this.eyeColor = eyeColor;
    }

    /**
     * Get skin color
     * @return skin color
     */
    public String getSkinColor() {
        return skinColor;
    }

    /**
     * Set skin color
     * @param skinColor to set
     */
    public void setSkinColor(String skinColor) {
        if (skinColor == null || skinColor.equals("")){
            throw new IllegalArgumentException("Empty Field");
        }
        this.skinColor = skinColor;
    }

    /**
     * Get hair color
     * @return hair color
     */
    public String getHairColor() {
        return hairColor;
    }

    /**
     * Set hair color
     * @param hairColor to set
     */
    public void setHairColor(String hairColor) {
        if (hairColor == null || hairColor.equals("")){
            throw new IllegalArgumentException("Empty Field");
        }
        this.hairColor = hairColor;
    }

    /**
     * Get backstory
     * @return backstory
     */
    public String getBackstory() {
        return backstory;
    }

    /**
     * Get backstory but with linebreaks
     * @return backstory formatted
     */
    public String getFormattedBackstory(){
        if (this.backstory.length() <= 100){ //too small to matter?
            return this.backstory + "\n";
        }
        return formattedBackstoryHelper(this.backstory);
    }
    /**
     * Private helper method for printing formatted backstory
     * @param str Section of backstory still being worked on.
     * @return each line of backstory.
     */
    private String formattedBackstoryHelper(String str){
        if (str.length() <= 100){ //base case
            return str + "\n";
        }

        boolean breakpoint = true; //set break boolean for while loop
        int i = 100; //set default line length

        while (breakpoint){
            if (str.charAt(i) == ' ' || i ==0){ //have we found a space, or are we at the beginning?
                breakpoint = false; //out we go
            }
            else{ //try again
                i--;
            }
        }

        if (i == 0){ //didn't find a space
            String thisLine = str.substring(0,100) + "\n";
            return thisLine + formattedBackstoryHelper(str.substring(100));
        }
        else { //found a space
            String thisLine = str.substring(0,i) + "\n";
            return thisLine + formattedBackstoryHelper(str.substring(i+1));
        }
    }

    /**
     * Set backstory
     * @param backstory to set
     */
    public void setBackstory(String backstory) {
        if (backstory == null || backstory.equals("")){
            throw new IllegalArgumentException("Empty Field");
        }
        if (backstory.equals("TIMETODUEL")){ //easter egg
            this.backstory = "Now this is a story all about how " +
                    "my life got flipped, turned upside down " +
                    "And I'd like to take a minute " +
                    "just sit down, James " +
                    "I'll tell you how I became " +
                    "the undisputed King of Card Games. " +
                    "In northeastern Africa, born and raised " +
                    "in the palace was where I spent most of my days " +
                    "chilling out max and relaxin' all the while " +
                    "or playing some card games right beside the Nile " +
                    "When a couple of guys, who were up to no good " +
                    "starting making trouble in my neighborhood! " +
                    "I got in one little fight and the gods got scared " +
                    "they said \"You're moving in " +
                    "with Yugi and his Grandpa downstairs!\" " +
                    "I wound up in Japan, and things were less clear " +
                    "like I couldn't kill folks for losing card games here! " +
                    "If anything, I could say that this place is lame " +
                    "but I thought, \"Nah, forget it, I'll play some card games!\" " +
                    "I bought card game booster packs, seven or eight, " +
                    "and I yelled at the old man \"Yo, Homes, smell ya later!\" " +
                    "Looked at my kingdom, I was finally there " +
                    "to sit on my throne with my ridiculous hair. ";
        }
        else {
            this.backstory = backstory;
        }
    }

    /**
     * Gives list of proficiencies as string
     * @return string of prof's
     */
    public String proficienciesToString() {

        PriorityQueue<String> tempPQ = new PriorityQueue<>(this.proficiencies); //don't nuke the original

        StringBuilder str = new StringBuilder();

        while (!tempPQ.isEmpty()){ //build string
            str.append(tempPQ.poll()).append("\n");
        }

        return str.toString(); //send it
    }

    /**
     * Add proficiency
     * @param prof to add
     */
    public void addProficiencies(String prof) {
        this.proficiencies.add(prof);
    }

    /**
     * Add feature
     * @param name of feature
     * @param desc of feature
     */
    public void addFeature(String name, String desc) {
        this.features.put(name, desc);
    }

    /**
     * Gives list of features as string
     * @return features
     */
    public String featuresToString() {

        StringBuilder str = new StringBuilder();

        for (Map.Entry<String,String> feat:this.features.entrySet()) {
            str.append(feat.getKey()).append(": ").append(feat.getValue()).append("\n");
        }

        return str.toString();
    }

    /**
     * Gives all of CharStrings fields as single String output
     * @return string of all fields
     */
    @Override
    public String toString() {

        return "Name: " + name +
                "\nClass: " + cClass +
                "\nBackground:" + background +
                "\nRace:" + race +
                "\nAlignment:" + alignment +
                "\nAge:" + age +
                "\nHeight:" + height +
                "\nWeight:" + weight +
                "\nEyeColor:" + eyeColor +
                "\nSkinColor:" + skinColor +
                "\nHairColor:" + hairColor +
                "\nBackstory:" + getFormattedBackstory() +
                "\nProficiencies:\n" + proficienciesToString() +
                "\nFeatures:\n" + featuresToString();
    }
}
