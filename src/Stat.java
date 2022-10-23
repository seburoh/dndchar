/**
 * Primary class for player stats
 */

public class Stat {
    private int strength; //buildable by roll only, add method allows for negative/zero on purpose
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;
    private int proficiency; //zero/negatives allowed on purpose for RP

    private int health;
    private int maxHealth;
    private int level;
    private int exp;
    private int speed;
    private String hitDice;
    private int inspiration;

    /**
     * Default constructor
     */
    public Stat(){
        this.proficiency = 1;
        this.level = 1;
        this.exp = 0;
        this.inspiration = 0;
    }

    /**
     * Checks if roll sum is valid for 3d6 standard
     * @param i roll sum
     * @return boolean for valid
     */
    private boolean validRoll(int i){
        return i >= 3 && i <= 18;
    }

    /**
     * Get prof
     * @return prof
     */
    public int getProficiency() {
        return proficiency;
    }

    /**
     * Set new prof
     * @param proficiency to set
     */
    public void setProficiency(int proficiency) {
        this.proficiency = proficiency;
    }

    //STR

    /**
     * Get str
     * @return str
     */
    public int getStrength() {
        return strength;
    }

    /**
     * Get strMod
     * @return strMod
     */
    public int getStrengthMod(){
        return (this.strength - 10) / 2;
    }

    /**
     * Set 3d6 str
     * @param strength to set
     */
    public void setRolledStrength(int strength) {

        if (!validRoll(strength)){
            throw new IllegalArgumentException("Roll out of bounds");
        }

        this.strength = strength;
    }

    /**
     * Add number to str
     * @param add number to add
     */
    public void addStrength(int add){
        this.strength += add;
    }

    //DEX

    /**
     * Get dex
     * @return dex
     */
    public int getDexterity() {
        return dexterity;
    }

    /**
     * Get dexMod
     * @return dexMod
     */
    public int getDexterityMod(){
        return (this.dexterity - 10) / 2;
    }

    /**
     * Set 3d6 dex
     * @param dexterity to set
     */
    public void setRolledDexterity(int dexterity) {

        if (!validRoll(dexterity)){
            throw new IllegalArgumentException("Roll out of bounds");
        }

        this.dexterity = dexterity;
    }

    /**
     * Add number to str
     * @param add number to add
     */
    public void addDexterity(int add){
        this.dexterity += add;
    }

    //CON

    /**
     * Get Con
     * @return Con
     */
    public int getConstitution() {
        return constitution;
    }

    /**
     * Get ConMod
     * @return ConMod
     */
    public int getConstitutionMod(){
        return (this.constitution - 10) / 2;
    }

    /**
     * Set 3d6 Con
     * @param constitution to set
     */
    public void setRolledConstitution(int constitution) {

        if (!validRoll(constitution)){
            throw new IllegalArgumentException("Roll out of bounds");
        }

        this.constitution = constitution;
    }

    /**
     * Add number to Con
     * @param add number to add
     */
    public void addConstitution(int add){
        this.constitution += add;
    }

    //INT

    /**
     * Get Int
     * @return Int
     */
    public int getIntelligence() {
        return intelligence;
    }

    /**
     * Get IntMod
     * @return IntMod
     */
    public int getIntelligenceMod(){
        return (this.intelligence - 10) / 2;
    }

    /**
     * Set 3d6 Int
     * @param intelligence to set
     */
    public void setRolledIntelligence(int intelligence) {

        if (!validRoll(intelligence)){
            throw new IllegalArgumentException("Roll out of bounds");
        }

        this.intelligence = intelligence;
    }

    /**
     * Add number to Int
     * @param add number to add
     */
    public void addIntelligence(int add){
        this.intelligence += add;
    }

    //WIS

    /**
     * Get Wis
     * @return Wis
     */
    public int getWisdom() {
        return wisdom;
    }

    /**
     * Get WisMod
     * @return WisMod
     */
    public int getWisdomMod(){
        return (this.wisdom - 10) / 2;
    }

