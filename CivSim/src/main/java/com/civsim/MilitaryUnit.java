package com.civsim;

import java.awt.*;

public class MilitaryUnit extends MobileUnits {

    private Position unitPostion;
    private Integer unitHealth;
    private Civilization unitOwner;
    private Integer attackRange;
    private Position[] enemyPostion;
    private Boolean unitAlive;

    public MilitaryUnit(Position unitPosition, Color unitColor, MapSize mapSize) {
        super(unitPosition, unitColor, mapSize);
    }
}
