package com.civsim;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Random;


public class Civilization extends JPanel
{
    private Integer civSize;
    private Integer villageCount=0;
    private Integer cityCount;
    private Integer populationCount=0;
    private Integer mobileUnitsAmount=0;
    private Integer traderUnitsAmount = 0;
    private Integer militaryUnitsAmount =0;
    private final ArrayList<Village> villages = new ArrayList<>();
    private final ArrayList<City> cities = new ArrayList<>();
    public Resources resourcesAmount = new Resources();
    public Color civColor;
    private final MapSize mapSize;
    public MilitaryUnit militaryUnit = null;
    public TraderUnit traderUnit = null;
    public ArrayList<Position> civFieldPosition = new ArrayList<>();
    public Boolean hasAlly = false;
    public Civilization(MapSize mapSize) throws IOException
    {
        this.civColor = new Color((int)(Math.random() * 0x1000000));
        this.mapSize = mapSize;
        this.civSize = 1;
        this.civFieldPosition.add(new Position());
        villages.add(new Village());
        this.villageCount++;
        this.cityCount = 0;
        this.resourcesAmount.wood = 0;
        this.resourcesAmount.wheat = 0;
        this.resourcesAmount.animals = 0;
        this.resourcesAmount.water = 0;
        this.resourcesAmount.stone = 0;
        this.resourcesAmount.iron = 0;
        updatePopulationCount();
    }

    public Integer getTraderUnitsAmount()
    {
        return traderUnitsAmount;
    }

    public Integer getMilitaryUnitsAmount()
    {
        return militaryUnitsAmount;
    }

    public void civExpand()
    {
        Random random = new Random();
        int number;
        Boolean[] city =resourcesAmount.resourcesCompareCity(resourcesAmount, hasAlly);
        Boolean[] village =resourcesAmount.resourcesCompareVillage(resourcesAmount, hasAlly);
        if(village[0])
        {
            if(villageCount/(cityCount+1) < 5)
            {
                this.civFieldPosition.add(drawRandomPositionAround(civFieldPosition));
                this.villages.add(new Village());
                this.civSize++;
                this.villageCount++;
                if(hasAlly) {
                    if(village[1]) {
                        this.resourcesAmount.wood-=4;
                        this.resourcesAmount.wheat-=2;
                        this.resourcesAmount.animals-=2;
                    }else
                        this.resourcesAmount.wood-=7;

                }else{
                    if(village[1]) {
                        this.resourcesAmount.wood-=7;
                        this.resourcesAmount.wheat-=5;
                        this.resourcesAmount.animals-=6;
                    }else
                        this.resourcesAmount.wood-=10;

                }
            }else if(city[0] && villageCount>0)
            {
                number=random.nextInt(villageCount);
                this.cities.add(new City(civFieldPosition.get(number)));
                this.villages.remove(number);
                this.villageCount--;
                this.cityCount++;
                if(hasAlly) {
                    if(city[1]){
                        this.resourcesAmount.animals-=4;
                        this.resourcesAmount.stone-=4;
                        this.resourcesAmount.iron-=3;
                        this.resourcesAmount.water-=3;
                    }else
                        this.resourcesAmount.stone-=10;
                }else{
                    if(city[1]){
                        this.resourcesAmount.animals-=7;
                        this.resourcesAmount.stone-=4;
                        this.resourcesAmount.iron-=4;
                        this.resourcesAmount.water-=4;
                    } else
                        this.resourcesAmount.stone-=12;
                }

        }
        }
        else if(city[0] && villageCount>0)
        {
            number  = random.nextInt(villageCount);
            this.cities.add(new City(civFieldPosition.get(number)));
            this.villages.remove(number);
            this.villageCount--;
            this.cityCount++;
            if(hasAlly) {
                if(city[1]){
                    this.resourcesAmount.animals-=4;
                    this.resourcesAmount.stone-=3;
                    this.resourcesAmount.iron-=3;
                    this.resourcesAmount.water-=3;
                }else
                    this.resourcesAmount.stone-=10;
            }else{
                if(city[1]){
                this.resourcesAmount.animals-=7;
                this.resourcesAmount.stone-=4;
                this.resourcesAmount.iron-=4;
                this.resourcesAmount.water-=4;
                } else
                    this.resourcesAmount.stone-=12;
            }
        }
        if(resourcesAmount.resourcesCompareMobileUnit(resourcesAmount, hasAlly) && cityCount > 0)
        {
            if(random.nextInt(2)==1){
                if(this.militaryUnit == null) {
                    if(hasAlly) {
                        this.resourcesAmount.animals-=7;
                        this.resourcesAmount.stone-=7;
                        this.resourcesAmount.iron-=7;
                    }else{
                        this.resourcesAmount.animals-=10;
                        this.resourcesAmount.stone-=10;
                        this.resourcesAmount.iron-=10;
                    }
                    this.militaryUnit = new MilitaryUnit(citiesPositions().get(random.nextInt(cityCount)), this.civColor, this.mapSize);
                    this.mobileUnitsAmount++;
                    this.militaryUnitsAmount++;
                }
            }else{
                if(this.militaryUnit == null) {
                this.resourcesAmount.animals-=15;
                this.resourcesAmount.stone-=15;
                this.resourcesAmount.iron-=15;
                this.traderUnit = new TraderUnit(citiesPositions().get(random.nextInt(cityCount)),this.civColor,this.mapSize);
                this.mobileUnitsAmount++;
                this.traderUnitsAmount++;}
            }

        }

    }

