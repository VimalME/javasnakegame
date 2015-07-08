package assignment;

import java.util.ArrayList;

/**
 *
 * @author samundrak
 */
public class LogixChecker {

    private Player player;
    private int chainCounter;
    private ArrayList<Tiles> tiles;
    private ArrayList<Integer> index;
    private int currentIndex;

    public int getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }
    public LogixChecker(Player player) {
        this.player = player;
        chainCounter = 0;
        index = new ArrayList<Integer>();
    }

    public boolean isGameFinished() {
        Worm worm = new Worm();
        worm.setPlayer(player);
        worm.setTiles(tiles);
        worm.getSurroundings(getCurrentIndex()); 
        if(worm.isWormStatus()) return true;
        
        
        return false;
//        if (horizonatalChecks()) {
//            return true;
//        }
//
//        if (verticalChecks()) {
//            return true;
//        }
//
//        if (zigzagChecks()) {
//            return true;
//        }
//        index.clear();
//
//        if (crossChecker(true)) {
//            return true;
//        }
//        index.clear();
//
//        if (crossChecker(false)) {
//            return true;
//        }
//        index.clear();
//
//        return false;
    }

    private boolean crossChecker(boolean ahead) {
        for (int i = 0; i < Defaults.TOTAL_TILES; i++) {

            if (tiles.get(i).getName().equals(player.getName())) {
                index.add(i);
                try {
                    boolean cross = cross(i, ahead);
                    if (cross) {
                        return true;
                    }



                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Found and Impressive index out of bound exception so i catched it");
                    index.clear();
                    continue;
                }

 
            }
        }
        return false;
    }

    private boolean horizonatalChecks() {
        for (int i = 0; i < Defaults.TOTAL_TILES; i++) {
            if (chainCounter == Defaults.CHAIN_COUNTER) {
                chainCounter = 0;
                return true;
            }
            if (tiles.get(i).getName().equals(player.getName())) {
                chainCounter++;
            } else {
                chainCounter = 0;

            }
        }
        return false;
    }

    private boolean zigzagChecks() {
        for (int i = 0; i < Defaults.TOTAL_TILES; i++) {

            if (tiles.get(i).getName().equals(player.getName())) {
                index.add(i);
                try {
                    boolean zig = zig(i, true);
                    if (zig) {
                        return true;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Found and Impressive index out of bound exception so i catched it");
                    index.clear();
                    continue;
                }

            }
        }


        return false;
    }

    void setTiles(ArrayList<Tiles> tiles) {
        this.tiles = tiles;
    }

    boolean zig(int found, boolean b) throws ArrayIndexOutOfBoundsException {

        if (index.size() >= Defaults.CHAIN_COUNTER) {
            for (int i = 0; i < index.size(); i++) {
                if (tiles.get(index.get(i)).getName().equals(player.getName())) {

                    if (chainCounter >= Defaults.CHAIN_COUNTER) {
                        return true;
                    }

                    chainCounter++;
                } else {
                    chainCounter = 0;
                    index.clear();
                    return false;
                }
            }
        }
        boolean now;
        int top;

        if (b) {
            //Checks up side
            top = found - 20;
            top = top + 1;
            now = false;
        } else {
            //Checks Down side
            top = found + 21;
            now = true;
        }
        index.add(top);
        zig(top, now);

        return false;


    }

    private boolean verticalChecks() {
        for (int j = 0; j < 20; j++) {
            for (int i = j; i < Defaults.TOTAL_TILES; i += 20) {
                if (chainCounter == Defaults.CHAIN_COUNTER) {
                    chainCounter = 0;
                    return true;
                }
                if (tiles.get(i).getName().equals(player.getName())) {
                    chainCounter++;
                } else {
                    chainCounter = 0;
                }
            }
        }

        return false;
    }

    private boolean cross(int found, boolean ahead) {
        if (index.size() >= Defaults.CHAIN_COUNTER) {
            for (int i = 0; i < index.size(); i++) {
                if (tiles.get(index.get(i)).getName().equals(player.getName())) {

                    if (chainCounter >= Defaults.CHAIN_COUNTER) {
                        return true;
                    }

                    chainCounter++;
                } else {
                    chainCounter = 0;
                    index.clear();
                    return false;
                }
            }
            return false;
        }

        if (ahead) {
            found = found + 21;

        } else {
            found = found + 19;
        }
        index.add(found);
        cross(found, ahead);

        return false;
    }
    
    private int[] checksX(int x){
        int top,left,bottom,right,topLeft,topRight,bottomLeft,bottomRight;
        top = x - 20;
        topRight = x - 19;
        right =  x + 1;
        bottomRight = x + 21;
        bottom = x + 20;
        bottomLeft = x + 19;
        left = x - 1;
        topLeft = x - 21;
        int[] i =  {top,left,bottom,right,topLeft,topRight,bottomLeft,bottomRight};
        return i;
    }
}
