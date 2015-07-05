package assignment;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author samundrak
 */
public class EventListener implements ActionListener {

    private Tiles tile;
    private ArrayList<Player> plyar;
    
    private ArrayList<Tiles> tiles;
    private Arena frame;

    public void setPlyar(ArrayList<Player> plyar) {
        this.plyar = plyar;
    }

    public EventListener(Tiles tile, Arena frame) {
        this.tile = tile;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (Player.turn == plyar.size()) {
            Player.turn = 0;
        }

        if (e.getActionCommand().equals(Defaults.POISION)) {
            if(plyar.get(Player.turn).getName().equals(this.tile.getName())){
            this.tile.setEnabled(false);
            this.plyar.get(Player.turn).setPoison(this.plyar.get(Player.turn).getPoison() + 1);
            for (int i = 0; i < Defaults.TOTAL_TILES; i++) {
                tiles.get(i).setEnabled(true);
            }
            this.tile.setBackground(Color.PINK);
            Arena.poisionMode = true;}
            else{
                javax.swing.JOptionPane.showMessageDialog(null, "Please Dont try to use others poision!!!");
            }
        } else {

            if (Arena.poisionMode) {
                tile.setBackground(Defaults.POISION_COLOR);
                for (int i = 0; i < Arena.clickedTiles.size(); i++) {
                  tiles.get(Arena.clickedTiles.get(i)).setEnabled(false);
                }
                Arena.poisionMode = false;
            } else {

                this.tile.setBackground(plyar.get(Player.turn).getColor());
                plyar.get(Player.turn).addTileIndex(tile.getName());
                Arena.clickedTiles.add(Integer.parseInt(tile.getName()));


                tile.setEnabled(false);
                LogixChecker logixChecker = new LogixChecker(plyar.get(Player.turn));
                tiles.get(Integer.parseInt(tile.getName())).setName(plyar.get(Player.turn).getName());
                logixChecker.setTiles(tiles);

                if (logixChecker.isGameFinished()) {
                    plyar.get(Player.turn).setWonGame(plyar.get(Player.turn).getWonGame() + 1);
                    javax.swing.JOptionPane.showMessageDialog(null, "Congratulations! " + plyar.get(Player.turn).getName() + " You have won " + plyar.get(Player.turn).getWonGame() + " game");
                    this.frame.scores.get(Player.turn).setText(plyar.get(Player.turn).getName() + ": "  +  plyar.get(Player.turn).getWonGame());
                    frame.gameResetter();
                    Player.turn--;
                }
               }
//                this.frame.poisons.get(Player.turn).setEnabled(false);
                this.frame.scores.get( Player.turn).setBackground(Color.WHITE);
                Player.turn++;
                
                int turn = Player.turn == plyar.size() ? 0 : Player.turn;
//                 if(plyar.get(turn).getPoison() == 0) this.frame.poisons.get(turn).setEnabled(true);
                this.frame.scores.get(turn).setBackground(Color.GREEN);
                frame.setTitle(Defaults.GAME_NAME + " (" + plyar.get(turn).getName() + "'s turn)");
            
        }
    }

    void setAllTiles(ArrayList<Tiles> tiles) {
        this.tiles = tiles;
    }
}
