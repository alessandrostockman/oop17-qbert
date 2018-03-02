package qbert.launcher;

import qbert.controller.GameEngine;

/**
 * The class used to launch the game.
 */
public final class QBertLauncher {

    private QBertLauncher() {

    }

    /** 
     * The main method for the game launcher. 
     * @param args the parameters passed by command line.
     */
    public static void main(final String[] args) {
        GameEngine test = new GameEngine();
        test.setup();
        //test.mainLoop();
    }
}
