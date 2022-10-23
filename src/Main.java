import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * @author seburoh
 * </br> Final Project: D&D Character Creator
 */

public class Main {

    public static CharacterStrings player;
    public static Inventory inv;
    public static Scanner console = new Scanner(System.in);
    public static Stat stats;
    public static Skill skills;

    public static void main(String[] args) {
        createStrings();
        createInventory();
        createStats();
        createMoreStats();
        createSkills();

        printPlayer();
        printToFile();
    }

    public static void createSkills(){
        clearScreen();

        skills = new Skill();
        boolean notdone = true; //tracker for while loop
        Stack<Integer> choices = new Stack<>(); //holder for prof choices
        String input;

        System.out.println("""
                Pick Skill Proficiencies by entering their numbers one at a time, type DONE to quit:
                1.acrobatics
                2.animalHandling
                3.arcana
                4.athletics
                5.deception
                6.history
                7.insight
                8.intimidation
                9.investigation
                10.medicine
                11.nature
                12.perception
                13.performance
                14.persuasion
                15.religion
                16.slightOfHand
                17.stealth
                18.survival""");

        System.out.print("Skill: ");

        while (notdone){
            input = console.nextLine();

            if (!input.equalsIgnoreCase("done")){ //not done?
                try {
                    choices.push(Integer.parseInt(input)); //make sure it's an int
                    if (choices.peek() < 1 || choices.peek() > 18){ //is it an int we like?
                        choices.pop(); //remove it
                        throw new IllegalArgumentException("Not a valid number");
                    }
                    System.out.print("Next: "); //all clear, lets move on
                }
                catch (InputMismatchException IME){
                    System.out.println("That's not a number!");
                }catch (IllegalArgumentException IAE){
                    System.out.println("Not a valid number!");
                    System.out.print("Next: ");
                }
            }

            else { //we out
                notdone = false;
            }
        }

        while (!choices.isEmpty()){ //and rip it into skills
            if (choices.peek() == 1){
                skills.setAcrobatics(1);
            }
            if (choices.peek() == 2){
                skills.setAnimalHandling(1);
            }
            if (choices.peek() == 3){
                skills.setArcana(1);
            }
            if (choices.peek() == 4){
                skills.setAthletics(1);
            }
            if (choices.peek() == 5){
                skills.setDeception(1);
            }
            if (choices.peek() == 6){
                skills.setHistory(1);
            }
            if (choices.peek() == 7){
                skills.setInsight(1);
            }
            if (choices.peek() == 8){
                skills.setIntimidation(1);
            }
            if (choices.peek() == 9){
                skills.setInvestigation(1);
            }
            if (choices.peek() == 10){
                skills.setMedicine(1);
            }
            if (choices.peek() == 11){
                skills.setNature(1);
            }
            if (choices.peek() == 12){
                skills.setPerception(1);
            }
            if (choices.peek() == 13){
                skills.setPerformance(1);
            }
            if (choices.peek() == 14){
                skills.setPersuasion(1);
            }
            if (choices.peek() == 15){
                skills.setReligion(1);
            }
            if (choices.peek() == 16){
                skills.setSlightOfHand(1);
            }
            if (choices.peek() == 17){
                skills.setStealth(1);
            }
            if (choices.peek() == 18){
                skills.setSurvival(1);
            }
            choices.pop(); //pop it to check the next
        }

    }

    /**
     * Create Character Step: Stats Part 2
     * </br>Sets up: maxhealth,speed,hitdice
     */
    public static void createMoreStats() {
        clearScreen();

        boolean notdone = true;
        String input;

        while (notdone) {
            try {
                System.out.print("Hit Dice: ");
                stats.setHitDice(console.nextLine());

                System.out.print("Speed (normally 30): ");
                input = console.nextLine();
                stats.setSpeed(Integer.parseInt(input));

                System.out.print("Max Health: ");
                input = console.nextLine();
                stats.setMaxHealth(Integer.parseInt(input));
                stats.setHealth(Integer.parseInt(input));
                if (stats.getHealth() < 0){
                    throw new IllegalArgumentException("Don't start the game dead");
                }

                notdone = false;

            } catch (IllegalArgumentException IAE) {
                System.out.println("Could not add!");
            } catch (InputMismatchException ITM) {
                System.out.println("Wrong type of input!");
            }
        }
    }

