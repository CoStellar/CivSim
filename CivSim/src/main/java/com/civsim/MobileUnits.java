package com.civsim;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class MobileUnits {

    private Position unitPosition;
    private Integer unitHealth;
    private String unitOwner;
    private Color color;
    private MapSize border;

    public Position getUnitPosition() {
        return unitPosition;
    }

    public MobileUnits(Position unitPosition, Color unitColor, MapSize mapSize) {

        this.color = unitColor;
        this.unitPosition = unitPosition;
        this.unitHealth = 10;

        this.border = mapSize;

    }

    public void updatePostion() {
        Random random = new Random();
        int[][] tab1 = new int[4][2];

        ArrayList<Position> tab2 = new ArrayList<>();
        ArrayList<Position> checkPosition = new ArrayList<>();
        int number;

       for(int i = 0; i < 4; i++){
           if(i == 0){
           tab1[i][0] = unitPosition.getX() +1;
           tab1[i][1] = unitPosition.getY();
       }
           if(i == 1){
               tab1[i][0] = unitPosition.getX() ;
               tab1[i][1] = unitPosition.getY() +1;
           }
           if(i == 2){
               tab1[i][0] = unitPosition.getX()-1 ;
               tab1[i][1] = unitPosition.getY() ;
           }
           if(i == 3){
               tab1[i][0] = unitPosition.getX();
               tab1[i][1] = unitPosition.getY()-1;
           }
       }

        for(int i = 0; i < 4; i++){
            tab2.add(new Position(tab1[i][0],tab1[i][1]));
        }

        tab2.removeIf(position -> position.getX() < 0 || position.getX() >= border.getMapSize() || position.getY() < 0 || position.getY() >= border.getMapSize());
        number = random.nextInt(tab2.size());
        unitPosition = tab2.get(number);
    }
}
