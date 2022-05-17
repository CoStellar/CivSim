package Project.Projekt;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

public class Resources {
    Integer wood;
    Integer iron;
    Integer wheat;
    Integer animals;
    Integer stone;
    Integer water;

    private ArrayList<BufferedImage> resourceImg = new ArrayList<>();

    private void importImg() {
        InputStream is = getClass().getResourceAsStream("Pliki/wood_log_filled.png");
        try {
            resourceImg.set(0, ImageIO.read(is));
        } catch (IOException e) {
            e.printStackTrace();
        }
        is = getClass().getResourceAsStream("Pliki/water_filled.png");
        try {
            resourceImg.set(1, ImageIO.read(is));
        } catch (IOException e) {
            e.printStackTrace();
        }
        is = getClass().getResourceAsStream("Pliki/cow_filled.png");
        try {
            resourceImg.set(2, ImageIO.read(is));
        } catch (IOException e) {
            e.printStackTrace();
        }
        is = getClass().getResourceAsStream("Pliki/wheat_filled.png");
        try {
            resourceImg.set(3, ImageIO.read(is));
        } catch (IOException e) {
            e.printStackTrace();
        }
        is = getClass().getResourceAsStream("Pliki/iron_filled.png");
        try {
            resourceImg.set(4, ImageIO.read(is));
        } catch (IOException e) {
            e.printStackTrace();
        }
        is = getClass().getResourceAsStream("Pliki/stone_filled.png");
        try {
            resourceImg.set(5, ImageIO.read(is));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    Random randomAmount = new Random();

    void drawResources(){
    }

}
