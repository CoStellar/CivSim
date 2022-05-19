package com.civsim;

import java.util.Random;

public class RandomEvents {
    private Position[][] randomEventPosition;
    private String[] randomEventOrder;
    private Boolean[] randomEventActive;
    private Integer[] randomEventFinishTime;
    public Integer randomEventGlobalCounter;
    private Integer[] randomEventFieldAmount;
    private Position position;
    Random random;
    public void eventPicker(Integer simRoundCount){

        int x, y = randomEventGlobalCounter, z = simRoundCount;
        if(simRoundCount%5==0){
            x = random.nextInt(8)+1;
            if(x == 1){
                randomEventPosition[z][y] = fireEvent();
            }
            if(x == 2){
                randomEventPosition[z][y] = diseaseEvent();
            }
            if(x == 3){
                randomEventPosition[z][y] =  floodEvent();
            }
            if(x == 4){
                randomEventPosition[z][y] =  monsoonEvent();
            }
            if(x == 5){
                randomEventPosition[z][y] =  droughtEvent();
            }
            if(x == 6){
                randomEventPosition[z][y] =  meteorShowerEvent();
            }
            if(x == 7){
                randomEventPosition[z][y] =  tornadoEvent();
            }

        }
    }
    public Position fireEvent(){
        position = new Position();
        return position;
    }
    public Position diseaseEvent(){
        position = new Position();
        return position;
    }
    public Position floodEvent(){
        position = new Position();
        return position;
    }
    public Position monsoonEvent(){
        position = new Position();
        return position;
    }
    public Position droughtEvent(){
        position = new Position();
        return position;
    }
    public Position meteorShowerEvent(){
        position = new Position();
        return position;
    }
    public Position tornadoEvent(){
        position = new Position();
        return position;
    }
    public Position eventDeactivator(){
        return null;
    }

}
