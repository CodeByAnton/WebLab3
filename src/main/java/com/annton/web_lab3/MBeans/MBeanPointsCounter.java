package com.annton.web_lab3.MBeans;

import javax.management.MXBean;

@MXBean
public interface MBeanPointsCounter {
    int getTotalPoints();
    int getMissedPoints();
    void incrementTotalPoints();
    void incrementMissedPoints();
    void resetAndInitializeCounts();
}
