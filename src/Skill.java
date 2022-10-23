/**
 Skills class for Character
 */

public class Skill {
    private int acrobatics; //negative/zero allowed on purpose to allow for RP
    private int animalHandling;
    private int arcana;
    private int athletics;
    private int deception;
    private int history;
    private int insight;
    private int intimidation;
    private int investigation;
    private int medicine;
    private int nature;
    private int perception;
    private int performance;
    private int persuasion;
    private int religion;
    private int slightOfHand;
    private int stealth;
    private int survival;

    public Skill(){
        acrobatics = 0;
        animalHandling = 0;
        arcana = 0;
        athletics = 0;
        deception = 0;
        history = 0;
        insight = 0;
        intimidation = 0;
        investigation = 0;
        medicine = 0;
        nature = 0;
        perception = 0;
        performance = 0;
        persuasion = 0;
        religion = 0;
        slightOfHand = 0;
        stealth = 0;
        survival = 0;
    }

    /**
     * Set Acrobatics mod
     * @param acrobatics mod to apply
     */
    public void setAcrobatics(int acrobatics) {
        this.acrobatics += acrobatics;
    }

    /**
     * Get acrobatics score
     * @return score
     */
    public int getAcrobatics() {
        return acrobatics*Main.stats.getProficiency()+Main.stats.getDexterityMod();
    }

    /**
     * Set animalHandling mod
     * @param animalHandling mod to apply
     */
    public void setAnimalHandling(int animalHandling) {
        this.animalHandling += animalHandling;
    }

    /**
     * Get animalHandling score
     * @return score
     */
    public int getAnimalHandling() {
        return animalHandling*Main.stats.getProficiency()+Main.stats.getWisdomMod();
    }

    /**
     * Set arcana mod
     * @param arcana mod to apply
     */
    public void setArcana(int arcana) {
        this.arcana += arcana;
    }

    /**
     * Get arcana score
     * @return score
     */
    public int getArcana() {
        return arcana*Main.stats.getProficiency()+Main.stats.getIntelligenceMod();
    }

    /**
     * Set athletics mod
     * @param athletics mod to apply
     */
    public void setAthletics(int athletics) {
        this.athletics += athletics;
    }

    /**
     * Get athletics score
     * @return score
     */
    public int getAthletics() {
        return athletics*Main.stats.getProficiency()+Main.stats.getStrengthMod();
    }

    /**
     * Set deception mod
     * @param deception mod to apply
     */
    public void setDeception(int deception) {
        this.deception += deception;
    }

    /**
     * Get deception score
     * @return score
     */
    public int getDeception() {
        return deception*Main.stats.getProficiency()+Main.stats.getCharismaMod();
    }

    /**
     * Set history mod
     * @param history mod to apply
     */
    public void setHistory(int history) {
        this.history += history;
    }

    /**
     * Get history score
     * @return score
     */
    public int getHistory() {
        return history*Main.stats.getProficiency()+Main.stats.getIntelligenceMod();
    }

    /**
     * Set insight mod
     * @param insight mod to apply
     */
    public void setInsight(int insight) {
        this.insight += insight;
    }

    /**
     * Get insight score
     * @return score
     */
    public int getInsight() {
        return insight*Main.stats.getProficiency()+Main.stats.getWisdomMod();
    }

    /**
     * Set intimidation mod
     * @param intimidation mod to apply
     */
    public void setIntimidation(int intimidation) {
        this.intimidation += intimidation;
    }

    /**
     * Get intimidation score
     * @return score
     */
    public int getIntimidation() {
        return intimidation*Main.stats.getProficiency()+Main.stats.getCharismaMod();
    }

    /**
     * Set investigation mod
     * @param investigation mod to apply
     */
    public void setInvestigation(int investigation) {
        this.investigation += investigation;
    }

    /**
     * Get investigation score
     * @return score
     */
    public int getInvestigation() {
        return investigation*Main.stats.getProficiency()+Main.stats.getIntelligenceMod();
    }

