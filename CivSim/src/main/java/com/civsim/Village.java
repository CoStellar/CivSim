package com.civsim;

public class Village {

    private final int villagersCount;
    private Position villagePosition;
    private Boolean villageStatus;
        public Village(Position villagePosition) {
            this.villagePosition = villagePosition;
            this.villagersCount = (int) (Math.random() * 10);
            this.villageStatus = true;
        }

    public int getVillagersCount() {
        return villagersCount;
    }


}
