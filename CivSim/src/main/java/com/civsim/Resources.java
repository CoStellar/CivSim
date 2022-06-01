package com.civsim;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import java.util.Objects;

public class Resources {
    private String resourceName;
    private Integer wood = 0;
    private Integer iron = 0;
    private Integer wheat = 0;
    private Integer animals = 0;
    private Integer stone = 0;
    private Integer water = 0;

    public Resources(){
        this.resourceName = drawResources();
    }
    public Resources(Boolean empty){
    }
    public BufferedImage getImg(){
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
    public boolean resourcesCompareVillage(Resources resources)
    {
        if(resources.wood >= 5 && resources.wheat >= 3 && resources.animals >= 2) {
            return true;
        }
        return resources.wood >= 10 || resources.wheat >= 10 || resources.animals >= 10;
    }
    public boolean resourcesCompareCity(Resources resources)
    {
        if(resources.stone >= 5 && resources.animals >= 2 && resources.iron >= 2) {
        return true;
        }
        return resources.stone >= 10 || resources.animals >= 10 || resources.iron >= 10;

    }
    public boolean resourcesCompareMobileUnit(Resources resources)
    {

        return resources.stone >= 10 && resources.animals >= 10 && resources.iron >= 10;

    }

    public String getResourceName() {
        return resourceName;
    }

    public Integer getWood() {
        return wood;
    }

    public Integer getIron() {
        return iron;
    }

    public Integer getWheat() {
        return wheat;
    }

    public Integer getAnimals() {
        return animals;
    }

    public Integer getStone() {
        return stone;
    }

    public Integer getWater() {
        return water;
    }

    public void setWood(Integer wood) {
        this.wood = wood;
    }

    public void setIron(Integer iron) {
        this.iron = iron;
    }

    public void setWheat(Integer wheat) {
        this.wheat = wheat;
    }

    public void setAnimals(Integer animals) {
        this.animals = animals;
    }

    public void setStone(Integer stone) {
        this.stone = stone;
    }

    public void setWater(Integer water) {
        this.water = water;
    }

    public void udpateResources(Resources resources){
        setIron(this.getIron()+resources.getIron());
        setWood(this.getWood()+resources.getWood());
        setStone(this.getStone()+resources.getStone());
        setWater(this.getWater()+resources.getWater());
        setAnimals(this.getAnimals()+resources.getAnimals());
        setWheat(this.getWheat()+resources.getWheat());
    }

}
