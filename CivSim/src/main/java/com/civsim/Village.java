package com.civsim;

public class Village {

    private final int villagersCount;

    public Village()
    {
        this.villagersCount = (int) (Math.random() * 9)+1;
        Boolean villageStatus = true;
    }
    public int getVillagersCount() {
        return villagersCount;
    }


}
