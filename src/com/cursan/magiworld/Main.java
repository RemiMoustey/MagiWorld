package com.cursan.magiworld;

public class Main {

    /**
     * Executes the game
     *
     * @param args
     */
    public static void main(String[] args) {
        Initialization initializedGame = new Initialization();
        new Game(initializedGame.getPlayer1(), initializedGame.getPlayer2());
    }
}