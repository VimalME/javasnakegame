
package assignment;

import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author samundrak
 */
public class Frame extends JFrame{
    ArrayList<Tiles> tiles;
 
    protected  GridLayout gl;
     
    JLabel p1Score;
    JLabel p2Score;
    
    public Frame(){
        super(Defaults.GAME_NAME);
        setSize(Defaults.FRAME_X,Defaults.FRAME_Y);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
//        setResizable(false);
        tiles = new ArrayList<Tiles>();
//        JFrame.setDefaultLookAndFeelDecorated(false);
    }
    
    
    
   
}
