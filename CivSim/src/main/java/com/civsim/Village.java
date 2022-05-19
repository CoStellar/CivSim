package com.civsim;

public class Village {

    private Integer villagersCount;
    private Position villagePosition;
    private Boolean villageStatus;

        public Village(int villagersCount) {

            this.villagersCount = villagersCount;
        }

        public Village(Position villagePosition) {
        this.villagePosition = villagePosition;
        }

        public Village(boolean villageStatus) {

            this.villageStatus = villageStatus;
        }
}
