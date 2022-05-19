package com.civsim;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class ApplicationPanel extends JPanel{

        private Random random;
        private  BufferedImage[][] img;

    public ApplicationPanel(BufferedImage[][] img)   {
        this.img = img;

    }
    public MapSize mapSize = new MapSize(25);

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Color background = new Color(57, 99, 37);
        g.setColor(Color.getColor("#335821"));
        for(int y=0; y< mapSize.getMapSize(); y++){
            for(int x=0;   x<mapSize.getMapSize(); x++){
                    g.setColor(Color.pink);

                    g.fillRect((x * 32)+x, (y * 32)+y, 32,32);

                    g.setColor(background);

                    g.drawRect((x * 32)+x-1, (y * 32)+y-1, 33,33);

                    g.drawImage(img[y][x], (x * 32)+x, (y * 32)+y, null);

            }
        }


    }

}
