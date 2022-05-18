package Project.Projekt;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.lang.constant.Constable;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Resources {
    String resourceName;
    Integer wood;
    Integer iron;
    Integer wheat;
    Integer animals;
    Integer stone;
    Integer water;
    private BufferedImage resourceImg;


    public Resources(){
        this.resourceName = drawResources();
        importImg(this.resourceName);
    }
    public void importImg(String resourceName) {
        InputStream is;
        if(Objects.equals(resourceName, "wood")){
            is = getClass().getResourceAsStream("Pliki/wood_log_filled.png");
            try {
                this.resourceImg = ImageIO.read(is);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(Objects.equals(resourceName, "water")){
            is = getClass().getResourceAsStream("Pliki/water_filled.png");
            try {
                this.resourceImg = ImageIO.read(is);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(Objects.equals(resourceName, "cow")){
            is = getClass().getResourceAsStream("Pliki/cow_filled.png");
            try {
                this.resourceImg = ImageIO.read(is);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(Objects.equals(resourceName, "wheat")){
            is = getClass().getResourceAsStream("Pliki/wheat_filled.png");
            try {
                this.resourceImg = ImageIO.read(is);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(Objects.equals(resourceName, "iron")){
            is = getClass().getResourceAsStream("Pliki/iron_filled.png");
            try {
                this.resourceImg = ImageIO.read(is);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(Objects.equals(resourceName, "stone")){
            is = getClass().getResourceAsStream("Pliki/stone_filled.png");
            try {
                this.resourceImg = ImageIO.read(is);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    public BufferedImage getImg(){
        return this.resourceImg;
    }


    String drawResources(){
        int random;
        random = (int) (Math.random() * 6);
        if(random == 0)
                return "wood";
        if(random == 1)
                return "water";
        if(random == 2)
                return "cow";
        if(random == 3)
                return "wheat";
        if(random == 4)
                return "iron";
        if(random == 5)
                return "stone";
        else
        return null;
    }

}
