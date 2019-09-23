package com.cursan.magiworld;

/**
 * One of the characters
 */
public class Prowler extends Character {
    public Prowler(int numberPlayer) {
        super(numberPlayer, 2);
    }

    @Override
    public void basicAttack(Character attackedPlayer) {
        attackedPlayer.vitality -= this.agility;
        System.out.println("Joueur " + this.numberPlayerOfCharacter + " utilise Tir à l'Arc et inflige " + this.agility + " dommages.");
        System.out.println("Joueur " + attackedPlayer.numberPlayerOfCharacter + " perd " + this.agility + " points de vie.");
        attackedPlayer.isDead();
    }

    @Override
    public void specificAttack(Character attackedPlayer) {
        this.agility += this.level / 2;
        System.out.println("Joueur " + this.numberPlayerOfCharacter + " utilise Concentration et gagne " + this.level / 2 + " en agilité.");
    }
}