    public Position drawRandomPositionAround(ArrayList<Position> initialPosition)
    {
        Random random = new Random();
        Position drawnPosition;
        Integer[][] tab1 = new Integer[initialPosition.size()][2];
        Integer[][] tab2 = new Integer[initialPosition.size()][2];
        Integer[][] tab5 = new Integer[initialPosition.size()][2];
        Integer[][] tab4 = new Integer[initialPosition.size()][2];
        ArrayList<Position> tab3 = new ArrayList<>();
        ArrayList<Position> checkPosition = new ArrayList<>();
        int number;

        for (int i = 0; i < initialPosition.size(); i++)
        {
            random = new Random();
            do {
                number = random.nextInt(3);
            } while (number == 1);
            number = number - 1;
            tab1[i][0] = initialPosition.get(i).getX() + number;
            tab1[i][1] = initialPosition.get(i).getY();
            tab2[i][0] = initialPosition.get(i).getX() - number;
            tab2[i][1] = initialPosition.get(i).getY();
            tab5[i][0] = initialPosition.get(i).getX();
            tab5[i][1] = initialPosition.get(i).getY() + number;
            tab4[i][0] = initialPosition.get(i).getX();
            tab4[i][1] = initialPosition.get(i).getY() - number;
            if(!(tab1[i][0] < 0) && !(tab1[i][0] >=mapSize.getMapSize()) && !(tab1[i][1] < 0) && !(tab1[i][1] >=mapSize.getMapSize())) tab3.add(new Position(tab1[i][0], tab1[i][1]));
            if(!(tab2[i][0] < 0) && !(tab2[i][0] >=mapSize.getMapSize()) && !(tab2[i][1] < 0) && !(tab2[i][1] >=mapSize.getMapSize())) tab3.add(new Position(tab2[i][0], tab2[i][1]));
            if(!(tab5[i][0] < 0) && !(tab5[i][0] >=mapSize.getMapSize()) && !(tab5[i][1] < 0) && !(tab5[i][1] >=mapSize.getMapSize())) tab3.add(new Position(tab5[i][0], tab5[i][1]));
            if(!(tab4[i][0] < 0) && !(tab4[i][0] >=mapSize.getMapSize()) && !(tab4[i][1] < 0) && !(tab4[i][1] >=mapSize.getMapSize())) tab3.add(new Position(tab4[i][0], tab4[i][1]));
        }
        for (Position position : tab3)
        {
            if (!initialPosition.contains(position))
            {
                checkPosition.add(position);
            }
        }
        number = random.nextInt(checkPosition.size());
        drawnPosition = checkPosition.get(number);
        return drawnPosition;
    }
    public Integer getCivSize()
    {
        return civSize;
    }
    public ArrayList<Position> citiesPositions()
    {
        ArrayList<Position> positionsToReturn = new ArrayList<>();
        for(int i = 0; i<cityCount; i++)
        {
            positionsToReturn.add(cities.get(i).getCityPosition());
        }
        return positionsToReturn;
    }
    public void getResources(Resources[][] getResources)
    {
        ArrayList<Position> cityPositions = new ArrayList<>();
        for (City city : cities)
        {
            cityPositions.add(city.getCityPosition());
        }
        Integer[][] tab2 = new Integer[civFieldPosition.size()][2];
        Integer[][] tab4 = new Integer[civFieldPosition.size()][2];
        Integer[][] tab5 = new Integer[civFieldPosition.size()][2];
        Integer[][] tab1 = new Integer[civFieldPosition.size()][2];
        HashSet<Position> harvestPositions = new HashSet<>();
        Random random;
        int number;
            for (int i = 0; i < civFieldPosition.size(); i++)
            {
                random = new Random();
                    do {
                        number = random.nextInt(3);
                    } while (number == 1);
                    number = number - 1;
                        tab2[i][0] = civFieldPosition.get(i).getX() + number;
                        tab2[i][1] = civFieldPosition.get(i).getY();
                        tab4[i][0] = civFieldPosition.get(i).getX() - number;
                        tab4[i][1] = civFieldPosition.get(i).getY();
                        tab1[i][0] = civFieldPosition.get(i).getX();
                        tab1[i][1] = civFieldPosition.get(i).getY() + number;
                        tab5[i][0] = civFieldPosition.get(i).getX();
                        tab5[i][1] = civFieldPosition.get(i).getY() - number;
                }
            for (int l = 0; l < civFieldPosition.size(); l++)
            {
                harvestPositions.add(new Position(tab2[l][0], tab2[l][1]));
                harvestPositions.add(new Position(tab4[l][0], tab4[l][1]));
                harvestPositions.add(new Position(tab1[l][0], tab1[l][1]));
                harvestPositions.add(new Position(tab5[l][0], tab5[l][1]));
            }
        harvestPositions.addAll(civFieldPosition);
        for (Position cityPosition : cityPositions)
        {
            harvestPositions.remove(cityPosition);
        }
        harvestPositions.removeIf(i -> Objects.equals(i.getX() , -1) || Objects.equals(i.getX(), mapSize.getMapSize()) || Objects.equals(i.getY() , -1) || Objects.equals(i.getY(), mapSize.getMapSize()));
        Resources dumpResources = new Resources(true);
        for(Position i : harvestPositions)
        {
            dumpResources.udpateResources(getResources[i.getX()][i.getY()]);
        }
        this.resourcesAmount.udpateResources(dumpResources);
    }
    public void updatePopulationCount()
    {
        int x = 0;
        for (Village village : villages)
        {
            x += village.getVillagersCount();
        }
        for (City cities : cities)
        {
            x += cities.getCitizensCount();
        }
        populationCount = x;
    }
    public Integer getMobileUnitsAmount() {
        return mobileUnitsAmount;
    }
    public void unitKiller()
    {
        this.militaryUnit = null;
        this.mobileUnitsAmount--;
        this.militaryUnitsAmount--;
    }
    public Boolean getHasAlly() {
        return hasAlly;
    }

    public Integer getPopulationCount() {
        return populationCount;
    }
}



