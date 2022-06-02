package com.civsim;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class TraderUnit extends MobileUnits{
    @Override
    public Position getUnitPosition() {
        return unitPosition;
    }

    private Position unitPosition;

    public Color getUnitColor() {
        return unitColor;
    }

    private Color unitColor;
    private MapSize border;
    public TraderUnit(Position unitPosition, Color unitColor, MapSize mapSize)
    {
        super(unitPosition, unitColor, mapSize);
        this.unitPosition = unitPosition;
        this.unitColor = unitColor;
        this.border = mapSize;
    }
    public void updatePosition()
    {
        Random random = new Random();
        int[][] tab1 = new int[4][2];

        ArrayList<Position> tab2 = new ArrayList<>();
        int number;

        for(int i = 0; i < 4; i++)
        {
            if(i == 0)
            {
                tab1[i][0] = unitPosition.getX() +1;
                tab1[i][1] = unitPosition.getY();
            }
            if(i == 1)
            {
                tab1[i][0] = unitPosition.getX() ;
                tab1[i][1] = unitPosition.getY() +1;
            }
            if(i == 2)
            {
                tab1[i][0] = unitPosition.getX()-1 ;
                tab1[i][1] = unitPosition.getY() ;
            }
            if(i == 3)
            {
                tab1[i][0] = unitPosition.getX();
                tab1[i][1] = unitPosition.getY()-1;
            }
        }
        for(int i = 0; i < 4; i++)
        {
            tab2.add(new Position(tab1[i][0],tab1[i][1]));
        }
        tab2.removeIf(position -> position.getX() < 0 || position.getX() >= border.getMapSize() || position.getY() < 0 || position.getY() >= border.getMapSize());
        number = random.nextInt(tab2.size());
        unitPosition = tab2.get(number);
    }


}
