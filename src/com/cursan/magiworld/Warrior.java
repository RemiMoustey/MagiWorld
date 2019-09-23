package com.cursan.magiworld;

public class Warrior extends Character {

    public Warrior(int numberPlayer) {
        super(numberPlayer, 1);
    }

    @Override
    public void basicAttack(Character attackedPlayer) {
        attackedPlayer.vitality -= this.strength;
        System.out.println("Joueur " + this.numberPlayerOfCharacter + " utilise Coup d'Épée et inflige " + this.strength + " dommages.");
        System.out.println("Joueur " + attackedPlayer.numberPlayerOfCharacter + " perd " + this.strength + " points de vie.");
        attackedPlayer.isDead();
    }

    @Override
    public void specificAttack(Character attackedPlayer) {
        attackedPlayer.vitality -= 2 * this.strength;
        this.vitality -= this.strength / 2;
        System.out.println("Joueur " + this.numberPlayerOfCharacter + " utilise Coup de Rage et inflige " + 2 * this.strength + " dommages.");
        System.out.println("Joueur " + attackedPlayer.numberPlayerOfCharacter + " perd " + 2 * this.strength + " points de vie.");
        attackedPlayer.isDead();
        System.out.println("Joueur " + this.numberPlayerOfCharacter + " perd " + this.strength / 2 + " points de vie.");
        this.isDead();
    }
}
