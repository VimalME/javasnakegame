
package assignment;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author samundrak
 */
public class Player {
public static int turn =  0;

    private ArrayList<String> tileIndex ;
    private String name;
    private int poison;
    private int id;
    private Color color;
    private int wonGame;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getPoison() {
        return poison;
    }

    public void setPoison(int poison) {
        this.poison = poison;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getTileIndex() {
        return tileIndex;
    }

    public Player() {
        this.poison = 1;
        wonGame = 0;
        this.tileIndex = new ArrayList<String>();
    }

    public int getWonGame() {
        return wonGame;
    }

    public void setWonGame(int wonGame) {
        this.wonGame = wonGame;
    }
    
    
    public void addTileIndex(String index){
        tileIndex.add(index);
    }
    
   
        
}
