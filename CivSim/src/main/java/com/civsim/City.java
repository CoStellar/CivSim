package com.civsim;

public class City {
    private final Integer citizensCount;
    private final Position cityPosition;

    public City(Position cityPosition)
        {
            this.cityPosition = cityPosition;
            this.citizensCount = (int) (Math.random() * 20)+20;
        }
    public Position getCityPosition() {
        return cityPosition;
    }

    public Integer getCitizensCount() {
        return citizensCount;
    }

}
