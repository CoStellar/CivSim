package Project.Projekt;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;


public class Civilization extends JPanel {
    private Integer civSize;
    private Integer villageCount;
    private Integer cityCount;
    private Integer populationCount;
    private Integer mobileUnitsAmount;
    private Village[] villages;
    private City[] cities;
    public Resources resourcesAmount;
    Resources resourcesForCity = new Resources();
   Position[] civFieldPosition = new Position[20];
    public Civilization() {
        this.civSize = 1;
        this.villageCount = 1;
        this.cityCount = 0;
        this.civFieldPosition[0] = new Position();
    }

        public void civExpand(Resources resourcesAmount, Integer villageCount, Integer cityCount, Position[] civFieldPosition){
                if(resourcesAmount.resourcesCompareVillage(resourcesAmount)){
                    if(villageCount/cityCount <= 4){
                        this.civFieldPosition[civSize] = new Position();
                        this.civFieldPosition[civSize] = drawRandomPositionAround(civFieldPosition);
                        this.civSize++;
                        this.villageCount++;
                    }
                    /*else if(resourcesAmount.resourcesCompareCity(resourcesAmount)){

                    }*/
                }
        }

    public Position drawRandomPositionAround(Position[] initialPosition) {
        Random random = new Random();

        Position drawedPosition = new Position();
        Integer[][] tab = new Integer[initialPosition.length][2];
        Integer[][] tab2 = new Integer[initialPosition.length][2];
        Integer[][] tab3 = new Integer[initialPosition.length][2];
        Integer counter = 0, number;
        for (int i = 0; i < initialPosition.length; i++) {
            for (int o = 0; o < 2; o++) {
                if (o == 0)
                    tab[i][o] = initialPosition[counter].x;
                if (o == 1)
                    tab[i][o] = initialPosition[counter].y;
            }
            counter++;
        }
        for (int i = 0; i < initialPosition.length; i++) {
            random = new Random();
            do {
                do {
                    number = random.nextInt(3);
                } while (number == 1);
                number = number - 1;
                tab2[i][0] = tab2[i][0] + number;
                do {
                    number = random.nextInt(3);
                } while (number == 1);
                number = number - 1;
                tab2[i][1] = tab2[i][1] + number;
            }while(tab2[i][1] == -1 || tab2[i][1] == 26 || tab2[i][0] == -1 || tab2[i][0] == 26 );
        }
        for(int i=0;i< initialPosition.length;i++){
            if(!Objects.equals(tab[i][0], tab2[i][0]) && !Objects.equals(tab[i][1], tab2[i][1])){
                tab3[i][0] = tab2[i][0];
                tab3[i][1] = tab2[i][1];
            }
        }
        do {
            number = (Integer) random.nextInt(initialPosition.length);
        }while(tab3[number] == null);

        drawedPosition.x = tab3[number][0];
        drawedPosition.y = tab3[number][1];

        return drawedPosition;
    }

    public Position passCivPosition(){
        return this.civFieldPosition[0];
    }




}
