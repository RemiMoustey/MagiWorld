package com.cursan.magiworld;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Implements the beginning of the game
 */
public abstract class Character {
    protected int choiceLevel = 1;
    protected int choiceStrength = 0;
    protected int choiceAgility = 0;
    protected int choiceIntelligence = 0;
    protected int vitality;
    protected String sloganCharacter;
    protected String classCharacter;

    /**
     * Constructor of the class which gives the characters' characteristics
     *
     * @param numberPlayer
     *              Player one or player 2
     */
    public Character(int numberPlayer, int numberCharacter) {
        do {
            // Creation characters
            choiceFeatures();
            sloganCharacter = sloganCharacter(numberCharacter);
            classCharacter = classCharacter(numberCharacter);
            if (choiceStrength + choiceIntelligence + choiceAgility != choiceLevel) {
                System.out.println("Le niveau du personnage doit être égal à la somme de ses caractéristiques.");
            }
        } while(choiceStrength + choiceIntelligence + choiceAgility != choiceLevel);
        vitality = choiceLevel * 5;
        System.out.println(sloganCharacter + " je suis le " + classCharacter + " " + numberPlayer + " niveau " + choiceLevel + " je possède " + vitality + " de vitalité, " + choiceStrength + " de force, " + choiceAgility + " d'agilité et " + choiceIntelligence + " d'intelligence !\n");
    }

    /**
     * Returns the user's input (his choice)
     *
     * @param min
     *              The min bound
     * @param max
     *              The max bound
     * @param field
     *              The field of the class
     * @return
     */
    public static int catchChoiceUser(int min, int max, String field) {
        int choice = 0;
        do {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.next();
            try {
                choice = Integer.parseInt(input);
            } catch (InputMismatchException e) {
                System.err.println("Le nombre saisi doit être entier");
                System.exit(1);
                catchChoiceUser(min, max, field);
            }
            if (choice < min || choice > max) {
                System.out.println("Votre " + field + " doit être entre " + min + " et " + max + ". Recommencez !");
            }
        } while (choice < min || choice > max);
        return choice;
    }

    /**
     * Returns the bounds according to the feature
     *
     * @param feature
     *              Name of the characteristic
     *
     * @return
     *              Array of integers (the bounds)
     */
    public static int[] choiceFeature(String feature) {
        int bounds[] = new int[2];
        if (feature == "level") {
            bounds[0] = 1;
            bounds[1] = 100;
        } else {
            bounds[0] = 0;
            bounds[1] = 100;
        }
        return bounds;
    }

    /**
     * Defines the features of the character according to the user's choices
     */
    public void choiceFeatures() {
        System.out.println("Niveau du personnage ? ");
        int[] boundsLevel = choiceFeature("level");
        this.choiceLevel = catchChoiceUser(boundsLevel[0], boundsLevel[1], "niveau");
        int boundsOtherFeatures[] = choiceFeature("");
        System.out.println("Force du personnage ? ");
        this.choiceStrength = catchChoiceUser(boundsOtherFeatures[0], boundsOtherFeatures[1], "force");
        System.out.println("Agilité du personnage ? ");
        this.choiceAgility = catchChoiceUser(boundsOtherFeatures[0], boundsOtherFeatures[1], "agilité");
        System.out.println("Intelligence du personnage ? ");
        this.choiceIntelligence = catchChoiceUser(boundsOtherFeatures[0], boundsOtherFeatures[1], "intelligence");
    }

    /**
     *
     *
     * @param numberOfCharacter
     *              Player one or player 2
     * @return
     *              The slogan of the character
     */
    public static String sloganCharacter(int numberOfCharacter) {
        String slogan = "";
        if (numberOfCharacter == 1)
            slogan = "Woarg";
        else if (numberOfCharacter == 2)
            slogan = "Hahaha";
        else if (numberOfCharacter == 3)
            slogan = "Abracadabra";
        return slogan;
    }

    /**
     *
     *
     * @param numberOfCharacter
     *              Player one or player 2
     * @return
     *              The class of the character
     */
    public static String classCharacter(int numberOfCharacter) {
        String classPersonnage = "";
        if (numberOfCharacter == 1)
            classPersonnage = "Guerrier";
        else if (numberOfCharacter == 2)
            classPersonnage = "Rôdeur";
        else if (numberOfCharacter == 3)
            classPersonnage = "Mage";
        return classPersonnage;
    }
}
