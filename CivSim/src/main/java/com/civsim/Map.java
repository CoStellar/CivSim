package com.civsim;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Map extends JFrame {

    final Integer fieldSize = 32;
    public MapSize mapSize;

    Resources[][] resources;
    ApplicationPanel appPanel;
    public BufferedImage[][] img;
    int civAmount;
    File file;
    public Map(Position[] civPosition, MapSize mapSize, Integer civAmount) throws IOException {
        this.mapSize = mapSize;
        this.civAmount = civAmount;
        resources = new Resources[this.mapSize.getMapSize()][this.mapSize.getMapSize()];
        img = new BufferedImage[this.mapSize.getMapSize()][this.mapSize.getMapSize()];

        for (int x = 0; x < this.mapSize.getMapSize(); x++) {
            for (int y = 0; y < this.mapSize.getMapSize(); y++) {
                resources[x][y] = new Resources();
                this.img[x][y] = resources[x][y].getImg();
            }
        }
        for (int x = 0; x < this.mapSize.getMapSize(); x++) {
            for (int y = 0; y < this.mapSize.getMapSize(); y++) {
                for (int i = 0; i < civAmount; i++) {
                    if (civPosition[i].x == x && civPosition[i].y == y) {
                        file = new File("./CivSim/src/main/resources/com/civsim/Pliki/city.png");
                        this.img[x][y] = ImageIO.read(file);
                    }
                }
            }

            int screenWidth = (mapSize.getMapSize() * fieldSize) + (mapSize.getMapSize() + 15);
            int screenHeight = (mapSize.getMapSize() * fieldSize) + (mapSize.getMapSize() + 38);
            setSize(screenWidth, screenHeight);
            getContentPane().setBackground(Color.black);
            setResizable(false);
            file = new File("./CivSim/src/main/resources/com/civsim/Pliki/icon.png");
            ImageIcon image = new ImageIcon(String.valueOf(file));
            setIconImage(image.getImage());
            appPanel = new ApplicationPanel(img, this.mapSize);
            add(appPanel);
            setVisible(true);
        }

    }

    public void updateMap(Position[] civPosition) throws IOException {
        for (int x = 0; x < this.mapSize.getMapSize(); x++) {
            for (int y = 0; y < this.mapSize.getMapSize(); y++) {
                this.img[x][y] = resources[x][y].getImg();
            }
        }
        for (int x = 0; x < this.mapSize.getMapSize(); x++) {
            for (int y = 0; y < this.mapSize.getMapSize(); y++) {
                for (int i = 0; i < civAmount; i++) {
                    if (civPosition[i].x == x && civPosition[i].y == y) {
                        file = new File("./CivSim/src/main/resources/com/civsim/Pliki/city.png");
                        this.img[x][y] = ImageIO.read(file);
                    }
                }
            }
        }

        appPanel.repaint();
    }

}
