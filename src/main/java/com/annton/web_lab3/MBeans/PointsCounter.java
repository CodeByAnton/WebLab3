package com.annton.web_lab3.MBeans;

import com.annton.web_lab3.DatabaseManager;
import com.annton.web_lab3.entity.Result;


import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;
import java.util.Collection;

public class PointsCounter extends NotificationBroadcasterSupport implements MBeanPointsCounter {
    private int totalPoints;
    private int missedPoints;
    private int consecutiveMisses=0;
    private long sequenceNumber = 1;
    private final DatabaseManager databaseManager;
    public PointsCounter(DatabaseManager databaseManager){
        this.databaseManager=databaseManager;
        initializeCounts();
    }
    private void initializeCounts(){
        totalPoints=0;
        missedPoints=0;
        Collection<Result> results=databaseManager.getAll();
        for (Result result: results){
            totalPoints++;
            if (!result.isIsHit()){
                missedPoints++;
            }
        }

    }
    @Override
    public void resetAndInitializeCounts(){
        totalPoints=0;
        missedPoints=0;
        consecutiveMisses=0;
        initializeCounts();
    }

    @Override
    public int getTotalPoints(){
        return totalPoints;
    }

    @Override
    public int getMissedPoints() {
        return missedPoints;
    }

    @Override
    public void incrementTotalPoints() {
        totalPoints++;
    }

    @Override
    public void incrementMissedPoints() {
        missedPoints++;
        consecutiveMisses++;
        if (consecutiveMisses==2){
            Notification n =new Notification("ConsecutiveMisses", this, sequenceNumber++,
                    "Два промоха подряд");
            sendNotification(n);
            System.out.println("Два промоха подряд");
            consecutiveMisses=0;
        }
    }






}
