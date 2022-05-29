package com.civsim;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;


public class Civilization extends JPanel {


    private Integer civSize;
    private Integer villageCount=0;
    private Integer cityCount=0;
    private Integer populationCount;
    private Integer mobileUnitsAmount;
    private ArrayList<Village> villages = new ArrayList<>();
    private ArrayList<City> cities = new ArrayList<>();
    public Resources resourcesAmount = new Resources();
    public Color civColor;
    Resources resourcesForCity = new Resources();
    MapSize mapSize;
    public ArrayList<Position> civFieldPosition = new ArrayList<>();
    public Civilization(MapSize mapSize) {
        this.civColor = new Color((int)(Math.random() * 0x1000000));
        this.mapSize = mapSize;
        this.civSize = 1;
        this.civFieldPosition.add(new Position(this.mapSize));
        villages.add(new Village(civFieldPosition.get(villageCount)));
        this.villageCount++;
        this.cityCount = 0;
        this.resourcesAmount.setWood(200);
        this.resourcesAmount.setWheat(200);
        this.resourcesAmount.setAnimals(200);
        this.resourcesAmount.setWater(200);
        this.resourcesAmount.setStone(200);
        this.resourcesAmount.setIron(200);

    }

        public void civExpand(){
        Random random = new Random();
        int number;
                if(resourcesAmount.resourcesCompareVillage(resourcesAmount)){
                    if(villageCount/(cityCount+1) <= 4){
                        this.civFieldPosition.add(drawRandomPositionAround(civFieldPosition));
                        this.villages.add(new Village(civFieldPosition.get(civSize)));
                        this.civSize++;
                        this.villageCount++;
                        this.resourcesAmount.setWood(resourcesAmount.getWood()-5);
                        this.resourcesAmount.setWheat(resourcesAmount.getWheat()-2);
                        this.resourcesAmount.setAnimals(resourcesAmount.getAnimals()-2);
                    }else if(resourcesAmount.resourcesCompareCity(resourcesAmount)){
                        number=random.nextInt(villageCount);
                        this.cities.add(new City(civFieldPosition.get(number)));
                        this.villages.remove(number);
                        this.villageCount--;
                        this.cityCount++;
                        this.resourcesAmount.setAnimals(resourcesAmount.getAnimals()-2);
                        this.resourcesAmount.setStone(resourcesAmount.getStone()-5);
                        this.resourcesAmount.setIron(resourcesAmount.getIron()-2);
                    }

                }else if(resourcesAmount.resourcesCompareCity(resourcesAmount)){
                    number  = random.nextInt(villageCount);
                    this.cities.add(new City(civFieldPosition.get(number)));
                    this.villages.remove(number);
                    this.villageCount--;
                    this.cityCount++;
                    this.resourcesAmount.setAnimals(resourcesAmount.getAnimals()-2);
                    this.resourcesAmount.setStone(resourcesAmount.getStone()-5);
                    this.resourcesAmount.setIron(resourcesAmount.getIron()-2);
                    }

        }

    public Position drawRandomPositionAround(ArrayList<Position> initialPosition) {
        Random random = new Random();

        Position drawnPosition = new Position(mapSize);
        Integer[][] tab = new Integer[initialPosition.size()][2];
        Integer[][] tab2 = new Integer[initialPosition.size()][2];
        ArrayList<Position> tab3 = new ArrayList<>();
        ArrayList<Position> checkPosition = new ArrayList<>();
        do {
            tab3.clear();
            checkPosition.clear();
            int counter = 0, number;
            for (int i = 0; i < initialPosition.size(); i++) {
                for (int o = 0; o < 2; o++) {
                    if (o == 0)
                        tab[i][o] = initialPosition.get(counter).x;
                    if (o == 1)
                        tab[i][o] = initialPosition.get(counter).y;
                }
                counter++;
            }
            for (int i = 0; i < initialPosition.size(); i++) {
                random = new Random();
                do {
                    do {
                        number = random.nextInt(3);
                    } while (number == 1);
                    number = number - 1;

                    if (random.nextInt(2) == 1) {
                        tab2[i][0] = tab[i][0] + number;
                        tab2[i][1] = tab[i][1];
                    } else {
                        tab2[i][0] = tab[i][0];
                        tab2[i][1] = tab[i][1] + number;
                    }
                } while (tab2[i][1] == -1 || Objects.equals(tab2[i][1], mapSize.getMapSize()) || tab2[i][0] == -1 || Objects.equals(tab2[i][0], mapSize.getMapSize()));
            }
            counter = 0;
            for (int l = 0; l < initialPosition.size(); l++) {
                tab3.add(new Position(tab2[l][0], tab2[l][1]));
                counter++;
            }
            for (int i=0;i<initialPosition.size(); i++) {
                if (!initialPosition.contains(tab3.get(i))) {
                    checkPosition.add(tab3.get(i));
                }
            }
            number = random.nextInt(checkPosition.size());
            drawnPosition = checkPosition.get(number);
        }while(initialPosition.contains(drawnPosition));
        return drawnPosition;
    }

    public ArrayList<Position> passCivPosition(){
        return this.civFieldPosition;
    }

    public Integer getCivSize() {
        return civSize;
    }
    public ArrayList<Position> citiesPositions(){
        ArrayList<Position> positionsToReturn = new ArrayList<>();
        for(int i = 0; i<cityCount; i++){
            positionsToReturn.add(cities.get(i).getCityPosition());
        }
        return positionsToReturn;
    }


}
