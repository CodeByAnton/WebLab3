package com.annton.web_lab3.MBeans;

import javax.management.MXBean;

@MXBean
public interface MBeanPercentageMiss {
    double getMissPercentage(int totalPoint, int MissedPoints);
    public double getPercentage();

}
