package assignment;

import java.util.ArrayList;

/**
 *
 * @author samundrak
 */
public class LogixChecker {

    private Player player;
    private ArrayList<Tiles> tiles;
    private int currentIndex;

    public int getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }

    public LogixChecker(Player player) {
        this.player = player;
    }

    public boolean isGameFinished() {
        Worm worm = new Worm();
        worm.setPlayer(player);
        worm.setTiles(tiles);
        worm.getSurroundings(getCurrentIndex());
        if (worm.isWormStatus()) {
            return true;
        }


        return false;

    }

    void setTiles(ArrayList<Tiles> tiles) {
        this.tiles = tiles;
    }
}
