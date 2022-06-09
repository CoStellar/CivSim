package com.civsim;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import java.util.Objects;

public class Resources
{
    private String resourceName;
    public Integer wood = 0;
    public Integer iron = 0;
    public Integer wheat = 0;
    public Integer animals = 0;
    public Integer stone = 0;
    public Integer water = 0;

    public Resources(){
        this.resourceName = drawResources();
    }
    public Resources(Boolean empty){
    }
    public BufferedImage getImg()
    {
        BufferedImage image;
        if(Objects.equals(this.resourceName, "wood"))
        {
            try {
                File file = new File("./CivSim/src/main/resources/com/civsim/Pliki/map_visuals/wood_log_filled.png");
                image = ImageIO.read(file);
                return image;

            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(Objects.equals(this.resourceName, "water"))
        {
            try {
                File file = new File("./CivSim/src/main/resources/com/civsim/Pliki/map_visuals/water_filled.png");
                image = ImageIO.read(file);
                return image;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(Objects.equals(this.resourceName, "cow"))
        {

            try {
                File file = new File("./CivSim/src/main/resources/com/civsim/Pliki/map_visuals/cow_filled.png");
                image = ImageIO.read(file);
                return image;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(Objects.equals(this.resourceName, "wheat"))
        {

            try {
                File file = new File("./CivSim/src/main/resources/com/civsim/Pliki/map_visuals/wheat_filled.png");
                image = ImageIO.read(file);
                return image;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(Objects.equals(this.resourceName, "iron"))
        {

            try {
                File file = new File("./CivSim/src/main/resources/com/civsim/Pliki/map_visuals/iron_filled.png");
                image = ImageIO.read(file);
                return image;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(Objects.equals(this.resourceName, "stone"))
        {

            try {File file = new File("./CivSim/src/main/resources/com/civsim/Pliki/map_visuals/stone_filled.png");
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
        if(random == 0)
        {
                this.wood = 1;
                return "wood";
        }
        if(random == 1)
        {
                this.water = 1;
                return "water";
        }
        if(random == 2)
        {
                this.animals = 1;
                return "cow";
        }
        if(random == 3)
        {
                this.wheat = 1;
                return "wheat";
        }
        if(random == 4)
        {
                this.iron = 1;
                return "iron";
        }
        if (random == 5)
        {
                this.stone = 1;
                return "stone";
        }
        else return null;
    }
    public Boolean[] resourcesCompareVillage(Resources resources, Boolean ally)
    {
        Boolean[] good = new Boolean[2];
        if(ally) {
            if (resources.wood >= 3 && resources.wheat >= 2 && resources.animals >= 2) {
                good[0] = true;
                good[1] = false;
                return good;
            }
            if(resources.wood >= 7){
                good[0] = true;
                good[1] = true;
            }else{
                good[0] = false;
                good[1] = false;
            }

        } else{
            if (resources.wood >= 6 && resources.wheat >= 4 && resources.animals >= 4) {
                good[0] = true;
                good[1] = false;
                return good;
            }
            if(resources.wood >= 10){
                good[0] = true;
                good[1] = true;
            }else{
                good[0] = false;
                good[1] = false;
            }
        }
        return good;
    }
    public Boolean[] resourcesCompareCity(Resources resources, Boolean ally)
    {
        Boolean[] good = new Boolean[2];
        if(ally) {
            if (resources.stone >= 4 && resources.animals >= 2 && resources.iron >= 2 && resources.water>=2) {
                good[0] = true;
                good[1] = false;
                return good;
            }
            if(resources.stone >= 10){
                good[0] = true;
                good[1] = true;
            }else{
                good[0] = false;
                good[1] = false;
            }
        }
        else{
        if (resources.stone >= 7 && resources.animals >= 4 && resources.iron >= 4 && resources.water>=4) {
            good[0] = true;
            good[1] = false;
            return good;
        }
        if(resources.stone >= 12){
            good[0] = true;
            good[1] = true;
        }else{
            good[0] = false;
            good[1] = false;
        }
        }
        return good;
    }
    public boolean resourcesCompareMobileUnit(Resources resources, Boolean ally)
    {
        if(ally) {
            return resources.stone >= 7 && resources.animals >= 7 && resources.iron >= 7;
        }else
            return resources.stone >= 10 && resources.animals >= 10 && resources.iron >= 10;
    }

    public String getResourceName() {
        return resourceName;
    }


    public void udpateResources(Resources resources){
        this.iron+=resources.iron;
        this.wood+=resources.wood;
        this.stone+=resources.stone;
        this.water+=resources.water;
        this.animals+=resources.animals;
        this.wheat+=resources.wheat;
    }

}
