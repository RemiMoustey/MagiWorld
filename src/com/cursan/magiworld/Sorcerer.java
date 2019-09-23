package com.cursan.magiworld;

public class Sorcerer extends Character {

    public Sorcerer(int numberPlayer) {
        super(numberPlayer, 3);
    }

    @Override
    public void basicAttack(Character attackedPlayer) {
        attackedPlayer.vitality -= this.intelligence;
        System.out.println("Joueur " + this.numberPlayerOfCharacter + " utilise Boule de Feu et inflige " + this.intelligence + " dommages.");
        System.out.println("Joueur " + attackedPlayer.numberPlayerOfCharacter + " perd " + this.intelligence + " points de vie.");
        attackedPlayer.isDead();
    }

    @Override
    public void specificAttack(Character attackedPlayer) {
        if (this.vitality + 2 * this.intelligence < this.vitalityAtBeginning) {
            this.vitality += 2 * this.intelligence;
            System.out.println("Joueur " + this.numberPlayerOfCharacter + " utilise Soin et gagne " + 2 * this.intelligence + " en vitalité.");
        }
        else {
            System.out.println("Joueur " + this.numberPlayerOfCharacter + " utilise Soin et gagne " + (this.vitalityAtBeginning - this.vitality) + " en vitalité.");
            this.vitality = this.vitalityAtBeginning;
        }
    }
}
