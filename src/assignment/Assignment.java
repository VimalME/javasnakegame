package assignment;

import java.util.ArrayList;

/**
 *
 * @author samundrak
 */
public class Assignment {

    static ArrayList<Integer> index = new ArrayList<Integer>();

    public static void main(String[] args) {

        try {
            Arena arena = new Arena();
            arena.init().initPlayer().setPlayerName();
            arena.initTiles();
            arena.setHUD();
            arena.setVisible(true);
        } catch (NullPointerException e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Game exited");
        }
    }
}
