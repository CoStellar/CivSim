package Project.Projekt;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class Map   extends JFrame {

    final Integer fieldSize = 32;
    private Integer screenWidth;
    private Integer screenHeight;
    public MapSize mapSize = new MapSize(25);

    Resources[][] resources = new Resources[mapSize.getMapSize()][mapSize.getMapSize()];


    public BufferedImage[][] img = new BufferedImage[mapSize.getMapSize()][mapSize.getMapSize()];

    private ApplicationPanel appPanel;
    public Map(){
        for(int x=0;x<mapSize.getMapSize();x++){
            for(int y=0;y<mapSize.getMapSize();y++){
                resources[x][y] = new Resources();
                this.img[x][y] = resources[x][y].getImg();
            }
        }
        this.screenWidth = (mapSize.getMapSize() * fieldSize) + (mapSize.getMapSize() + 15);
        this.screenHeight = (mapSize.getMapSize() * fieldSize) + (mapSize.getMapSize() + 38);
        setSize(this.screenWidth, this.screenHeight);
        getContentPane().setBackground(Color.black);
        setTitle("Symulacja Cywilizacji");
        setResizable(false);
        ImageIcon image = new ImageIcon(Objects.requireNonNull(getClass().getResource("Pliki/icon.png")));
        setIconImage(image.getImage());
        appPanel = new ApplicationPanel(img);
        add(appPanel);
        setVisible(true);
    }


}
