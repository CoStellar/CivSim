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
    private ArrayList<ArrayList<Position>> cityPositions = new ArrayList<>();
    Color[] civColor;
    Simulation(Integer civAmount, Integer simRoundAmount, MapSize mapSize) throws IOException {
        this.civAmount = civAmount;
        this.simRoundAmount = simRoundAmount;
        this.mapSize = mapSize;
        this.civColor = new Color[this.civAmount];
        for (int i = 0; i < this.civAmount; i++) {
            assert false;
            civilization.add(new Civilization(this.mapSize));
            civColor[i] = new Color(civilization.get(i).civColor.getRGB());
            civPosition.add(new ArrayList<>());
            civPosition.set(i, civilization.get(i).civFieldPosition);
            cityPositions.add(civilization.get(i).citiesPositions());
        }
        simulationMap = new Map(civPosition, this.mapSize, this.civAmount, civColor, this.cityPositions);
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
            for(int i = 0 ; i<civilization.size(); i++) {
                civilization.get(i).civExpand();
                this.cityPositions.set(i, civilization.get(i).citiesPositions());
            }
                try {
                   simulationMap.updateMap(civPosition, this.cityPositions);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                long currentTime = System.currentTimeMillis();

                System.out.println(currentTime);
                counter++;
            }

        }
    }
