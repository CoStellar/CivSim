package com.civsim;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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

    public void openInfoMenu() throws IOException, FontFormatException {
        new Information(this.civilization);
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
        public void createPositionsFile() throws IOException {
                File positionsFile = new File("./CivSim/src/main/resources/com/civsim/Pliki/Settings/positions.txt");
           // ArrayList<>
                if(positionsFile.createNewFile()){
                    System.out.println("File Created");
                }else{
                    if(positionsFile.delete()){
                        if(positionsFile.createNewFile()){
                            System.out.println("File Created");
                        }
                    }
                }
            FileWriter fileWriter = new FileWriter("./CivSim/src/main/resources/com/civsim/Pliki/Settings/positions.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            for(int i=0; i<((mapSize.getMapSize()*mapSize.getMapSize())/civAmount); i++) {

            }
        }//printWriter.printf()
    }