    /**
     * Create Character Step: Stats Part 1
     * </br>Sets up: {"STR","DEX","CON","INT","WIS","CHA"}
     */
    public static void createStats() {
        clearScreen();

        stats = new Stat(); //initialize stats Object
        ArrayList<Integer> rollList = new ArrayList<>(); //place to put dice rolls
        String[] statName = {"STR","DEX","CON","INT","WIS","CHA"}; //names
        int count = 0; //control for while loop, and which stat is being dealt with
        Queue<Integer> rolls = new LinkedList<>(); //storing order of player chosen rolls

        for (int i = 0; i < 6; i++) { //roll dice
            rollList.add(rollDice(4,6,1));
        }

        while (count < 6){ //understand where user wants to place stats
            System.out.println("For primary stats, you've rolled:");
            int choice = 0; //what roll choice the user makes

            for (int i = 0; i < rollList.size(); i++) {
                System.out.println((i+1) + ": " + rollList.get(i)); //print the rolls
            }

            System.out.println("What roll # do you want to use for "+statName[count]);
            try {
                choice = Integer.parseInt(console.nextLine()); //take choice safely
            }catch (IllegalArgumentException IAE){
                System.out.println("That's not a number!");
            }
            if (choice < 1 || choice > rollList.size()){ //did choice fit in expected limits?
                System.out.println("That's not a choice!");
            }else {
                rolls.add(rollList.get(choice-1)); //store choice in order
                rollList.remove(choice-1);//remove chosen roll
                count++; //increase counter
            }
        }

        stats.setRolledStrength(rolls.poll());
        stats.setRolledDexterity(rolls.poll());
        stats.setRolledConstitution(rolls.poll());
        stats.setRolledIntelligence(rolls.poll());
        stats.setRolledWisdom(rolls.poll());
        stats.setRolledCharisma(rolls.poll());

    }

    /**
     * Easier rollDice for when no drop is needed
     * @param count amount of dice
     * @param sides amount of sides
     * @return sum
     */
    public static int rollDice(int count, int sides){
        return rollDice(count,sides,0);
    }

    /**
     * Ability to see dice rolls to understand the math works
     * @param pq dice rolls to check
     */
    private static void debugDice(PriorityQueue<Integer> pq){
        Object[] check = pq.toArray(); //let's not destroy the PQ

        System.out.print("debugDice: ");

        for (Object e:check) { //don't care the order, just need to know
            System.out.print(e + " ");
        }

        System.out.print("\n"); //for cleanliness
    }

    /**
     * Roll set amount of specified dice, drop lowest roll(s) as desired
     * @param count amount of dice
     * @param sides amount of sides
     * @param drop amount to drop
     * @return sum of non-dropped
     */
    public static int rollDice(int count, int sides, int drop){
        Random rand = new Random();
        PriorityQueue<Integer> rolled = new PriorityQueue<>(); //rolled dice
        int sum = 0;

        for (int i = 0; i < count; i++) { //roll dice
            rolled.add(rand.nextInt(sides)+1); //turn (ex)0-5 rand into 1-6 result
        }

        //debugDice(rolled);

        for (int i = 0; i < drop; i++) { //drop low dice
            rolled.remove();
        }

        //debugDice(rolled);

        while (!rolled.isEmpty()){ //build sum
            sum += rolled.poll();
        }

        return sum;
    }

    /**
     * Create Character Step: Inventory
     */
    public static void createInventory(){
        inv = new Inventory(); //create inventory
        String name = ""; //create item variables
        double weight;
        String desc;
        int amount;
        ArrayList<Item> items = new ArrayList<>();
        int i = 0;

        String weightS; //storage for these to allow for console.nextline()
        String amountS;

        while (!name.equalsIgnoreCase("done")) { //create items
            try {
                System.out.println("[Add Items to Inventory, type DONE to stop]");
                System.out.print("Name: ");
                name = console.nextLine();
                if (!name.equalsIgnoreCase("done")) { //if we know we're leaving don't bother with the rest
                    System.out.print("Weight: ");
                    //weight = console.nextDouble();
                    weightS = console.nextLine(); //it was doubling up, now it doesn't
                    weight = Double.parseDouble(weightS);
                    System.out.print("Description: ");
                    desc = console.nextLine();
                    System.out.print("Amount: ");
                    //amount = console.nextInt();
                    amountS = console.nextLine(); //it just works -todd howard
                    amount = Integer.parseInt(amountS);
                    items.add(i++, new Item(name, weight, desc, amount)); //create list of items to add
                }
            } catch (IllegalArgumentException IAE) {
                System.out.println("Could not add item!");
            } catch (InputMismatchException ITM) {
                System.out.println("Wrong type of input!");
            }
        }

        if (!items.isEmpty()){ //dump list of items into Inventory
            for (Item it:items) { //put each item into inventory
                try { //carefully
                    inv.addItem(it);
                }catch (IllegalArgumentException IAE){ //duplicate found
                    System.out.println("Duplicate item not added: " + it.getName());
                }
            }

        }

    }

