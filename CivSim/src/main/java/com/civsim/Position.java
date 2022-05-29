package com.civsim;
import java.util.*;

public class Position {

    public Integer x;
    public Integer y;

    Position() {
    }
    Position(MapSize mapSize) {
        this.x = drawRandomPosition(mapSize);
        this.y = drawRandomPosition(mapSize);
    }
    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Integer drawRandomPosition(MapSize mapSize) {
        Random random;
        random = new Random();
        return random.nextInt(mapSize.getMapSize());
    }
    public Integer getX() {
        return x;
    }

    public Integer getY(Integer y) {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Position other = (Position) obj;
        if (!Objects.equals(x, other.x))
            return false;
        if (!Objects.equals(y, other.y))
            return false;
        return true;
    }

}



