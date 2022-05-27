package com.civsim;

import java.awt.*;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Simulation implements Runnable {
    private final int civAmount;
    private final Integer simRoundAmount;
    private final Map simulationMap;
    private MapSize mapSize;
    Thread simThread;
    private final ArrayList<ArrayList<Position>> civPosition = new ArrayList<>();

    private final ArrayList<Civilization> civilization = new ArrayList<>();
    Color[] civColor;
    Simulation(Integer civAmount, Integer simRoundAmount, MapSize mapSize) throws IOException {
        this.civAmount = civAmount;
        this.simRoundAmount = simRoundAmount;
        this.mapSize = mapSize;
        this.civColor = new Color[civAmount];
        for (int i = 0; i < this.civAmount; i++) {
            assert false;
            civilization.add(new Civilization(mapSize));
         //   civilization.get(i).civExpand( civilization.get(i).resourcesAmount,1,0,civilization.get(i).civFieldPosition);
            civColor[i] = new Color(civilization.get(i).civColor.getRGB());
            civPosition.add(new ArrayList<>());
            civPosition.get(i).add(new Position(mapSize));
            civPosition.set(i, civilization.get(i).civFieldPosition);

        }

        simulationMap = new Map(civPosition, mapSize, this.civAmount, civColor);
        startSimThread();
    }

    public ArrayList<ArrayList<Position>> getCivPosition() {
        return this.civPosition;
    }

    public void startSimThread() {
        simThread = new Thread(this);
        simThread.start();
    }

    @Override
    public void run() {
        int counter = 1;
        while (simThread != null && counter <= simRoundAmount) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            for (int i = 0; i < this.civAmount; i++) {
                ArrayList <Position> swapOut = new ArrayList<Position>();
                for(int o=0; o<civilization.get(i).getCivSize(); o++) {
                    swapOut.add(new Position());
                    swapOut.set(o, new Position(mapSize));
                }
                civPosition.set(i, swapOut);
            }

                try {

                   simulationMap.updateMap(civPosition);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                long currentTime = System.currentTimeMillis();

                System.out.println(currentTime);
                counter++;
            }

        }
    }
