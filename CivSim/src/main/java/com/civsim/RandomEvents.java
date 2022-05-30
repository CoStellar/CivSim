package com.civsim;

import java.io.FileNotFoundException;
import java.io.IOException;
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
    public void eventPicker(Integer simRoundCount) throws IOException {

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
    public Position fireEvent() throws IOException {
        position = new Position();
        return position;
    }
    public Position diseaseEvent() throws IOException {
        position = new Position();
        return position;
    }
    public Position floodEvent() throws IOException {
        position = new Position();
        return position;
    }
    public Position monsoonEvent() throws IOException {
        position = new Position();
        return position;
    }
    public Position droughtEvent() throws IOException {
        position = new Position();
        return position;
    }
    public Position meteorShowerEvent() throws IOException {
        position = new Position();
        return position;
    }
    public Position tornadoEvent() throws IOException {
        position = new Position();
        return position;
    }
    public Position eventDeactivator(){
        return null;
    }

}
