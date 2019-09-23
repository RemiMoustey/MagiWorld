package com.cursan.magiworld;

/**
 * Implements the rounds of the game
 */
public class Game {

    /**
     * Allows proceedings of the game.
     */
    public Game(Character player1, Character player2) {
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

    /**
     * Implements ont round of the game
     *
     * @param player
     *              The player who plays
     * @param attackedPlayer
     *              The player who could be attacked
     */
    public static void roundPlayer(Character player, Character attackedPlayer) {
        System.out.println("Joueur " + player.numberPlayerOfCharacter + " (" + player.vitality + " vitalité) veuillez choisir votre action (1 : Action Basique, 2 : Attaque Spéciale).");
        int attack = player.catchChoiceUser(1, 2, "attack");
        if (attack == 1) {
            player.basicAttack(attackedPlayer);
        }
        else if (attack == 2) {
            player.specificAttack(attackedPlayer);
        }
    }
}
