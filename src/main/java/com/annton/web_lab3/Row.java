package com.annton.web_lab3;


import com.annton.web_lab3.MBeans.MissPercentage;
import com.annton.web_lab3.MBeans.PointsCounter;
import com.annton.web_lab3.entity.Result;
import com.annton.web_lab3.utils.AreaChecker;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;



import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.io.Serializable;
import java.lang.management.ManagementFactory;
import java.util.List;

@Named("row")
@SessionScoped
public class Row implements Serializable {
    private final AreaChecker areaChecker=new AreaChecker();
    private final DatabaseManager databaseManager=new DatabaseManager();
    private String x;
    private String y;
    private float r;
    private final MBeanServer mBeanServer;
    private final MissPercentage missPercentage;
    private final PointsCounter pointsCounter;

    public Row(){
        this.mBeanServer= ManagementFactory.getPlatformMBeanServer();
        this.pointsCounter=new PointsCounter(databaseManager);
        this.missPercentage=new MissPercentage();
        try{
            ObjectName counter=new ObjectName(
                    "com.annton.web_lab3.MBeans:type=PointsCounter");
            ObjectName percentage=new ObjectName("com.annton.web_lab3.MBeans:type=MissPercentage");
            mBeanServer.registerMBean(pointsCounter,counter);
            mBeanServer.registerMBean(missPercentage,percentage);

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getX() {
        return x;
    }

    public String getY() {
        return y;
    }

    public float getR() {
        return r;
    }

    public void setX(String x) {
        this.x = x;
    }


    public void setY(String y) {
        this.y = y;
    }

    public void setR(float r) {
        this.r = r;
    }





    public List<Result> getRows(){
        return databaseManager.getAll();
    }
    public void clear(){
        databaseManager.clear();
        pointsCounter.resetAndInitializeCounts();
    }
    public void insert(){
        boolean isHit = areaChecker.checkHit(Float.parseFloat(x), Float.parseFloat(y), r);
        resultMBeansHandle(isHit);
        Result newRow=databaseManager.createRow(Float.parseFloat(x),Float.parseFloat(y),r,isHit);
        databaseManager.add(newRow);
    }

    private void resultMBeansHandle( boolean isHit){
        pointsCounter.incrementTotalPoints();
        if (!isHit){
            pointsCounter.incrementMissedPoints();
        }
        double missed=missPercentage.getMissPercentage(pointsCounter.getTotalPoints(), pointsCounter.getMissedPoints());
        System.out.println(missed);
    }


}
