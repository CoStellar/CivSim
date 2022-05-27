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
    private City[] cities;
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
        this.resourcesAmount.wood = 5;
        this.resourcesAmount.wheat = 5;
        this.resourcesAmount.animals = 5;

    }

        public void civExpand(){
                if(resourcesAmount.resourcesCompareVillage(resourcesAmount)){
                    if(cityCount == 0 || villageCount/cityCount <= 4){
                        this.civFieldPosition.add(drawRandomPositionAround(civFieldPosition));
                        this.villages.add(new Village(civFieldPosition.get(civSize)));
                        this.civSize++;
                        this.villageCount++;
                    }
                    /*else if(resourcesAmount.resourcesCompareCity(resourcesAmount)){

                    }*/
                }
        }

    public Position drawRandomPositionAround(ArrayList<Position> initialPosition) {
        Random random = new Random();

        Position drawnPosition = new Position(mapSize);
        Integer[][] tab = new Integer[initialPosition.size()][2];
        Integer[][] tab2 = new Integer[initialPosition.size()][2];
        Integer[][] tab3 = new Integer[initialPosition.size()][2];
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

                if(random.nextInt(2)==1){
                    tab2[i][0] = tab[i][0] + number;
                    tab2[i][1] = tab[i][1];
                }else {
                    tab2[i][0] = tab[i][0];
                    tab2[i][1] = tab[i][1] + number;
                }


            }while(tab2[i][1] == -1 || tab2[i][1] == mapSize.getMapSize()+1 || tab2[i][0] == -1 || tab2[i][0] == mapSize.getMapSize()+1 );
        }
        for(int i=0;i< initialPosition.size();i++){
            if(!Objects.equals(tab[i][0], tab2[i][0]) || !Objects.equals(tab[i][1], tab2[i][1])){
                tab3[i][0] = tab2[i][0];
                tab3[i][1] = tab2[i][1];
            }
        }
        do {
            number = random.nextInt(initialPosition.size());
        }while(tab3[number] == null);

        drawnPosition.x = tab3[number][0];
        drawnPosition.y = tab3[number][1];

        return drawnPosition;
    }

    public ArrayList<Position> passCivPosition(){
        return this.civFieldPosition;
    }

    public Integer getCivSize() {
        return civSize;
    }


}