    /**
     * Set medicine mod
     * @param medicine mod to apply
     */
    public void setMedicine(int medicine) {
        this.medicine += medicine;
    }

    /**
     * Get medicine score
     * @return score
     */
    public int getMedicine() {
        return medicine*Main.stats.getProficiency()+Main.stats.getWisdomMod();
    }

    /**
     * Set nature mod
     * @param nature mod to apply
     */
    public void setNature(int nature) {
        this.nature += nature;
    }

    /**
     * Get nature score
     * @return score
     */
    public int getNature() {
        return nature*Main.stats.getProficiency()+Main.stats.getIntelligenceMod();
    }

    /**
     * Set perception mod
     * @param perception mod to apply
     */
    public void setPerception(int perception) {
        this.perception += perception;
    }

    /**
     * Get perception score
     * @return score
     */
    public int getPerception() {
        return perception*Main.stats.getProficiency()+Main.stats.getWisdomMod();
    }

    /**
     * Set performance mod
     * @param performance mod to apply
     */
    public void setPerformance(int performance) {
        this.performance += performance;
    }

    /**
     * Get performance score
     * @return score
     */
    public int getPerformance() {
        return performance*Main.stats.getProficiency()+Main.stats.getCharismaMod();
    }

    /**
     * Set persuasion mod
     * @param persuasion mod to apply
     */
    public void setPersuasion(int persuasion) {
        this.persuasion += persuasion;
    }

    /**
     * Get persuasion score
     * @return score
     */
    public int getPersuasion() {
        return persuasion*Main.stats.getProficiency()+Main.stats.getCharismaMod();
    }

    /**
     * Set religion mod
     * @param religion mod to apply
     */
    public void setReligion(int religion) {
        this.religion += religion;
    }

    /**
     * Get religion score
     * @return score
     */
    public int getReligion() {
        return religion*Main.stats.getProficiency()+Main.stats.getIntelligenceMod();
    }

    /**
     * Set slightOfHand mod
     * @param slightOfHand mod to apply
     */
    public void setSlightOfHand(int slightOfHand) {
        this.slightOfHand += slightOfHand;
    }

    /**
     * Get slightOfHand score
     * @return score
     */
    public int getSlightOfHand() {
        return slightOfHand*Main.stats.getProficiency()+Main.stats.getDexterityMod();
    }

    /**
     * Set stealth mod
     * @param stealth mod to apply
     */
    public void setStealth(int stealth) {
        this.stealth += stealth;
    }

    /**
     * Get stealth score
     * @return score
     */
    public int getStealth() {
        return stealth*Main.stats.getProficiency()+Main.stats.getDexterityMod();
    }

    /**
     * Set survival mod
     * @param survival mod to apply
     */
    public void setSurvival(int survival) {
        this.survival += survival;
    }

    /**
     * Get survival score
     * @return score
     */
    public int getSurvival() {
        return survival*Main.stats.getProficiency()+Main.stats.getWisdomMod();
    }

    /**
     * Print skills and their proficiencies to a string
     * @return string of skill prof
     */
    @Override
    public String toString() {
        return "Skill Proficiencies:" +
                "\nacrobatics: " + acrobatics +
                "\nanimalHandling: " + animalHandling +
                "\narcana: " + arcana +
                "\nathletics: " + athletics +
                "\ndeception: " + deception +
                "\nhistory: " + history +
                "\ninsight: " + insight +
                "\nintimidation: " + intimidation +
                "\ninvestigation: " + investigation +
                "\nmedicine: " + medicine +
                "\nnature: " + nature +
                "\nperception: " + perception +
                "\nperformance: " + performance +
                "\npersuasion: " + persuasion +
                "\nreligion: " + religion +
                "\nslightOfHand: " + slightOfHand +
                "\nstealth: " + stealth +
                "\nsurvival: " + survival;
    }
}
