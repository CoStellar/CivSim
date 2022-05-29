package com.civsim;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;


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
    ArrayList<ArrayList<Position>> civPosition;
    ArrayList<ArrayList<Position>> cityPosition;
    public Map(ArrayList<ArrayList<Position>> civPosition, MapSize mapSize, Integer civAmount, Color[] civColor, ArrayList<ArrayList<Position>> cityPosition) throws IOException {
        this.mapSize = mapSize;
        this.civAmount = civAmount;
        this.civColor = civColor;
        resources = new Resources[this.mapSize.getMapSize()][this.mapSize.getMapSize()];
        img = new BufferedImage[this.mapSize.getMapSize()][this.mapSize.getMapSize()];
        colorPosition = new Color[this.mapSize.getMapSize()][this.mapSize.getMapSize()];
        this.civPosition = civPosition;
        this.cityPosition = cityPosition;

        for (int x = 0; x < this.mapSize.getMapSize(); x++) {
            for (int y = 0; y < this.mapSize.getMapSize(); y++) {
                resources[x][y] = new Resources();
                this.img[x][y] = resources[x][y].getImg();
                this.colorPosition[x][y] = new Color(57, 99, 37);
            }
        }
        for (int x = 0; x < this.mapSize.getMapSize(); x++) {
            for (int y = 0; y < this.mapSize.getMapSize(); y++) {
                for (int i = 0; i < civAmount; i++) {
                    for(int o=0; o<civPosition.get(i).size(); o++){
                        if (civPosition.get(i).get(o).x == x && civPosition.get(i).get(o).y == y) {
                            this.img[x][y] = setImg(resources[x][y].getResourceName());
                            this.colorPosition[x][y] = civColor[i];
                        }
                    }
                }
            }
        }
        for (int x = 0; x < this.mapSize.getMapSize(); x++) {
            for (int y = 0; y < this.mapSize.getMapSize(); y++) {
                for (int i = 0; i < civAmount; i++) {
                    for (int o = 0; o < cityPosition.get(i).size(); o++) {
                        if (cityPosition.get(i).get(o).x == x && cityPosition.get(i).get(o).y == y) {
                            file = new File("./CivSim/src/main/resources/com/civsim/Pliki/city_template.png");
                            this.img[x][y] = ImageIO.read(file);
                        }
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



    public void updateMap(ArrayList<ArrayList<Position>> civPosition, ArrayList<ArrayList<Position>> cityPosition) throws IOException {
        this.civPosition = civPosition;
        this.cityPosition = cityPosition;
        for (int x = 0; x < this.mapSize.getMapSize(); x++) {
            for (int y = 0; y < this.mapSize.getMapSize(); y++) {
                for (int i = 0; i < civAmount; i++) {
                    for(int o=0; o<civPosition.get(i).size(); o++){
                        if (civPosition.get(i).get(o).x == x && civPosition.get(i).get(o).y == y) {
                            this.img[x][y] = setImg(resources[x][y].getResourceName());
                            this.colorPosition[x][y] = civColor[i];
                        }
                    }
                }
            }
        }
        for (int x = 0; x < this.mapSize.getMapSize(); x++) {
            for (int y = 0; y < this.mapSize.getMapSize(); y++) {
                for (int i = 0; i < civAmount; i++) {
                    for (int o = 0; o < cityPosition.get(i).size(); o++) {
                        if (cityPosition.get(i).get(o).x == x && cityPosition.get(i).get(o).y == y) {
                            file = new File("./CivSim/src/main/resources/com/civsim/Pliki/city_template.png");
                            this.img[x][y] = ImageIO.read(file);
                        }
                    }
                }
            }
        }
        appPanel.repaint();
    }


    public BufferedImage setImg(String tileName) throws IOException {
        BufferedImage tileImg = null;
        if(Objects.equals(tileName, "wood"))
        {
            file = new File("./CivSim/src/main/resources/com/civsim/Pliki/wood_log.png");
            tileImg = ImageIO.read(file);
        }
        if(Objects.equals(tileName, "stone"))
        {
            file = new File("./CivSim/src/main/resources/com/civsim/Pliki/stone.png");
            tileImg = ImageIO.read(file);
        }
        if(Objects.equals(tileName, "water"))
        {
            file = new File("./CivSim/src/main/resources/com/civsim/Pliki/water.png");
            tileImg = ImageIO.read(file);
        }
        if(Objects.equals(tileName, "wheat"))
        {
            file = new File("./CivSim/src/main/resources/com/civsim/Pliki/wheat.png");
            tileImg = ImageIO.read(file);
        }
        if(Objects.equals(tileName, "iron"))
        {
            file = new File("./CivSim/src/main/resources/com/civsim/Pliki/iron.png");
            tileImg = ImageIO.read(file);
        }
        if(Objects.equals(tileName, "cow"))
        {
            file = new File("./CivSim/src/main/resources/com/civsim/Pliki/cow.png");
            tileImg = ImageIO.read(file);
        }
        return tileImg;
    }
}
