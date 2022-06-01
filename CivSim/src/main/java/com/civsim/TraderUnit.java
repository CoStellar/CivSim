package com.civsim;

import java.awt.*;

public class TraderUnit extends MobileUnits{

    private Position unitPosition;
    private Color unitColor;
    private MapSize mapSize;

    public TraderUnit(Position unitPosition, Color unitColor, MapSize mapSize) {
        super(unitPosition, unitColor, mapSize);
        this.unitPosition = unitPosition;
        this.unitColor = unitColor;
        this.mapSize = mapSize;
    }
}
