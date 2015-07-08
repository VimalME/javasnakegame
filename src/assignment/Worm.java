package assignment;

import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author Samundra kc <samundrak@yahoo.com>
 * Email: Samundrak@yahoo.com
 */
public class Worm {
    
    private ArrayList<Integer> checkedIndex;
    private ArrayList<Tiles> tiles;
    private Player player;
    private HashSet<Integer> nextIndex;
    private int loopCounter;
    private boolean wormStatus =  false;

    public boolean isWormStatus() {
        return wormStatus;
    }

    public void setWormStatus(boolean wormStatus) {
        this.wormStatus = wormStatus;
    }
    
    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setTiles(ArrayList<Tiles> tiles) {
        this.tiles = tiles;
    }
    
    public Worm() {
           checkedIndex = new ArrayList<Integer>();
           nextIndex =  new HashSet<Integer>();
           loopCounter = 0;
    }
    
    
    public boolean getSurroundings(int x){
        System.out.println(nextIndex.toString());
        System.out.println(nextIndex.size());
        if(nextIndex.size() ==  Defaults.CHAIN_COUNTER) {
            setWormStatus(true);
            return true;
        }
        
        if(loopCounter > ( Defaults.TOTAL_TILES - 1) || loopCounter < 0) return false;
        
        System.out.println("hy");
        if(!checkedIndex.contains(x)){
            checkedIndex.add(x);
           int[] coo =  Defaults.getSideCordinates(x);
            for (int i = 0; i < coo.length; i++) {
                try{
                if(tiles.get(coo[i]).getName().equals(player.getName())){
                    nextIndex.add(coo[i]);
                    getSurroundings(coo[i]);
                }
                }catch(ArrayIndexOutOfBoundsException e){
                    continue;
//                    return false;
                }
                catch(IndexOutOfBoundsException e){
                    continue;
//                    return false;
                }
            }
        }
        return false;
    }
    
    
     
}
