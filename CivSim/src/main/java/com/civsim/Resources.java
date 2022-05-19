package com.civsim;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.FileSystems;
import java.util.Objects;

public class Resources {
    String resourceName;
    Integer wood = 0;
    Integer iron = 0;
    Integer wheat = 0;
    Integer animals = 0;
    Integer stone = 0;
    Integer water = 0;

    public Resources(){
        this.resourceName = drawResources();
    }
    public BufferedImage getImg(){
        BufferedImage image;
        InputStream is;
        if(Objects.equals(this.resourceName, "wood")){
            try {
                File file = new File("./src/main/resources/com/civsim/Pliki/wood_log_filled.png");
                image = ImageIO.read(file);
                return image;

            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(Objects.equals(this.resourceName, "water")){
            try {
                File file = new File("./src/main/resources/com/civsim/Pliki/water_filled.png");
                image = ImageIO.read(file);
                return image;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(Objects.equals(this.resourceName, "cow")){

            try {
                File file = new File("./src/main/resources/com/civsim/Pliki/cow_filled.png");
                image = ImageIO.read(file);
                return image;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(Objects.equals(this.resourceName, "wheat")){

            try {
                File file = new File("./src/main/resources/com/civsim/Pliki/wheat_filled.png");
                image = ImageIO.read(file);
                return image;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(Objects.equals(this.resourceName, "iron")){

            try {
                File file = new File("./src/main/resources/com/civsim/Pliki/iron_filled.png");
                image = ImageIO.read(file);
                return image;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(Objects.equals(this.resourceName, "stone")){

            try {File file = new File("./src/main/resources/com/civsim/Pliki/stone_filled.png");
                image = ImageIO.read(file);
                return image;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    String drawResources(){
        int random;
        random = (int) (Math.random() * 6);
        if(random == 0){
                this.wood = 1;
                return "wood";}
        if(random == 1){
                this.water = 1;
                return "water";}
        if(random == 2){
                this.animals = 1;
                return "cow";}
        if(random == 3){
                this.wheat = 1;
                return "wheat";}
        if(random == 4){
                this.iron = 1;
                return "iron";}
        if (random == 5){
                this.stone = 1;
                return "stone";}
        else return null;
    }
    public boolean resourcesCompareVillage(Resources resources){
        if(resources.wood >= 5 && resources.wheat >= 3 && resources.animals >= 2) {
            return true;
        }
        else return false;
    }
    public boolean resourcesCompareCity(Resources resources){
        if(resources.wood >= 3 && resources.stone >= 5 && resources.animals >= 2 && resources.iron >= 2) {
            return true;
        }
        else return false;
    }


}
