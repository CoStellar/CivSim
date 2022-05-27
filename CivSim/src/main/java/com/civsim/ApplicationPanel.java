package com.civsim;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


public class ApplicationPanel extends JPanel{

    private final BufferedImage[][] img;//

    public MapSize mapSize;

    private Color[][]  colorPosition;
    public ApplicationPanel(BufferedImage[][] img, MapSize mapSize, Color[][]  civColor){
        this.mapSize = new MapSize(mapSize.getMapSize());
        this.img = img;
        this.colorPosition = civColor;
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.getColor("#335821"));
        Color background = new Color(57, 99, 37);
        for(int y=0; y< mapSize.getMapSize(); y++){
            for(int x=0;x<mapSize.getMapSize(); x++){
                if(colorPosition[x][y]== null) {
                    g.setColor(background);
                    g.fillRect((x * 32)+x-1, (y * 32)+y-1, 33,33);

                }
                else {
                    g.setColor(colorPosition[y][x]);
                    g.fillRect((x * 32)+x, (y * 32)+y, 32,32);
                }
                g.drawImage(img[y][x], (x * 32)+x, (y * 32)+y, null);

            }
        }
        g.dispose();
    }

}
