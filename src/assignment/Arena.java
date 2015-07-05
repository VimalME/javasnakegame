
package assignment;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author samundrak
 */
public class Arena extends Frame {

    private ArrayList<Player> player;
    public static ArrayList<Integer> clickedTiles = new ArrayList<Integer>();
    
    public Arena init() {
        return this;
    }

    public Arena initPlayer() {
        player = new ArrayList<Player>();
        for (int i = 0; i < Defaults.TOTAL_PLAYERS; i++) {
            player.add(new Player());

        }
        return this;
    }

    public void setPlayerName() {
        for (int i = 0; i < Defaults.TOTAL_PLAYERS; i++) {
            String name = "";
            while(name.isEmpty() && name.length() < 1){
             name = javax.swing.JOptionPane.showInputDialog("Enter name of player " + (i + 1));
            }
            player.get(i).setName(name);
            player.get(i).setId(i);
            player.get(i).setColor(Defaults.COLORS[i]);
        }
    }

    public void initTiles() {
        gl = new GridLayout(20, 20);

        for (int i = 0; i < Defaults.TOTAL_TILES; i++) {
            Tiles tile = new Tiles();
            tile.setBackground(Defaults.BUTTON_DEFAULT_COLOR);
            tile.setName(i+"");
            EventListener el = new EventListener(tile,this);
            el.setPlyar(player);
            el.setAllTiles(tiles);
            tile.addActionListener(el);
            tiles.add(tile);
        }

        //iconify();
        Iterator it = tiles.iterator();
        while (it.hasNext()) {
            add((Component) it.next());
        }
        javax.swing.JOptionPane.showMessageDialog(null, player.get(Player.turn).getName() + " will start the game!!");
        this.setTitle(Defaults.GAME_NAME + " ("+ player.get(Player.turn).getName() + "'s turn)");
        setLayout(gl);

    }

    public void setHUD() {
        JPanel jp = new JPanel();
        for (int i = 0; i < Defaults.TOTAL_PLAYERS; i++) {
            JLabel jl = new JLabel(player.get(i).getName());
            jl.setSize(200, 50);
            jp.add(jl);
        }
        jp.setLayout(new FlowLayout());
        jp.setSize(500, 500);
        add(jp);
    }
    
   public void iconify(){
       //Nepal FLAG
       int[] index = {6, 26, 46, 66, 86, 106, 126, 146, 166, 186, 206, 226, 246, 266, 286, 306, 326, 346, 366, 386, 7, 28, 49, 70, 91, 112, 133, 154, 175, 194, 193, 192, 191, 190, 189, 188, 209, 230, 251, 272, 293, 314, 335, 356, 375, 374, 373, 372, 371, 370, 369, 368, 367, 268, 288, 308, 309, 108, 128, 129, 109};
       
       for (int i = 0; i < index.length; i++) {
          this.tiles.get(index[i]).setBackground(Color.RED);
       }
   }
   
   public void gameResetter(){
       for (int i = 0; i < Defaults.TOTAL_TILES; i++) {
           tiles.get(i).setName(i+"");
           tiles.get(i).setBackground(Defaults.BUTTON_DEFAULT_COLOR);
           tiles.get(i).setEnabled(true);
       }
       
        javax.swing.JOptionPane.showMessageDialog(null, player.get(Player.turn).getName() + " will start the game!!");
        this.setTitle(Defaults.GAME_NAME + " ("+ player.get(Player.turn).getName() + "'s turn)");
   }
}
