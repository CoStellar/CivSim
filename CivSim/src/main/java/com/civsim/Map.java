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

    public BufferedImage[][] img;

    public Map(Position[] civPosition, MapSize mapSize, Integer civAmount) throws IOException {
        this.mapSize = mapSize;
        resources = new Resources[mapSize.getMapSize()][mapSize.getMapSize()];
        img = new BufferedImage[mapSize.getMapSize()][mapSize.getMapSize()];
        File file;
        for (int x = 0; x < mapSize.getMapSize(); x++) {
            for (int y = 0; y < mapSize.getMapSize(); y++) {
                resources[x][y] = new Resources();
                this.img[x][y] = resources[x][y].getImg();
            }
        }
        for (int x = 0; x < mapSize.getMapSize(); x++) {
            for (int y = 0; y < mapSize.getMapSize(); y++) {
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
            ApplicationPanel appPanel = new ApplicationPanel(img, this.mapSize);
            add(appPanel);
            setVisible(true);
        }

    }
}
