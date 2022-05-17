package Project.Projekt;

import javax.swing.*;
import java.awt.*;


public class Civilization extends JPanel {

    int x, y;

    public Civilization() {
        x=(int)(Math.random()*665+0);
        y=(int)(Math.random()*665+0);
    }
    public void paint(Graphics g){
        g.setColor(Color.BLUE);
        g.fillRect(x, y, 25, 25);
    }

}
