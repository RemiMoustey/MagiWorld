package com.cursan.magiworld;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
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

    public static void roundPlayer(Character player, Character attackedPlayer) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Joueur " + player.numberPlayerOfCharacter + " (" + player.vitality + " vitalité) veuillez choisir votre action (1 : Action Basique, 2 : Attaque Spéciale).");
        int attack = player.catchChoiceUser(1, 2, "attack");
        if (attack == 1) {
            player.basicAttack(attackedPlayer);
        }
        else if (attack == 2) {
            player.specificAttack(attackedPlayer);
        }
    }

    public static void main(String[] args) {
        int choiceUser1 = choiceCharacter(1);
        Character player1 = buildCharacterWithClass(choiceUser1, 1);
        int choiceUser2 = choiceCharacter(2);
        Character player2 = buildCharacterWithClass(choiceUser2, 2);
        do {
            if (player1.vitality > 0) {
                roundPlayer(player1, player2);
            }
            if (player2.vitality > 0) {
                roundPlayer(player2, player1);
            }
        } while (player1.vitality > 0 && player2.vitality > 0);
        if (player1.vitality <= 0) {
            System.out.println("Joueur 1 a perdu !");
        } else if (player2.vitality <= 0) {
            System.out.println("Joueur 2 a perdu !");
        }
    }
}