    /**
     * Create Character Step: Strings
     */
    public static void createStrings(){

        boolean notdone = true;

        while (notdone) {
            try {
                System.out.print("Character name: "); //Prompt for String
                String str = console.nextLine(); //Take it in
                player = new CharacterStrings(str); //Set it

                System.out.print("Class: "); //Repeat
                str = console.nextLine();
                player.setcClass(str);

                System.out.print("Background: ");
                str = console.nextLine();
                player.setBackground(str);

                System.out.print("Race: ");
                str = console.nextLine();
                player.setRace(str);

                System.out.print("Alignment: ");
                str = console.nextLine();
                player.setAlignment(str);

                System.out.print("Age: ");
                str = console.nextLine();
                player.setAge(str);

                System.out.print("Height: ");
                str = console.nextLine();
                player.setHeight(str);

                System.out.print("Weight: ");
                str = console.nextLine();
                player.setWeight(str);

                System.out.print("Eye Color: ");
                str = console.nextLine();
                player.setEyeColor(str);

                System.out.print("Skin Color: ");
                str = console.nextLine();
                player.setSkinColor(str);

                System.out.print("Hair Color: ");
                str = console.nextLine();
                player.setHairColor(str);

                System.out.print("Backstory: "); //TIMETODUEL
                str = console.nextLine();
                player.setBackstory(str);

                System.out.print("[type DONE to stop adding more]");
                System.out.print("\nProficiency: ");
                str = console.nextLine();
                player.addProficiencies(str);

                while (!str.equalsIgnoreCase("done")){ //Are we done?
                    System.out.print("Proficiency: ");
                    str = console.nextLine();

                    if (!str.equalsIgnoreCase("done")){ //"Done" is not a prof
                        player.addProficiencies(str);
                    }

                }

                System.out.print("[type DONE in the Name field to stop adding more]");
                System.out.print("\nFeatures: ");
                System.out.print("\nFeature Name: ");
                str = console.nextLine();
                System.out.print("Feature Description: ");
                String desc = console.nextLine();
                player.addFeature(str,desc);

                while (!str.equalsIgnoreCase("done")){ //only check the first done
                    System.out.print("\nFeature Name: ");
                    str = console.nextLine();
                    if (!str.equalsIgnoreCase("done")){ //no descriptions on quit
                        System.out.print("Feature Description: ");
                        desc = console.nextLine();
                        player.addFeature(str,desc); //no add on quit
                    }
                }

                notdone = false;

            } catch (IllegalArgumentException IAE) {
                System.out.println("Could not add!");
            } catch (InputMismatchException ITM) {
                System.out.println("Wrong type of input!");
            }
        }
    }

    /**
     * Print player as complete package
     */
    public static void printPlayer(){
        System.out.println(player.toString());
        System.out.println(stats.toString());
        System.out.println("\n" + skills.toString());
        System.out.println("\nInventory:\n" + inv.toString() + "\nTotal Weight: " + inv.getWeight());
    }

    /**
     * Print completed character to file
     */
    public static void printToFile() {

        //BufferedWriter output = null;

        try (FileOutputStream file = new FileOutputStream("CompleteCharacter.txt")){ //generate file
            //File file = new File("CompleteCharacter.txt");
/*

            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }


            //output = new BufferedWriter(new FileWriter(file));

            output.write("text");
            output.write(player.toString());
*/

            file.write(player.toString().getBytes(StandardCharsets.UTF_8)); //write stuff
            file.write(stats.toString().getBytes(StandardCharsets.UTF_8));
            file.write(("\n" + skills.toString()).getBytes(StandardCharsets.UTF_8));
            file.write(("\nInventory:\n" + inv.toString() + "\nTotal Weight: " + inv.getWeight()).getBytes(StandardCharsets.UTF_8));

        } catch (IOException e) {
            e.printStackTrace();
        } finally { //make sure user knows we did it!
            System.out.println("File created successfully");
        }
        /*finally {
            if ( output != null ) {
                output.close();
            }
        }*/
    }

    /**
     * Clears the terminal by invoking the environment's clear command.
     * Differs between Windows and Unix
     *
     * @see <a href="https://stackoverflow.com/questions/2979383/java-clear-the-console">java clear the console</a>
     */
    public static void clearScreen() {
        try{//windows
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch(Exception e){//mac and linux
            try{
                String term = System.getenv("TERM"); // https://docs.oracle.com/javase/8/docs/api/java/lang/System.html#getenv-java.lang.String-
                if(term != null && !term.equals("dumb")){
                    new ProcessBuilder("clear").inheritIO().start().waitFor();
                }
            }catch(Exception ignored){}
        }
    }
}
