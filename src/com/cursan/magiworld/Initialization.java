package com.cursan.magiworld;

/**
 * Initializes the characters at the beginning of the game
 */
public class Initialization {
    private Character player1;
    private Character player2;

    public Initialization() {
        player1 = buildCharacterWithClass(choiceCharacter(1), 1);
        player2 = buildCharacterWithClass(choiceCharacter(2), 2);
    }

    /**
     * Returns the user's input (his character's choice)
     *
     * @return
     *              The user's choice
     */
    public static int choiceCharacter(int numberPlayer) {

        System.out.println("Création du personnage du Joueur " + numberPlayer);
        System.out.println("Veuillez choisir la classe de votre personnage (1 : Guerrier, 2 : Rôdeur, 3 : Mage)");
        return Character.catchChoiceUser(1, 3, "numéro de personnage");
    }

    /**
     * Build the select character by calling a constructor
     *
     * @param choiceUser
     *              The user's choice
     * @param numberPlayer
     *              Player 1 or player 2
     *
     * @return
     *              The select character
     */
    public static Character buildCharacterWithClass(int choiceUser, int numberPlayer) {
        switch(choiceUser) {
            case 1:
                return new Warrior(numberPlayer);
            case 2:
                return new Prowler(numberPlayer);
            case 3:
                return new Sorcerer(numberPlayer);
            default:
                throw new IllegalArgumentException("Le numéro du personnage doit être entier et compris entre 1 et 3");
        }
    }

    public Character getPlayer1() {
        return player1;
    }

    public Character getPlayer2() {
        return player2;
    }
}
