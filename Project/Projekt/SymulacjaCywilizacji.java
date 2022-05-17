package Project.Projekt;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class SymulacjaCywilizacji  extends JFrame {

    final Integer fieldSize = 32;
    private Integer screenWidth;
    private Integer screenHeight;
    public MapSize mapSize = new MapSize(25);

    private BufferedImage[] img = new BufferedImage[6];

    private ApplicationPanel appPanel;
    public SymulacjaCywilizacji(){
        importImg();
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
    private void importImg() {
        InputStream is = getClass().getResourceAsStream("Pliki/wood_log_filled.png");
        try {
            img[0] = ImageIO.read(is);
        }catch(IOException e){
            e.printStackTrace();
        }
         is = getClass().getResourceAsStream("Pliki/water_filled.png");
        try {
            img[1] = ImageIO.read(is);
        }catch(IOException e){
            e.printStackTrace();
        }
        is = getClass().getResourceAsStream("Pliki/cow_filled.png");
        try {
            img[2] = ImageIO.read(is);
        }catch(IOException e){
            e.printStackTrace();
        }
        is = getClass().getResourceAsStream("Pliki/wheat_filled.png");
        try {
            img[3] = ImageIO.read(is);
        }catch(IOException e){
            e.printStackTrace();
        }
        is = getClass().getResourceAsStream("Pliki/iron_filled.png");
        try {
            img[4] = ImageIO.read(is);
        }catch(IOException e){
            e.printStackTrace();
        }
        is = getClass().getResourceAsStream("Pliki/stone_filled.png");
        try {
            img[5] = ImageIO.read(is);
        }catch(IOException e){
            e.printStackTrace();
        }


    }

    public static void  main(String[] args){
        SymulacjaCywilizacji simulation = new SymulacjaCywilizacji();

    }
}
