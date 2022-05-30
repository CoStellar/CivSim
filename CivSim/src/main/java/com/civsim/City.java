package com.civsim;

public class City {
    private Integer citizensCount;
    private Position cityPosition;
    private Boolean cityStatus;
        public City(Position cityPosition) {
            this.cityPosition = cityPosition;
            this.citizensCount = (int) (Math.random() * 20)+20;
            this.cityStatus = true;
        }
    public Position getCityPosition() {
        return cityPosition;
    }

    public Integer getCitizensCount() {
        return citizensCount;
    }

}
