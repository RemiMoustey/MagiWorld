package com.cursan.magiworld;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Implements the beginning of the game
 */
public abstract class Character {
    protected int numberPlayerOfCharacter;
    protected int level = 1;
    protected int strength = 0;
    protected int agility = 0;
    protected int intelligence = 0;
    protected int vitality;
    protected int vitalityAtBeginning; // For Sorcerers.
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
            numberPlayerOfCharacter = numberPlayer;
            sloganCharacter = sloganCharacter(numberCharacter);
            classCharacter = classCharacter(numberCharacter);
            if (strength + intelligence + agility != level) {
                System.out.println("Le niveau du personnage doit être égal à la somme de ses caractéristiques.");
            }
        } while(strength + intelligence + agility != level);
        vitality = level * 5;
        vitalityAtBeginning = vitality;
        System.out.println(sloganCharacter + " je suis le " + classCharacter + " Joueur " + numberPlayer + " niveau " + level + " je possède " + vitality + " de vitalité, " + strength + " de force, " + agility + " d'agilité et " + intelligence + " d'intelligence !");
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
            } catch (NumberFormatException e) {
                System.err.println("La saisie doit être un nombre entier");
                System.exit(1);
                catchChoiceUser(min, max, field);
            }
            if (choice < min || choice > max) {
                String printedText = (field == "attack") ? "Veuillez saisir 1 (attaque basique) ou 2 (attaque spéciale)" : "Votre " + field + " doit être entre " + min + " et " + max + ". Recommencez !";
                System.out.println(printedText);
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
        level = catchChoiceUser(boundsLevel[0], boundsLevel[1], "niveau");
        int boundsOtherFeatures[] = choiceFeature("");
        System.out.println("Force du personnage ? ");
        strength = catchChoiceUser(boundsOtherFeatures[0], boundsOtherFeatures[1], "force");
        System.out.println("Agilité du personnage ? ");
        agility = catchChoiceUser(boundsOtherFeatures[0], boundsOtherFeatures[1], "agilité");
        System.out.println("Intelligence du personnage ? ");
        intelligence = catchChoiceUser(boundsOtherFeatures[0], boundsOtherFeatures[1], "intelligence");
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

    public void isDead() {
        if (this.vitality <= 0)
            System.out.println("Joueur " + this.numberPlayerOfCharacter + " est mort.");
    }

    public abstract void basicAttack(Character attackedPlayer);
    public abstract void specificAttack(Character attackedPlayer);
}
