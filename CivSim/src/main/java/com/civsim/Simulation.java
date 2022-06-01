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
    private final MapSize mapSize;
    Thread simThread;
    private final ArrayList<ArrayList<Position>> civPosition = new ArrayList<>();

    private final ArrayList<Position> militaryUnitPosition = new ArrayList<>();
    private final ArrayList<Position> traderUnitPosition = new ArrayList<>();
    private final ArrayList<Civilization> civilization = new ArrayList<>();
    private final ArrayList<ArrayList<Position>> cityPositions = new ArrayList<>();
    private ArrayList<ArrayList<MilitaryUnit>> militaryUnits = new ArrayList<>();
    private ArrayList<ArrayList<TraderUnit>> traderUnits = new ArrayList<>();
    private CivilizationUnits civUnits;
    Color[] civColor;
    Random random;
    private RandomEvents randomEvents;
    Simulation(Integer civAmount, Integer simRoundAmount, MapSize mapSize) throws IOException {
        this.civAmount = civAmount;
        this.simRoundAmount = simRoundAmount;
        this.mapSize = mapSize;
        this.civColor = new Color[this.civAmount];
        civUnits = new CivilizationUnits(mapSize);
        createPositionsFile();
        for (int i = 0; i < this.civAmount; i++) {
            assert false;
            civilization.add(new Civilization(this.mapSize));
            civColor[i] = new Color(civilization.get(i).civColor.getRGB());
            civPosition.add(new ArrayList<>());
            civPosition.set(i, civilization.get(i).civFieldPosition);
            cityPositions.add(civilization.get(i).citiesPositions());
            militaryUnitPosition.add(new Position(true));
            militaryUnits.add(new ArrayList<>());
            traderUnits.add(new ArrayList<>());
        }
        randomEvents = new RandomEvents(simRoundAmount, mapSize);

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
                long currentTime = System.currentTimeMillis();
                System.out.println(currentTime);
                TimeUnit.MILLISECONDS.sleep(1000);
                System.out.println(counter);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                randomEvents.eventPicker(counter, cityPositions);
                randomEvents.eventDeactivator(counter);
                for(int i=0;i<randomEvents.getEventName().size();i++)
                {
                    if(randomEvents.getRandomEventActive().get(i))
                        System.out.print(randomEvents.getEventName().get(i)+" ");
                }
                System.out.println(" ");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            for (int i = 0; i < civilization.size(); i++) {
                civilization.get(i).getResources(simulationMap.getResources(), randomEvents);
                civilization.get(i).civExpand();
                civilization.get(i).updatePopulationCount();
                this.cityPositions.set(i, civilization.get(i).citiesPositions());
                if (civilization.get(i).getMobileUnitsAmount() > 0) {
                    civilization.get(i).militaryUnit.updatePostion();
                    militaryUnits.add(new ArrayList<>());
                    militaryUnits.get(i).add(civilization.get(i).militaryUnit);
                    militaryUnitPosition.set(i, civilization.get(i).militaryUnit.getUnitPosition());
                }
            }
            civUnits.updateCivUnits(traderUnits,militaryUnits);
            civUnits.combat();
            militaryUnits = civUnits.getMilitaryUnits();

                for (int i = 0; i < civilization.size(); i++) {
                    if (civilization.get(i).getMobileUnitsAmount() > 0)
                    {
                        if(militaryUnits.get(i).get(0).getHealth()<=0)
                        {
                            civilization.get(i).unitKiller();
                            militaryUnitPosition.set(i,null);
                            militaryUnits.get(i).set(0,null);
                        }
                    }
                }
            ArrayList<ArrayList<MilitaryUnit>> swap = new ArrayList<>();
            for (int i = 0; i < civilization.size(); i++) {
                swap.add(new ArrayList<>());
                if (civilization.get(i).getMobileUnitsAmount() > 0) {
                if(militaryUnits.get(i).get(0)!=null) {
                    swap.get(i).add(militaryUnits.get(i).get(0));
                }}
            }
            militaryUnits = swap;

            try {
                simulationMap.updateMap(civPosition, cityPositions, militaryUnitPosition, randomEvents);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            checkHealth();
            counter++;
            }

        }

      /*  try {
            openInfoMenu();
        } catch (IOException | FontFormatException e) {
            throw new RuntimeException(e);
        }*/

        public void createPositionsFile() throws IOException {
                File positionsFile = new File("./CivSim/src/main/resources/com/civsim/Pliki/positions.txt");
                HashSet<Position> goodPositions = new HashSet<>();
                for(int i = 0; i<mapSize.getMapSize()*mapSize.getMapSize()/(2*civAmount)+civAmount; i++){
                    goodPositions.add(new Position(mapSize));
                }
                if(positionsFile.createNewFile()){
                    System.out.println("File Created");
                }else{
                    if(positionsFile.delete()){
                        if(positionsFile.createNewFile()){
                            System.out.println("File Created");
                        }
                    }
                }
            FileWriter fileWriter = new FileWriter("./CivSim/src/main/resources/com/civsim/Pliki/positions.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            for(Position i: goodPositions) {
                    printWriter.println(i.getX()+" "+i.getY());
            }
            printWriter.close();
        }

        public void checkHealth(){
            for(int i=0;i<civAmount;i++) {
                if (civilization.get(i).getMobileUnitsAmount() > 0) {
                for(int o=0;o<militaryUnits.get(i).size();o++) {
                    if(militaryUnits.get(i).size() > 0 && militaryUnits.get(i).get(o)!=null ){
                        System.out.println(militaryUnits.get(i).get(o).getUnitPosition().getX()+", "+militaryUnits.get(i).get(o).getUnitPosition().getY()+" Health: "+militaryUnits.get(i).get(o).getHealth());

                    }
                }
            }}
        }

    }
