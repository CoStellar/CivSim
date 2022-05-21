package com.civsim;

import java.io.IOException;

public class Simulation {

    private Civilization[] civilization = new Civilization[4];
    public Position[] civPosition = new Position[4];
    Simulation() throws IOException {
        ControlPanel controlPanel = new ControlPanel();


        civilization[0] = new Civilization();
        civilization[1] = new Civilization();
        civilization[2] = new Civilization();
        civilization[3] = new Civilization();
        civPosition[0] = civilization[0].passCivPosition();
        civPosition[1] = civilization[1].passCivPosition();
        civPosition[2] = civilization[2].passCivPosition();
        civPosition[3] = civilization[3].passCivPosition();
        Map simulation = new Map(getCivPosition());

    }
    public Position[] getCivPosition(){
        Position[] positions = new Position[4];
        positions[0] = civPosition[0];
        positions[1] = civPosition[1];
        positions[2] = civPosition[2];
        positions[3] = civPosition[3];
        return positions;
    }


}
