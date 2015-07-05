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

    public LogixChecker(Player player) {
        this.player = player;
        chainCounter = 0;
    }
 
    
    public boolean isGameFinished(){
        if(horizonatalChecks()){
            return true;
        }
        
        if(verticalChecks()){
            return true;
        }
        return false;
    }

    private boolean horizonatalChecks(){
         for (int i = 0; i < Defaults.TOTAL_TILES; i++) {
             if(chainCounter == 9 ){
                 return true;
             }
              if(tiles.get(i).getName().equals(player.getName())){
                  chainCounter++;
              }else{
                  chainCounter = 0;
              }
        }
         return false;
    }
    void setTiles(ArrayList<Tiles> tiles) {
        this.tiles = tiles;
    }

    private boolean verticalChecks() {
        for (int j = 0; j < 20; j++) {
            for (int i = j; i < Defaults.TOTAL_TILES; i += 20) {
             if(chainCounter == 9 ){
                 return true;
             }
              if(tiles.get(i).getName().equals(player.getName())){
                  chainCounter++;
              }else{
                  chainCounter = 0;
              }
        }
        }
          
         return false;
    }
}

