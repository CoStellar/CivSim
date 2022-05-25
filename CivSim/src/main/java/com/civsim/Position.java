package com.civsim;
import java.util.*;

public class Position {


    public Integer x;
    public Integer y;
    Random random;
    MapSize mapSize;
    Position() {
        this.mapSize = new MapSize(25);
        this.x = drawRandomPosition(mapSize);
        this.y = drawRandomPosition(mapSize);
    }
    Position(MapSize mapSize) {
        this.x = drawRandomPosition(mapSize);
        this.y = drawRandomPosition(mapSize);
    }

    public Integer drawRandomPosition(MapSize mapSize) {
        random = new Random();
        return random.nextInt(mapSize.getMapSize());
    }
    public Integer getX() {
        return x;
    }

    public Integer getY(Integer y) {
        return y;
    }



}



