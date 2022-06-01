package com.civsim;
import java.awt.*;

public class MilitaryUnit extends MobileUnits
{
    private Integer unitHealth;
    private final Color unitColor;

    public MilitaryUnit(Position unitPosition, Color unitColor, MapSize mapSize)
    {
        super(unitPosition, unitColor, mapSize);
        this.unitColor = unitColor;
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
