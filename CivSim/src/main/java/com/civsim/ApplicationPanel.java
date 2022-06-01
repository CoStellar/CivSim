package com.civsim;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class ApplicationPanel extends JPanel{

    private final BufferedImage[][] img;//

    private final MapSize mapSize;

    private final Color[][]  colorPosition;
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
                 g.setColor(background);
                 g.fillRect((x * 32)+x+7, (y * 32)+y+7, 34,34);
            }
        }
        for(int y=0; y< mapSize.getMapSize(); y++){
            for(int x=0;x<mapSize.getMapSize(); x++){
                if(colorPosition[x][y]!= null) {
                    g.setColor(colorPosition[y][x]);
                    g.fillRect((x * 32)+x+8, (y * 32)+y+8, 32,32);
                }
                g.drawImage(img[y][x], (x * 32)+x+8, (y * 32)+y+8, null);
            }
        }
        File file;
        BufferedImage tileImg;
        for(int y=0; y< mapSize.getMapSize(); y++){
            for(int x=0;x<mapSize.getMapSize(); x++){
                if(y==0) {
                    file = new File("./CivSim/src/main/resources/com/civsim/Pliki/map_visuals/top_pane.png");
                    try {
                        tileImg = ImageIO.read(file);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    g.drawImage(tileImg, (x * 32)+x+7, 0, null);
                }
                if(y==mapSize.getMapSize()-1)
                {
                    file = new File("./CivSim/src/main/resources/com/civsim/Pliki/map_visuals/bottom_pane.png");
                    try {
                        tileImg = ImageIO.read(file);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    g.drawImage(tileImg, (x * 32)+x+7, (mapSize.getMapSize()*32) + mapSize.getMapSize() - 18, null);
                }
                if(x==0)
                {
                    file = new File("./CivSim/src/main/resources/com/civsim/Pliki/map_visuals/left_pane.png");
                    try {
                        tileImg = ImageIO.read(file);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    g.drawImage(tileImg, 0, (y * 34), null);
                }
                if(x==mapSize.getMapSize()-1)
                {
                    file = new File("./CivSim/src/main/resources/com/civsim/Pliki/map_visuals/right_pane.png");
                    try {
                        tileImg = ImageIO.read(file);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    g.drawImage(tileImg, (mapSize.getMapSize()*32) + mapSize.getMapSize() - 18, (y * 31)+y+7, null);
                }
                if(y==0 && x==mapSize.getMapSize()-1)
                {

                    file = new File("./CivSim/src/main/resources/com/civsim/Pliki/map_visuals/top_right_corner.png");
                    try {
                        tileImg = ImageIO.read(file);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    g.drawImage(tileImg, (mapSize.getMapSize()*32)+ mapSize.getMapSize() - 24, 0, null);
                }
                if(y==mapSize.getMapSize()-1 && x==mapSize.getMapSize()-1)
                {
                    file = new File("./CivSim/src/main/resources/com/civsim/Pliki/map_visuals/bottom_right_corner.png");
                    try {
                        tileImg = ImageIO.read(file);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    g.drawImage(tileImg, (mapSize.getMapSize()*32)+ mapSize.getMapSize() - 24, (mapSize.getMapSize()*32)+ mapSize.getMapSize() - 24, null);
                }
                if(x==0 && y==0)
                {
                    file = new File("./CivSim/src/main/resources/com/civsim/Pliki/map_visuals/top_left_corner.png");
                    try {
                        tileImg = ImageIO.read(file);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    g.drawImage(tileImg, 0, 0, null);
                }
                if(x==0 && y==mapSize.getMapSize()-1) {
                    file = new File("./CivSim/src/main/resources/com/civsim/Pliki/map_visuals/bottom_left_corner.png");
                    try {
                        tileImg = ImageIO.read(file);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    g.drawImage(tileImg, 0, (mapSize.getMapSize()*32)+ mapSize.getMapSize() - 24, null);
                }

            }
        }
        for(int y=0; y< mapSize.getMapSize(); y++){
            for(int x=0;x<mapSize.getMapSize(); x++){
                if(colorPosition[x][y]!= null) {
                    g.setColor(colorPosition[y][x]);
                    g.fillRect((x * 32)+x+8, (y * 32)+y+8, 32,32);
                }
                g.drawImage(img[y][x], (x * 32)+x+8, (y * 32)+y+8, null);
            }
        }
        g.dispose();
    }

}
