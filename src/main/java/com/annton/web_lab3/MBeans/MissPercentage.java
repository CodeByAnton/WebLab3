package com.annton.web_lab3.MBeans;

public class MissPercentage implements MBeanPercentageMiss {

    private double percentage;



    @Override
    public double getMissPercentage(int totalPoints,int missedPoints) {

        if (totalPoints==0){
            percentage=0.0;

        }
        percentage=  (double) missedPoints / totalPoints * 100;
        return percentage;

    }

    @Override
    public double getPercentage() {
        return percentage;
    }
}
