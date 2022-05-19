package com.civsim;

public class CivilizationUnits {
        String unitOwner;
        Position[] traderUnitsPositions;
        Position[] militaryUnitsPositions;
        Integer militaryUnitsAmount;
        Integer traderUnitsAmount;

        public Integer totalUnitsAmount(){
                return this.militaryUnitsAmount+this.traderUnitsAmount;
        }
        public Integer checkMilitaryAmount(){
                return this.militaryUnitsAmount;
        }
        public Integer checkTraderAmount(){
                return this.traderUnitsAmount;
        }
        public void updateTrader(Position[] positions, String unitOwner){

        }
        public void updateMilitary(Position[] positions, String unitOwner){

        }


}
