package com.civsim;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Random;


public class Civilization extends JPanel {
    private Integer civSize;
    private Integer villageCount=0;
    private Integer cityCount;
    private Integer populationCount=0;
    private Integer mobileUnitsAmount;
    private final ArrayList<Village> villages = new ArrayList<>();
    private final ArrayList<City> cities = new ArrayList<>();
    public Resources resourcesAmount = new Resources();
    public Color civColor;
    MapSize mapSize;

    public MobileUnits mobileUnits;
    public ArrayList<Position> civFieldPosition = new ArrayList<>();
    public Civilization(MapSize mapSize) throws IOException {
        this.civColor = new Color((int)(Math.random() * 0x1000000));
        this.mapSize = mapSize;
        this.civSize = 1;
        this.civFieldPosition.add(new Position());
        villages.add(new Village(civFieldPosition.get(villageCount)));
        this.villageCount++;
        this.cityCount = 0;
        this.resourcesAmount.setWood(1);
        this.resourcesAmount.setWheat(1);
        this.resourcesAmount.setAnimals(1);
        this.resourcesAmount.setWater(1);
        this.resourcesAmount.setStone(1);
        this.resourcesAmount.setIron(1);
        updatePopulationCount();
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
                    }else if(resourcesAmount.resourcesCompareCity(resourcesAmount) && villageCount>0){
                        number=random.nextInt(villageCount);
                        this.cities.add(new City(civFieldPosition.get(number)));
                        this.villages.remove(number);
                        this.villageCount--;
                        this.cityCount++;
                        this.resourcesAmount.setAnimals(resourcesAmount.getAnimals()-2);
                        this.resourcesAmount.setStone(resourcesAmount.getStone()-5);
                        this.resourcesAmount.setIron(resourcesAmount.getIron()-2);
                    }

                }else if(resourcesAmount.resourcesCompareCity(resourcesAmount) && villageCount>0){
                    number  = random.nextInt(villageCount);
                    this.cities.add(new City(civFieldPosition.get(number)));
                    this.villages.remove(number);
                    this.villageCount--;
                    this.cityCount++;
                    this.resourcesAmount.setAnimals(resourcesAmount.getAnimals()-2);
                    this.resourcesAmount.setStone(resourcesAmount.getStone()-5);
                    this.resourcesAmount.setIron(resourcesAmount.getIron()-2);
                    }
                if(resourcesAmount.resourcesCompareMobileUnit(resourcesAmount) && cityCount > 0){
                    this.resourcesAmount.setAnimals(resourcesAmount.getAnimals()-10);
                    this.resourcesAmount.setStone(resourcesAmount.getStone()-10);
                    this.resourcesAmount.setIron(resourcesAmount.getIron()-10);
                    this.mobileUnits = new MobileUnits(citiesPositions().get(random.nextInt(cityCount)),this.civColor,this.mapSize);

                }

        }

    public Position drawRandomPositionAround(ArrayList<Position> initialPosition) {
        Random random = new Random();
        Position drawnPosition;
        Integer[][] tab1 = new Integer[initialPosition.size()][2];
        Integer[][] tab2 = new Integer[initialPosition.size()][2];
        ArrayList<Position> tab3 = new ArrayList<>();
        ArrayList<Position> checkPosition = new ArrayList<>();
        do {
            tab3.clear();
            checkPosition.clear();
            int number;

            for (int i = 0; i < initialPosition.size(); i++) {
                random = new Random();
                    do {
                        number = random.nextInt(3);
                    } while (number == 1);
                    number = number - 1;

                    if (random.nextInt(2) == 1) {
                        tab1[i][0] = initialPosition.get(i).x + number;
                        tab1[i][1] = initialPosition.get(i).y;
                        tab2[i][0] = initialPosition.get(i).x - number;
                        tab2[i][1] = initialPosition.get(i).y;
                    } else {
                        tab1[i][0] = initialPosition.get(i).x;
                        tab1[i][1] = initialPosition.get(i).y + number;
                        tab2[i][0] = initialPosition.get(i).x;
                        tab2[i][1] = initialPosition.get(i).y- number;
                    }
            }
            for (int l = 0; l < initialPosition.size(); l++) {
                tab3.add(new Position(tab1[l][0], tab1[l][1]));
                tab3.add(new Position(tab2[l][0], tab2[l][1]));
            }
            for (Position position : tab3) {
                if (!initialPosition.contains(position)) {
                    checkPosition.add(position);
                }
            }
            for (Position position : tab3) {
                if (position.getX() < 0 || position.getX() >= mapSize.getMapSize() || position.getY() < 0 || position.getY() >= mapSize.getMapSize()) {
                    checkPosition.remove(position);
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
    public void getResources(Resources[][] getResources){
        ArrayList<Position> cityPositions = new ArrayList<>();
        HashSet<Position> harvestPositions = new HashSet<>();
        for (City city : cities) {
            cityPositions.add(city.getCityPosition());
        }

        Integer[][] tab2 = new Integer[civFieldPosition.size()][2];
        Integer[][] tab4 = new Integer[civFieldPosition.size()][2];
        ArrayList<Position> tab3 = new ArrayList<>();
        ArrayList<Position> checkPosition = new ArrayList<>();
        Random random;
        int number;

            for (int i = 0; i < civFieldPosition.size(); i++) {
                random = new Random();
                do {
                    do {
                        number = random.nextInt(3);
                    } while (number == 1);
                    number = number - 1;
                    if (random.nextInt(2) == 1) {
                        tab2[i][0] = civFieldPosition.get(i).x + number;
                        tab2[i][1] = civFieldPosition.get(i).y;
                        tab4[i][0] = civFieldPosition.get(i).x - number;
                        tab4[i][1] = civFieldPosition.get(i).y;
                    } else {
                        tab2[i][0] = civFieldPosition.get(i).x;
                        tab2[i][1] = civFieldPosition.get(i).y + number;
                        tab4[i][0] = civFieldPosition.get(i).x;
                        tab4[i][1] = civFieldPosition.get(i).y - number;
                    }
                } while (tab2[i][1] == -1 || Objects.equals(tab2[i][1], mapSize.getMapSize()) || tab2[i][0] == -1 || Objects.equals(tab2[i][0], mapSize.getMapSize()) || tab4[i][1] == -1 || Objects.equals(tab4[i][1], mapSize.getMapSize()) || tab4[i][0] == -1 || Objects.equals(tab4[i][0], mapSize.getMapSize()));
            }
            for (int l = 0; l < civFieldPosition.size(); l++) {
                tab3.add(new Position(tab2[l][0], tab2[l][1]));
                tab3.add(new Position(tab4[l][0], tab4[l][1]));
            }
        for (Position position : tab3) {
            if (!civFieldPosition.contains(position)) {
                checkPosition.add(position);
            }
        }
        for(int x=0; x<mapSize.getMapSize(); x++){
            for(int y=0;y<mapSize.getMapSize(); y++){
                for (Position position : civFieldPosition) {
                    if (position.getX() == x && position.getY() == y) {
                        harvestPositions.add(position);
                    }
                }
                for (Position position : checkPosition) {
                    if (position.getX() == x && position.getY() == y) {
                        harvestPositions.add(position);
                    }
                }
            }
            }
        for(int x=0; x<mapSize.getMapSize(); x++){
            for(int y=0;y<mapSize.getMapSize(); y++){
                for (Position cityPosition : cityPositions) {
                    harvestPositions.remove(cityPosition);
                }
            }
        }
        Resources dumpResources = new Resources(true);
        for(Position i : harvestPositions){
            dumpResources.udpateResources(getResources[i.getX()][i.getY()]);
            }

        this.resourcesAmount.udpateResources(dumpResources);
    }
    public void updatePopulationCount(){
        for (Village village : villages) {
            populationCount += village.getVillagersCount();
        }
        for (City cities : cities) {
            populationCount += cities.getCitizensCount();
        }
    }

}



