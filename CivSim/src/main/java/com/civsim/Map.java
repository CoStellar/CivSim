package com.civsim;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Map extends JFrame {

    final Integer fieldSize = 32;
    private Integer screenWidth;
    private Integer screenHeight;
    public MapSize mapSize = new MapSize(25);

    Resources[][] resources = new Resources[mapSize.getMapSize()][mapSize.getMapSize()];

    public BufferedImage[][] img = new BufferedImage[mapSize.getMapSize()][mapSize.getMapSize()];

    private ApplicationPanel appPanel;
    public Map(Position[] civPosition) throws IOException {
        File file;

        for (int x = 0; x < mapSize.getMapSize(); x++) {
            for (int y = 0; y < mapSize.getMapSize(); y++) {
                resources[x][y] = new Resources();
                this.img[x][y] = resources[x][y].getImg();
            }
        }
        for (int x = 0; x < mapSize.getMapSize(); x++) {
            for (int y = 0; y < mapSize.getMapSize(); y++) {
                for (int i = 0; i < 4; i++) {
                    if (civPosition[i].x == x && civPosition[i].y == y) {
                        file = new File("./src/main/resources/com/civsim/Pliki/city.png");
                        this.img[x][y] = ImageIO.read(file);
                    }
                }
            }

            this.screenWidth = (mapSize.getMapSize() * fieldSize) + (mapSize.getMapSize() + 15);
            this.screenHeight = (mapSize.getMapSize() * fieldSize) + (mapSize.getMapSize() + 38);
            setSize(this.screenWidth, this.screenHeight);
            getContentPane().setBackground(Color.black);
            setTitle("Symulacja Cywilizacji");
            setResizable(false);
            file = new File("./src/main/resources/com/civsim/Pliki/icon.png");
            ImageIcon image = new ImageIcon(String.valueOf(file));
            setIconImage(image.getImage());
            appPanel = new ApplicationPanel(img);
            add(appPanel);
            setVisible(true);
        }

    }
}
