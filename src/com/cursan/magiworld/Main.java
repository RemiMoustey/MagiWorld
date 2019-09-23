package com.cursan.magiworld;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    /**
     * Returns the user's input (his character's choice)
     *
     * @return
     */
    public static int choiceCharacter(int numberPlayer) {
        int choice = 0;
        System.out.println("Création du personnage du Joueur " + numberPlayer);
        System.out.println("Veuillez choisir la classe de votre personnage (1 : Guerrier, 2 : Rôdeur, 3 : Mage)");
        do {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.next();
            try {
                choice = Integer.parseInt(input);
            } catch (InputMismatchException e) {
                System.err.println("Le nombre saisi doit être entier");
                System.exit(1);
                choiceCharacter(numberPlayer);
            }
            if (choice < 1 || choice > 3) {
                System.out.println("Veuillez entrer un nombre compris entre 1 et 3");
            }
        } while (choice < 1 || choice > 3);
        return choice;
    }

    public static Character buildCharacterWithClass(int choiceUser, int numberPlayer) {
        switch(choiceUser) {
            case 1:
                return new Warrior(numberPlayer);
            case 2:
                return new Prowler(numberPlayer);
            case 3:
                return new Mage(numberPlayer);
            default:
                throw new IllegalArgumentException("Le numéro du personnage doit être entier et compris entre 1 et 3");
        }
    }

    public static void main(String[] args) {
        int choiceUser1 = choiceCharacter(1);
        Character player1 = buildCharacterWithClass(choiceUser1, 1);
        int choiceUser2 = choiceCharacter(2);
        Character player2 = buildCharacterWithClass(choiceUser2, 2);
    }
}
