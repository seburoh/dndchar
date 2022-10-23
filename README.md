# Archived Project

This is a previously completed academic project which is not currently supported.

# D&D Character Creator Mini-Tool
This project is designed to help users quickly put together a D&D character. It handles all the associated number crunching, only requiring the user to follow along with the prompts and have the Character Creation rules handy.

# Requirements
Any system capable of running Java programs (Windows, Mac, Linux, etc), with the JDK tools installed, available for free from [Oracle](https://www.oracle.com/java/technologies/downloads/#jdk17-windows). In addition, the foundational rulebooks for D&D are required, as the program does not disclose copyrighted material where possible, requiring the user to choose their character's abilities from the book itself, to type in manually.

# To use
Running the Main.class file from the /src directory is all that is required. You can do so by running the following command from your respective CLI, ran from within the /src folder:
>java Main

The program will deposit a "CompleteCharacter.txt" file in its main directory when successfully run, which has all the information generated for the character. An example file is already in place, to show what kind of output to expect. When run, the program will overwrite the existing file with your new creation.

# Example Usage
From a supported CLI (Windows Command Prompt, Linux Terminal), run the following command from within the /src folder:
>java Main < test.txt

You can also do this test manually by opening test.txt in your text editor of choice, and inputting the commands manually while the program is running normally, should your CLI not support the automated testing method. Example output:

<center><img src="https://cdn.discordapp.com/attachments/149944536871731200/916223291616813096/unknown.png" alt="example output" /></center>

# Limitations

Currently, this program does not allow for inputting of Spells or tracking of Spell Slots. Inputting Spells as Features is a valid workaround, though tracking Spell Slots needs to be looked up from the handbook itself.

# Future Possibilities

The backend for handling character information is above the scope of what the main prompts require. They are set up to be easily adaptable to more scenarios and possibilities, such as updating a character beyond level 1.

# Included Files/Design

* Main
  * Main method for program, controls runtime and user prompts, creating a Character based on multiple objects generated through the additional files.
* Skill
  * Handles Skill Proficiencies of a Character. Includes methods to set and get all relevant information, as well as print its contents to a string.
* Stat
  * Handles Statistics of a Character, such as Health, Strength, and Initiative.Includes methods to set and get all relevant information, as well as print its contents to a string.
* CharacterStrings
  * Handles aspects of a Character which are wholly role-play, such as Name, Height, and Backstory. Includes methods to set and get all relevant information, as well as print its contents to a string.
* Inventory
  * Structure for holding a Character's items within a TreeSet. Includes methods for searching, adding, and removing from an inventory, checking the weight of the inventory, as well as printing the contents of an inventory to a string.
* Item
  * Handles construction of Item objects to go inside a Character's inventory. Includes methods to set and get all relevant information, as well as print items to a string and compare them based on their name.
* ItemComparator
  * Allows for Items to be compared by their name, to assist in checking for duplicates.

# Development Resources
1. [Comparators](https://www.java2novice.com/java-collections-and-util/treeset/comparator-object/) - To refresh on custom comparator syntax.
2. [File Handling](https://stackoverflow.com/questions/2885173/how-do-i-create-a-file-and-write-to-it) - File handling with try/catch and Buffer.