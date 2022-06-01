package com.civsim;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class RandomEvents {
    public ArrayList<ArrayList<Position>> getRandomEventPosition() {
        return randomEventPosition;
    }

    private final ArrayList<ArrayList<Position>> randomEventPosition = new ArrayList<>();
    private final ArrayList<String> randomEventOrder = new ArrayList<>();

    public ArrayList<Boolean> getRandomEventActive() {
        return randomEventActive;
    }

    private final ArrayList<Boolean> randomEventActive = new ArrayList<>();
    private final ArrayList<Integer> randomEventFinishTime = new ArrayList<>();
    public Integer randomEventGlobalCounter=0;
    private int simRoundAmount;
    private Position position;
    private Random random = new Random();
    private final MapSize mapSize;
    public RandomEvents(int simRoundAmount, MapSize mapSize){
            this.simRoundAmount = simRoundAmount;
            this.mapSize = mapSize;
    }

    public void eventPicker(Integer simRoundCount, ArrayList<ArrayList<Position>> cityPositions) throws IOException {
        ArrayList<Position> allPositions = new ArrayList<>();
        for(int i = 0; i< cityPositions.size();i++){
            for(int o = 0;o<cityPositions.get(i).size(); o++){
                allPositions.add(cityPositions.get(i).get(o));
            }
        }
        int x, z = randomEventGlobalCounter;

        if(simRoundCount%5==0){
            x = random.nextInt(8)+1;
            if(x == 1){
                randomEventPosition.add(new ArrayList<>());
                randomEventPosition.get(z).add(fireEvent(simRoundCount));
            }
            if(x == 2 && allPositions.size()>0){
                randomEventPosition.add(new ArrayList<>());
                randomEventPosition.get(z).add(diseaseEvent(simRoundCount, allPositions));
            }
            if(x == 3){
                randomEventPosition.add(new ArrayList<>());
                randomEventPosition.get(z).add(floodEvent(simRoundCount));
            }
            if(x == 4){
                randomEventPosition.add(new ArrayList<>());
                randomEventPosition.get(z).add(monsoonEvent(simRoundCount));
            }
            if(x == 5){
                randomEventPosition.add(new ArrayList<>());
                randomEventPosition.get(z).add(droughtEvent(simRoundCount));
            }
            if(x == 6){
                randomEventPosition.add(new ArrayList<>());
                randomEventPosition.get(z).add(meteorShowerEvent(simRoundCount));
            }
            if(x == 7){
                randomEventPosition.add(new ArrayList<>());
                randomEventPosition.get(z).add(tornadoEvent(simRoundCount));
            }

        }
    }
    public Position fireEvent(int simRoundCount){
        position = new Position(mapSize);
        randomEventGlobalCounter++;
        this.randomEventOrder.add("fire");
        this.randomEventActive.add(true);
        this.randomEventFinishTime.add(simRoundCount+4);
        return position;
    }
    public Position diseaseEvent(int simRoundCount, ArrayList<Position> cityPositions){

        Random random = new Random();
        position = cityPositions.get(random.nextInt(cityPositions.size()));
        randomEventGlobalCounter++;
        this.randomEventOrder.add("disease");
        this.randomEventActive.add(true);
        this.randomEventFinishTime.add(simRoundCount+8);
        return position;
    }
    public Position floodEvent(int simRoundCount){
        position = new Position(mapSize);
        randomEventGlobalCounter++;
        this.randomEventOrder.add("flood");
        this.randomEventActive.add(true);
        this.randomEventFinishTime.add(simRoundCount+8);
        return position;
    }
    public Position monsoonEvent(int simRoundCount){
        position = new Position(mapSize);
        randomEventGlobalCounter++;
        this.randomEventOrder.add("monsoon");
        this.randomEventActive.add(true);
        this.randomEventFinishTime.add(simRoundCount+5);
        return position;
    }
    public Position droughtEvent(int simRoundCount){
        position = new Position(mapSize);
        randomEventGlobalCounter++;
        this.randomEventOrder.add("drought");
        this.randomEventActive.add(true);
        this.randomEventFinishTime.add(simRoundCount+10);
        return position;
    }
    public Position meteorShowerEvent(int simRoundCount){
        position = new Position(mapSize);
        randomEventGlobalCounter++;
        this.randomEventOrder.add("meteor shower");
        this.randomEventActive.add(true);
        this.randomEventFinishTime.add(simRoundCount+4);
        return position;
    }
    public Position tornadoEvent(int simRoundCount){
        position = new Position(mapSize);
        randomEventGlobalCounter++;
        this.randomEventOrder.add("tornado");
        this.randomEventActive.add(true);
        this.randomEventFinishTime.add(simRoundCount+4);
        return position;
    }
    public void eventDeactivator(Integer simRoundCount){
        for(int i= 0; i< randomEventFinishTime.size(); i++){
            if(Objects.equals(randomEventFinishTime.get(i), simRoundCount)){
                randomEventActive.set(i, false);
            }
        }
    }
    public ArrayList<String> getEventName(){
        ArrayList<String> eventNames = new ArrayList<>();
        for(int i= 0; i< randomEventFinishTime.size(); i++){
            eventNames.add(i, randomEventOrder.get(i));
            }
        return  eventNames;
        }


}