    /**
     * Set 3d6 Wis
     * @param wisdom to set
     */
    public void setRolledWisdom(int wisdom) {

        if (!validRoll(wisdom)){
            throw new IllegalArgumentException("Roll out of bounds");
        }

        this.wisdom = wisdom;
    }

    /**
     * Add number to Wis
     * @param add number to add
     */
    public void addWisdom(int add){
        this.wisdom += add;
    }

    //CHA

    /**
     * Get Cha
     * @return Cha
     */
    public int getCharisma() {
        return charisma;
    }

    /**
     * Get ChaMod
     * @return ChaMod
     */
    public int getCharismaMod(){
        return (this.charisma - 10) / 2;
    }

    /**
     * Set 3d6 Cha
     * @param charisma to set
     */
    public void setRolledCharisma(int charisma) {

        if (!validRoll(charisma)){
            throw new IllegalArgumentException("Roll out of bounds");
        }

        this.charisma = charisma;
    }

    /**
     * Add number to Cha
     * @param add number to add
     */
    public void addCharisma(int add){
        this.charisma += add;
    }

    //Other

    /**
     * Max carry weight
     * @return as int
     */
    public int getMaxWeight(){
        return 15*this.strength;
    }

    /**
     * Get base armor class
     * @return base ac
     */
    public int getBaseAC(){
        return 10+this.getDexterityMod();
    }

    /**
     * Get player initiative
     * @return init
     */
    public int getInitiative(){
        return getDexterityMod();
    }

    /**
     * Set max health
     * @param maxHealth to set
     */
    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    /**
     * Get max health
     * @return maxHP
     */
    public int getMaxHealth() {
        return maxHealth;
    }

    /**
     * Get current health
     * @return currentHP
     */
    public int getHealth() {
        return health;
    }

    /**
     * Set current health
     * @param health currentHP
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * Get current level
     * @return level
     */
    public int getLevel() {
        return level;
    }

    /**
     * Level up (hopefully not level down)
     * @param level to add
     */
    public void addLevel(int level) {
        this.level += level;
    }

    /**
     * Get current EXP
     * @return exp
     */
    public int getExp() {
        return exp;
    }

    /**
     * Add exp (hopefully not remove!)
     * @param exp to add
     */
    public void addExp(int exp) {
        this.exp += exp;
    }

    /**
     * Get character speed
     * @return speed
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Set new character speed
     * @param speed to set
     */
    public void setSpeed(int speed) {
        this.speed = Math.max(speed, 0);
    }

    /**
     * Get hit dice as String
     * @return hit dice
     */
    public String getHitDice() {
        return hitDice;
    }

    /**
     * Set new hitdice string
     * @param hitDice to set
     */
    public void setHitDice(String hitDice) {
        if (hitDice.isBlank()){
            throw new IllegalArgumentException("No dice given");
        }
        this.hitDice = hitDice;
    }

    /**
     * Get current insp
     * @return insp
     */
    public int getInspiration() {
        return inspiration;
    }

    /**
     * Add/spend inspiration
     * @param inspiration to math
     */
    public void setInspiration(int inspiration) {

        if (inspiration > 0){
            this.inspiration += inspiration;
        }
        else {
            if (this.inspiration - inspiration < 0){
                throw new IllegalArgumentException("Negative inspiration bad!");
            }
            else {
                this.inspiration -= inspiration;
            }
        }


    }

    /**
     * Stats to string
     * @return string of stats
     */
    @Override
    public String toString() {
        return  "Strength: " + strength +
                "\nDexterity: " + dexterity +
                "\nConstitution: " + constitution +
                "\nIntelligence: " + intelligence +
                "\nWisdom: " + wisdom +
                "\nCharisma: " + charisma +
                "\nProficiency: " + proficiency +
                "\nHealth: " + health +
                "\nMaxHealth: " + maxHealth +
                "\nLevel: " + level +
                "\nExp: " + exp +
                "\nSpeed: " + speed +
                "\nHitDice: " + hitDice +
                "\nInspiration: " + inspiration +
                "\nMax Carry Weight: " + getMaxWeight() +
                "\nBase AC: " + getBaseAC() +
                "\nInitiative: " + getInitiative();
    }
}
