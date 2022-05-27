package com.civsim;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class Map extends JFrame {

    final Integer fieldSize = 32;
    public MapSize mapSize;

    Resources[][] resources;
    ApplicationPanel appPanel;
    public BufferedImage[][] img;
    int civAmount, civSize;
    File file;
    public Color[] civColor;
    private Color[][] colorPosition;
    private final Color background = new Color(57, 99, 37);
    public Map(ArrayList<ArrayList<Position>> civPosition, MapSize mapSize, Integer civAmount, Color[] civColor) throws IOException {
        this.mapSize = mapSize;
        this.civAmount = civAmount;
        this.civColor = civColor;
        resources = new Resources[this.mapSize.getMapSize()][this.mapSize.getMapSize()];
        img = new BufferedImage[this.mapSize.getMapSize()][this.mapSize.getMapSize()];
        colorPosition = new Color[this.mapSize.getMapSize()][this.mapSize.getMapSize()];


        for (int x = 0; x < this.mapSize.getMapSize(); x++) {
            for (int y = 0; y < this.mapSize.getMapSize(); y++) {
                resources[x][y] = new Resources();
                this.img[x][y] = resources[x][y].getImg();
            }
        }
        for (int x = 0; x < this.mapSize.getMapSize(); x++) {
            for (int y = 0; y < this.mapSize.getMapSize(); y++) {
                this.colorPosition[x][y] = new Color(57, 99, 37);
                for (int i = 0; i < civAmount; i++) {
                    civSize = civPosition.get(i).size();
                    for(int o=0; o<civSize; o++){
                        if (civPosition.get(i).get(o).x == x && civPosition.get(i).get(o).y == y) {
                            file = new File("./CivSim/src/main/resources/com/civsim/Pliki/city_template.png");
                            this.img[x][y] = ImageIO.read(file);
                            this.colorPosition[x][y] = this.civColor[i];
                        }
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
            appPanel = new ApplicationPanel(img, this.mapSize, colorPosition);
            add(appPanel);
            setVisible(true);
        }

    }

    public void updateMap(ArrayList<ArrayList<Position>> civPosition) throws IOException {

        for (int x = 0; x < this.mapSize.getMapSize(); x++) {
            for (int y = 0; y < this.mapSize.getMapSize(); y++) {
                this.img[x][y] = resources[x][y].getImg();
                this.colorPosition[x][y] =  new Color(57, 99, 37);
            }
        }
        for (int x = 0; x < this.mapSize.getMapSize(); x++) {
            for (int y = 0; y < this.mapSize.getMapSize(); y++) {
                for (int i = 0; i < civAmount; i++) {
                    civSize = civPosition.get(i).size();
                    for(int o=0; o<civSize; o++){
                        if (civPosition.get(i).get(o).x == x && civPosition.get(i).get(o).y == y) {
                            file = new File("./CivSim/src/main/resources/com/civsim/Pliki/city_template.png");
                            this.img[x][y] = ImageIO.read(file);
                            this.colorPosition[x][y] = civColor[i];
                        }
                    }
                }
            }
        }
        appPanel.repaint();
    }



}
