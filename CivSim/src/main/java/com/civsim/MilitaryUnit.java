package com.civsim;
import java.awt.*;

public class MilitaryUnit extends MobileUnits {
    private Position unitPostion;
    private Integer unitHealth;
    private final Integer attackRange = 3;



    private Color unitColor;
    private MapSize mapSize;
    public MilitaryUnit(Position unitPosition, Color unitColor, MapSize mapSize) {
        super(unitPosition, unitColor, mapSize);
        this.unitPostion = unitPosition;
        this.unitColor = unitColor;
        this.mapSize = mapSize;
        this.unitHealth  = 15;
    }
    public int getHealth(){
        return unitHealth;
    }
    public Color getUnitColor() {
        return unitColor;
    }
    public void updateHealth(int dmgRecieved){
        this.unitHealth = this.unitHealth - dmgRecieved;
    }
}
