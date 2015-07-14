package assignment;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author samundrak
 */
public class ClickListener implements ActionListener {

    private Tiles tile;
    private ArrayList<Player> plyar;
    private ArrayList<Tiles> tiles;
    private Arena frame;

    public void setPlyar(ArrayList<Player> plyar) {
        this.plyar = plyar;
    }

    public ClickListener(Tiles tile, Arena frame) {
        this.tile = tile;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (Player.turn == plyar.size()) {
            Player.turn = 0;
        }

        if (e.getActionCommand().equals(Defaults.POISION)) {
            if (plyar.get(Player.turn).getName().equals(this.tile.getName())) {
                this.tile.setEnabled(false);
                this.plyar.get(Player.turn).setPoison(this.plyar.get(Player.turn).getPoison() + 1);
                for (int i = 0; i < Defaults.TOTAL_TILES; i++) {
                    if(!tiles.get(i).getName().equals(Defaults.POISION)){
                        tiles.get(i).setEnabled(true);
                    }
                }
                this.tile.setBackground(Color.PINK);
                this.frame.scores.get(Player.turn).setBackground(Color.WHITE);
                Arena.poisionMode = true;
            } else {
                javax.swing.JOptionPane.showMessageDialog(null, "Please Dont try to use others poision!!!");
            }
        } else {

            if (Arena.poisionMode) {
                tile.setBackground(Defaults.POISION_COLOR);
                tile.setName(Defaults.POISION);
                tile.setEnabled(false);

                int[] poisionedArea = Defaults.getSideCordinates(tile.getId());
                for (int i = 0; i < poisionedArea.length; i++) {
                    try {
                        tiles.get(poisionedArea[i]).setBackground(Color.BLACK);
                        tiles.get(poisionedArea[i]).setEnabled(false);
                        tiles.get(poisionedArea[i]).setName(Defaults.POISION);
                    } catch (ArrayIndexOutOfBoundsException ex) {
                        continue;
                    }
                }
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
                logixChecker.setCurrentIndex(Integer.parseInt(tile.getName()));
                tiles.get(Integer.parseInt(tile.getName())).setName(plyar.get(Player.turn).getName());
                logixChecker.setTiles(tiles);

                this.frame.scores.get(Player.turn).setBackground(Color.WHITE);

                if (logixChecker.isGameFinished()) {
                    plyar.get(Player.turn).setWonGame(plyar.get(Player.turn).getWonGame() + 1);
                    javax.swing.JOptionPane.showMessageDialog(null, "Congratulations! " + plyar.get(Player.turn).getName() + " You have won " + plyar.get(Player.turn).getWonGame() + " game");
                    this.frame.scores.get(Player.turn).setText(plyar.get(Player.turn).getName() + ": " + plyar.get(Player.turn).getWonGame());
                    frame.gameResetter();
                    Player.turn--;
                }
            }

            Player.turn++;

            int turn = Player.turn == plyar.size() ? 0 : Player.turn;
            this.frame.scores.get(turn).setBackground(Defaults.HIGHLIGHT_COLOR);
            frame.setTitle(Defaults.GAME_NAME + " (" + plyar.get(turn).getName() + "'s turn)");

        }
    }

    void setAllTiles(ArrayList<Tiles> tiles) {
        this.tiles = tiles;
    }
}
