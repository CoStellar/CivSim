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
        InputStream is;
        if(Objects.equals(resourceName, "wood")){
            is = getClass().getResourceAsStream("Pliki/wood_log_filled.png");
            try {
                return ImageIO.read(is);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(Objects.equals(resourceName, "water")){
            is = getClass().getResourceAsStream("Pliki/water_filled.png");
            try {
                return ImageIO.read(is);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(Objects.equals(resourceName, "cow")){
            is = getClass().getResourceAsStream("Pliki/cow_filled.png");
            try {
                return ImageIO.read(is);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(Objects.equals(resourceName, "wheat")){
            is = getClass().getResourceAsStream("Pliki/wheat_filled.png");
            try {
                return ImageIO.read(is);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(Objects.equals(resourceName, "iron")){
            is = getClass().getResourceAsStream("Pliki/iron_filled.png");
            try {
                return ImageIO.read(is);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(Objects.equals(resourceName, "stone")){
            is = getClass().getResourceAsStream("Pliki/stone_filled.png");
            try {
                return ImageIO.read(is);
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
