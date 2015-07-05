package assignment;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author samundrak
 */
public class Assignment {
static ArrayList<Integer> index = new ArrayList<Integer>();
    
    public static void main(String[] args) {
//       index.add(9);
//        cross(9,true);
//        
             
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
    
    static boolean cross(int found,boolean ahead){
          if(index.size() >= 9){
              System.out.println(index.toString());
              return true;
          }
          
        if(ahead){
            found = found + 21;
            
        }else{
            found = found + 19;
        }
        index.add(found);
        cross(found, ahead);
        
        return false;
    }
}
