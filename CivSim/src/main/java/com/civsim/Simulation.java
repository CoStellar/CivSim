package com.civsim;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class Simulation implements Runnable {

    private final Position[] civPosition;
    private final Integer civAmount;
    private final Integer simRoundAmount;
    Map simulationMap;
    Thread simThread;
    MapSize mapSize;
    Civilization[] civilization;

    Simulation(Integer civAmount, Integer simRoundAmount, MapSize mapSize) throws IOException {
        this.civAmount = civAmount;
        this.simRoundAmount = simRoundAmount;
        this.mapSize = mapSize;
        civilization = new Civilization[civAmount];
        civPosition = new Position[civAmount];
        for (int i = 0; i < this.civAmount; i++) {
            civilization[i] = new Civilization(mapSize);
            civPosition[i] = new Position();
            civPosition[i] = civilization[i].passCivPosition();
            for (int o = 0; o < i; o++) {
                while (Objects.equals(civPosition[o].x, civPosition[i].x) && Objects.equals(civPosition[o].y, civPosition[i].y)) {
                    civilization[i] = new Civilization(mapSize);
                    civPosition[i] = civilization[i].passCivPosition();
                }
            }
        }

        simulationMap = new Map(getCivPosition(), this.mapSize, this.civAmount);
        startSimThread();
    }

    public Position[] getCivPosition() {
        Position[] positions = new Position[this.civAmount];
        System.arraycopy(civPosition, 0, positions, 0, this.civAmount);
        return positions;
    }

    public void startSimThread() {
        simThread = new Thread(this);
        simThread.start();
    }

    @Override
    public void run() {
        int counter = 1;
        while (simThread != null && counter <= simRoundAmount) {
            for (int i = this.civAmount - 1; i >= 0; i--) {
                civPosition[i] = new Position();

                try {
                    simulationMap.updateMap(civPosition);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                long currentTime = System.currentTimeMillis();
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(currentTime);
                counter++;
            }
        }
    }
}