package com.civsim;

import java.awt.*;

public class TraderUnit extends MobileUnits{

    private Position unitPostion;
    private Integer unitHealth;
    private String unitOwner;
    private Civilization allyCivilization;
    private Boolean unitAlive;

    public TraderUnit(Position unitPosition, Color unitColor, MapSize mapSize) {
        super(unitPosition, unitColor, mapSize);
    }
}
