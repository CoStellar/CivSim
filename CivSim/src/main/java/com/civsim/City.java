package com.civsim;

public class City {

    private Integer citizensCount;

    private Position cityPosition;
    private Boolean cityStatus;
        public City(Position cityPosition) {
            this.cityPosition = cityPosition;
            this.citizensCount = (int) (Math.random() * 10);
            this.cityStatus = true;
        }

        public City(Boolean cityStatus) {

            this.cityStatus = cityStatus;
        }

        public City(Integer citizensCount) {

            this.citizensCount = citizensCount;
        }


}
