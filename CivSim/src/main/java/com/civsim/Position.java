package com.civsim;
import java.io.*;
import java.util.*;

public class Position {

    public Integer x;
    public Integer y;

    Position() throws IOException {
        Scanner scanner = new Scanner(new File("./CivSim/src/main/resources/com/civsim/Pliki/positions.txt"));
        ArrayList<String> line = new ArrayList<>();
        Random random = new Random();
        Integer[] positions = new Integer[2];
        while (scanner.hasNextLine()) {
             line.add(scanner.nextLine());
        }
        scanner.close();
        int number = random.nextInt(line.size());
        String[] positionsString = line.get(number).trim().split("\\s+");
        positions[0] = Integer.parseInt(positionsString[0]);
        positions[1] = Integer.parseInt(positionsString[1]);
        this.x = positions[0];
        this.y = positions[1];
        line.remove(number);
        File positionsFile = new File("./CivSim/src/main/resources/com/civsim/Pliki/positions.txt");
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
        for(String i: line) {
            printWriter.println(i);
        }
        printWriter.close();
    }
    Position(MapSize mapSize) {
        this.x = drawRandomPosition(mapSize);
        this.y = drawRandomPosition(mapSize);
    }
    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    Position(boolean xd) {

    }
    public Integer drawRandomPosition(MapSize mapSize) {
        Random random;
        random = new Random();
        return random.nextInt(mapSize.getMapSize());
    }
    public Integer getX() {
        return x;
    }

    public Integer getY() {
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
        return Objects.equals(y, other.y);
    }



}



