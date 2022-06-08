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
    private Thread simThread;
    private final ArrayList<ArrayList<Position>> civPosition = new ArrayList<>();
    private final ArrayList<Position> militaryUnitPosition = new ArrayList<>();
    private final ArrayList<Position> traderUnitPosition = new ArrayList<>();
    private final ArrayList<Civilization> civilization = new ArrayList<>();
    private final ArrayList<ArrayList<Position>> cityPositions = new ArrayList<>();
    private ArrayList<ArrayList<MilitaryUnit>> militaryUnits = new ArrayList<>();
    private ArrayList<ArrayList<TraderUnit>> traderUnits = new ArrayList<>();
    private final CivilizationUnits civUnits;
    Color[] civColor;
    private final RandomEvents randomEvents;
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
            traderUnitPosition.add(new Position(true));
            militaryUnits.add(new ArrayList<>());
            traderUnits.add(new ArrayList<>());
        }
        randomEvents = new RandomEvents(mapSize);

        simulationMap = new Map(civPosition, this.mapSize, this.civAmount, civColor, this.cityPositions);
        createDataSheet();
        createPopulationSheet();
        startSimThread();
    }
    public void startSimThread() {
        simThread = new Thread(this);
        simThread.start();
    }
    public void openInfoMenu() throws IOException, FontFormatException
    {
        new Information();
    }
    @Override
    public void run() {
        ArrayList<Integer[]> trade;
        FileWriter fileWriter, fileWriter1;
        PrintWriter printWriter, printWriter1;
        int counter = 1;
        double timeStart = System.currentTimeMillis();
        double currentTime;
        long timeStartRound;
        ArrayList<Integer> maxedMap = new ArrayList<>();
        while (simThread != null && counter <= simRoundAmount && !maxedMap.contains(mapSize.getMapSize()* mapSize.getMapSize())) {
            timeStartRound = System.currentTimeMillis();
            try {
                fileWriter = new FileWriter("./CivSim/src/main/resources/com/civsim/Pliki/data_sheet.txt", true);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                fileWriter1 = new FileWriter("./CivSim/src/main/resources/com/civsim/Pliki/population_sheet.txt", true);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            printWriter = new PrintWriter(fileWriter);
            printWriter1 = new PrintWriter(fileWriter1);
            printWriter.println("Current Turn: " + counter);
            printWriter1.println("Current Turn: " + counter);
            printWriter.println(" ");
            printWriter1.println(" ");
            currentTime = (System.currentTimeMillis() - timeStart) / 1000;
            printWriter.println("Time: " + (currentTime) + " s");
            printWriter1.println("Time: " + (currentTime) + " s");
            printWriter.println(" ");
            try {
                randomEvents.eventPicker(counter, cityPositions);
                randomEvents.eventDeactivator(counter);
                printWriter.print("Current Events: ");
                for (int i = 0; i < randomEvents.getEventName().size(); i++) {
                    if (randomEvents.getRandomEventActive().get(i))
                        printWriter.print(randomEvents.getEventName().get(i)+", ");
                }
                printWriter.println(" ");
                printWriter.println(" ");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            civUnits.updateCivUnits(traderUnits, militaryUnits);
            civUnits.combat();
            trade = civUnits.trade(civPosition);
            for (Civilization item : civilization) {
                item.setHasAlly(false);
            }

                for(int i=0;i<civilization.size();i++){
                    if(trade.get(i)[0] != null){
                        for (Integer[] integers : trade) {
                            if (integers[0] == i && !civilization.get(i).getHasAlly()) {
                                civilization.get(i).setHasAlly(true);
                            }
                            if (integers[1] == i && !civilization.get(i).getHasAlly()) {
                                civilization.get(i).setHasAlly(true);
                            }
                        }
                    }
                    else if(trade.get(i)[1] != null){
                        for (Integer[] integers : trade) {
                            if (integers[0] == i && !civilization.get(i).getHasAlly()) {
                                civilization.get(i).setHasAlly(true);
                            }
                            if (integers[1] == i && !civilization.get(i).getHasAlly()) {
                                civilization.get(i).setHasAlly(true);
                            }
                        }
                    }
                }

            for (int i = 0; i < civilization.size(); i++) {
                civilization.get(i).getResources(simulationMap.getResources());
                civilization.get(i).civExpand();
                civilization.get(i).updatePopulationCount();
                this.cityPositions.set(i, civilization.get(i).citiesPositions());
                if(civilization.get(i).getMobileUnitsAmount() > 0){
                    if (civilization.get(i).getMilitaryUnitsAmount() > 0) {
                        if(civilization.get(i).militaryUnit!= null) {
                            civilization.get(i).militaryUnit.updatePosition();
                            militaryUnits.get(i).add(civilization.get(i).militaryUnit);
                            militaryUnitPosition.set(i, civilization.get(i).militaryUnit.getUnitPosition());
                        }
                    }
                    if (civilization.get(i).getTraderUnitsAmount() > 0) {
                        civilization.get(i).traderUnit.updatePosition();
                        if(traderUnits.get(i).size()==0){
                            traderUnits.get(i).add(civilization.get(i).traderUnit);
                        }else{
                            traderUnits.get(i).set(0, civilization.get(i).traderUnit);
                        }
                        traderUnitPosition.set(i, civilization.get(i).traderUnit.getUnitPosition());
                    }}
            }



            militaryUnits = civUnits.getMilitaryUnits();
            traderUnits = civUnits.getTraderUnits();
            for (int i = 0; i < civilization.size(); i++) {
                if (civilization.get(i).getMilitaryUnitsAmount() > 0) {
                    if(civilization.get(i).militaryUnit!= null){
                        if (militaryUnits.get(i).get(0).getHealth() <= 0) {
                            civilization.get(i).unitKiller();
                            militaryUnitPosition.set(i, null);
                            militaryUnits.get(i).set(0, null);
                        }
                    }
                }
            }
            ArrayList<ArrayList<MilitaryUnit>> swap = new ArrayList<>();
            for (int i = 0; i < civilization.size(); i++) {
                swap.add(new ArrayList<>());
                if (civilization.get(i).getMilitaryUnitsAmount() > 0) {
                    if (militaryUnits.get(i).get(0) != null) {
                        swap.get(i).add(militaryUnits.get(i).get(0));
                    }
                }
            }
            militaryUnits = swap;
            try {
                simulationMap.updateMap(civPosition, cityPositions, militaryUnitPosition, randomEvents, traderUnitPosition);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            for (int i = 0; i < civAmount; i++) {
                if (civilization.get(i).getMobileUnitsAmount() > 0) {
                    for (int o = 0; o < militaryUnits.get(i).size(); o++) {
                        if (militaryUnits.get(i).size() > 0 && militaryUnits.get(i).get(o) != null) {
                            printWriter.println("Military Unit Owner: (" + militaryUnits.get(i).get(o).getUnitColor().getRed() + ", " + militaryUnits.get(i).get(o).getUnitColor().getGreen() + ", " + militaryUnits.get(i).get(o).getUnitColor().getBlue() + ") " + "Unit Position: [" + militaryUnits.get(i).get(o).getUnitPosition().getX() + ", " + militaryUnits.get(i).get(o).getUnitPosition().getY() + "]");
                            printWriter.println("Health: " + militaryUnits.get(i).get(o).getHealth());
                        }
                    }
                }
                printWriter1.println("Civilization Population: "+civilization.get(i).getPopulationCount());
            }
            for (int i = 0; i < civAmount; i++) {
                if (civilization.get(i).getMobileUnitsAmount() > 0) {
                    if (traderUnits.get(i).size() > 0 && traderUnits.get(i).get(0) != null) {
                        printWriter.println("Trader Unit Owner: (" + traderUnits.get(i).get(0).getUnitColor().getRed() + ", " + traderUnits.get(i).get(0).getUnitColor().getGreen() + ", " + traderUnits.get(i).get(0).getUnitColor().getBlue() + ") " + "Unit Position: [" + traderUnits.get(i).get(0).getUnitPosition().getX() + ", " + traderUnits.get(i).get(0).getUnitPosition().getY() + "]");
                    }
                }
            }
            counter++;
            printWriter.println(" ");
            printWriter1.println(" ");
            printWriter.println(" ");
            printWriter1.println(" ");
            printWriter.close();
            printWriter1.close();
            maxedMap = new ArrayList<>();
            for (Civilization value : civilization) {
                maxedMap.add(value.getCivSize());
            }
            try {
                TimeUnit.MILLISECONDS.sleep((1000-(System.currentTimeMillis()-timeStartRound)));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            openInfoMenu();
        } catch (IOException | FontFormatException e) {
            throw new RuntimeException(e);
        }
        String[] strings = new String[civilization.size()];
        int[] civilizationPopulation = new int[civilization.size()];
        for(int i = 0;i<civilization.size();i++){
            civilizationPopulation[i] = civilization.get(i).getPopulationCount();
            strings[i] = ". place civilization: ["+civilization.get(i).civColor.getRed()+", "+civilization.get(i).civColor.getGreen()+", "+civilization.get(i).civColor.getBlue()+"] Population: " +civilization.get(i).getPopulationCount()+"\n";
        }

        for(int i = 0; i<civilization.size();i++){
            for(int j = i+1; j<civilization.size(); j++){
                int temp;
                String temps;
                if(civilizationPopulation[j]>civilizationPopulation[i]){
                    temp = civilizationPopulation[i];
                    civilizationPopulation[i] = civilizationPopulation[j];
                    civilizationPopulation[j]= temp;
                    temps = strings[i];
                    strings[i] = strings[j];
                    strings[j] = temps;
                }
            }
        }
        for(int i = 0;i<civilization.size();i++){
            civilizationPopulation[i] = civilization.get(i).getPopulationCount();
            strings[i] = (i+1)+strings[i];
        }
        try {
            new Winner(strings);
        } catch (IOException | FontFormatException e) {
            throw new RuntimeException(e);
        }
    }

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
    public void createDataSheet() throws IOException {
        File positionsFile = new File("./CivSim/src/main/resources/com/civsim/Pliki/data_sheet.txt");
        if(positionsFile.createNewFile()){
            System.out.println("File Created");
        }else{
            if(positionsFile.delete()){
                if(positionsFile.createNewFile()){
                    System.out.println("File Created");
                }
            }
        }
    }
    public void createPopulationSheet() throws IOException {
        File positionsFile = new File("./CivSim/src/main/resources/com/civsim/Pliki/population_sheet.txt");
        if(positionsFile.createNewFile()){
            System.out.println("File Created");
        }else{
            if(positionsFile.delete()){
                if(positionsFile.createNewFile()){
                    System.out.println("File Created");
                }
            }
        }
    }
}
