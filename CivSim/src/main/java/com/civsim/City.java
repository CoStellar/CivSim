package com.civsim;

public class City {
    private final Integer citizensCount;
    private final Position cityPosition;
    private final Boolean cityStatus;
        public City(Position cityPosition)
        {
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
