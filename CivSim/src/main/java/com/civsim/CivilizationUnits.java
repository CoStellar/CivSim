package com.civsim;

import java.util.HashSet;
import java.util.Random;

import java.util.ArrayList;

public class CivilizationUnits {
        private ArrayList<ArrayList<TraderUnit>> traderUnits;
        private ArrayList<ArrayList<MilitaryUnit>> militaryUnits;
        private ArrayList<ArrayList<Position>>  traderUnitsPositions;
        private ArrayList<ArrayList<Position>>  militaryUnitsPositions;
        private MapSize mapSize;


        public CivilizationUnits(MapSize mapSize){
                this.mapSize = mapSize;
        }
        public void updateCivUnits(ArrayList<ArrayList<TraderUnit>> traderUnitsPosition, ArrayList<ArrayList<MilitaryUnit>> militaryUnitsPosition){
                this.traderUnits = traderUnitsPosition;
                this.militaryUnits = militaryUnitsPosition;
                        traderUnitsPositions = new ArrayList<>();
                        for(int i = 0; i<traderUnits.size(); i++){
                                traderUnitsPositions.add(new ArrayList<>());
                                for(int o = 0; o<traderUnits.get(i).size(); o++){
                                        traderUnitsPositions.get(i).add(this.traderUnits.get(i).get(o).getUnitPosition());
                                }
                        }
                        militaryUnitsPositions = new ArrayList<>();
                        for(int i = 0; i<militaryUnits.size(); i++){
                                militaryUnitsPositions.add(new ArrayList<>());
                                for(int o = 0; o<militaryUnits.get(i).size(); o++){

                                        militaryUnitsPositions.get(i).add(this.militaryUnits.get(i).get(o).getUnitPosition());
                                }
                        }
        }

        public int drawDmg(){
                Random random = new Random();
                return random.nextInt(4);
        }

        public void combat() {
                ArrayList<ArrayList<Position>> positionsAround = new ArrayList<>();
                traderUnitsPositions = new ArrayList<>();
                for(int i = 0; i<traderUnits.size(); i++){
                        traderUnitsPositions.add(new ArrayList<>());
                        for(int o = 0; o<traderUnits.get(i).size(); o++){
                                traderUnitsPositions.get(i).add(this.traderUnits.get(i).get(o).getUnitPosition());
                        }
                }
                militaryUnitsPositions = new ArrayList<>();
                for(int i = 0; i<militaryUnits.size(); i++){
                        militaryUnitsPositions.add(new ArrayList<>());
                        for(int o = 0; o<militaryUnits.get(i).size(); o++){
                                militaryUnitsPositions.get(i).add(this.militaryUnits.get(i).get(o).getUnitPosition());
                        }
                }
                for (int i = 0; i < militaryUnits.size(); i++) {
                        positionsAround.add(new ArrayList<>());
                        for (int o = 0; o < militaryUnits.get(i).size(); o++) {
                                positionsAround.get(i).add(new Position(militaryUnits.get(i).get(o).getUnitPosition().getX(), militaryUnits.get(i).get(o).getUnitPosition().getY()));
                                positionsAround.get(i).add(new Position(militaryUnits.get(i).get(o).getUnitPosition().getX() - 1, militaryUnits.get(i).get(o).getUnitPosition().getY()));
                                positionsAround.get(i).add(new Position(militaryUnits.get(i).get(o).getUnitPosition().getX() - 2, militaryUnits.get(i).get(o).getUnitPosition().getY()));
                                positionsAround.get(i).add(new Position(militaryUnits.get(i).get(o).getUnitPosition().getX(), militaryUnits.get(i).get(o).getUnitPosition().getY() - 1));
                                positionsAround.get(i).add(new Position(militaryUnits.get(i).get(o).getUnitPosition().getX(), militaryUnits.get(i).get(o).getUnitPosition().getY() - 2));
                                positionsAround.get(i).add(new Position(militaryUnits.get(i).get(o).getUnitPosition().getX() + 1, militaryUnits.get(i).get(o).getUnitPosition().getY()));
                                positionsAround.get(i).add(new Position(militaryUnits.get(i).get(o).getUnitPosition().getX() + 1, militaryUnits.get(i).get(o).getUnitPosition().getY()));
                                positionsAround.get(i).add(new Position(militaryUnits.get(i).get(o).getUnitPosition().getX(), militaryUnits.get(i).get(o).getUnitPosition().getY() + 1));
                                positionsAround.get(i).add(new Position(militaryUnits.get(i).get(o).getUnitPosition().getX(), militaryUnits.get(i).get(o).getUnitPosition().getY() + 2));
                                positionsAround.get(i).add(new Position(militaryUnits.get(i).get(o).getUnitPosition().getX() + 1, militaryUnits.get(i).get(o).getUnitPosition().getY() + 1));
                                positionsAround.get(i).add(new Position(militaryUnits.get(i).get(o).getUnitPosition().getX() - 1, militaryUnits.get(i).get(o).getUnitPosition().getY() + 1));
                                positionsAround.get(i).add(new Position(militaryUnits.get(i).get(o).getUnitPosition().getX() + 1, militaryUnits.get(i).get(o).getUnitPosition().getY() - 1));
                                positionsAround.get(i).add(new Position(militaryUnits.get(i).get(o).getUnitPosition().getX() - 1, militaryUnits.get(i).get(o).getUnitPosition().getY() - 1));
                        }

                }
                for (int x = 0; x < militaryUnits.size(); x++) {
                        positionsAround.get(x).removeIf(m -> (m.getX() <= -1 || m.getX() >= mapSize.getMapSize() || m.getY() <= -1 || m.getY() >= mapSize.getMapSize()));
                }
                for (int x = 0; x < positionsAround.size(); x++) {
                                for (int i = 0; i < militaryUnits.size(); i++) {
                                        for (int o = 0; o < militaryUnits.get(i).size(); o++) {
                                                        if(positionsAround.get(x).contains(militaryUnits.get(i).get(o).getUnitPosition())){
                                                                if(militaryUnitsPositions.get(x).get(0)!=militaryUnits.get(i).get(o).getUnitPosition()) {
                                                                        militaryUnits.get(i).get(o).updateHealth(drawDmg());
                                                                }
                                                        }

                                        }

                                }


                }
        }
        public ArrayList<ArrayList<MilitaryUnit>> getMilitaryUnits(){
                return this.militaryUnits;
        }



}
