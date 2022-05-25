package com.civsim;


import java.io.IOException;

public class Simulation {

    private final Position[] civPosition;
    private final Integer civAmount;
    private Integer simRoundAmount;

    Simulation(Integer civAmount, Integer simRoundAmount, MapSize mapSize) throws IOException {
        this.civAmount = civAmount;
        this.simRoundAmount = simRoundAmount;


        Civilization[] civilization = new Civilization[civAmount];
        civPosition = new Position[civAmount];
        for(int i=0; i<this.civAmount;i++) {
            civilization[i] = new Civilization(mapSize);
        }
        for(int i=0; i<this.civAmount;i++) {
            civPosition[i] = new Position();
            civPosition[i] = civilization[i].passCivPosition();
        }

        Map simulationMap = new Map(getCivPosition(), mapSize, this.civAmount);
    }
    public Position[] getCivPosition(){
        Position[] positions = new Position[this.civAmount];
        System.arraycopy(civPosition, 0, positions, 0, this.civAmount);
        return positions;
    }

}
