package com.civsim;

import java.awt.*;

public class TraderUnit extends MobileUnits{

    private Position unitPosition;
    private Color allyCivilization;

    public TraderUnit(Position unitPosition, Color unitColor, MapSize mapSize) {
        super(unitPosition, unitColor, mapSize);
        this.unitPosition = unitPosition;

    }
}
