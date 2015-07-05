
package assignment;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author samundrak
 */
public class EventListener implements ActionListener{
private Tiles tile;
private ArrayList<Player> plyar;
private ArrayList<Tiles> tiles;
private Arena frame;
    public void setPlyar(ArrayList<Player> plyar) {
        this.plyar = plyar;
    }

    public EventListener(Tiles tile,Arena frame) {
        this.tile = tile;
        this.frame = frame;
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(Player.turn == plyar.size())   Player.turn = 0;
        
       
        
        this.tile.setBackground(plyar.get(Player.turn).getColor());
        plyar.get(Player.turn).addTileIndex(tile.getName());
        Arena.clickedTiles.add(Integer.parseInt(tile.getName()));
        
        
        tile.setEnabled(false);
        LogixChecker logixChecker =  new LogixChecker(plyar.get(Player.turn));
        tiles.get(Integer.parseInt(tile.getName())).setName(plyar.get(Player.turn).getName());
        logixChecker.setTiles(tiles);
        
        if(logixChecker.isGameFinished()){
            plyar.get(Player.turn).setWonGame(plyar.get(Player.turn).getWonGame() + 1);
            javax.swing.JOptionPane.showMessageDialog(null,"Congratulations! " +  plyar.get(Player.turn).getName() + " You have won "+plyar.get(Player.turn).getWonGame()+" game");
            frame.gameResetter();
            Player.turn--;
        }
        Player.turn++;
         int turn = Player.turn == plyar.size() ?  0 : Player.turn;
        frame.setTitle(Defaults.GAME_NAME + " ("+ plyar.get(turn).getName() + "'s turn)");
       
    }

    void setAllTiles(ArrayList<Tiles> tiles) {
        this.tiles = tiles;
    }
    
}
