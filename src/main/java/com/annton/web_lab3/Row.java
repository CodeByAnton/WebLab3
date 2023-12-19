package com.annton.web_lab3;


import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.primefaces.PrimeFaces;

@Named("row")
@SessionScoped
public class Row implements Serializable {
    private final DatabaseManager databaseManager=new DatabaseManager();
    private String x;
    private String y;
    private float r;

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
    }
    public void insert(){
        long startTime=System.nanoTime();
        LocalDateTime localDateTime=LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDateTime = localDateTime.format(formatter);
        String msTime = String.format("%.6f", ((System.nanoTime() - startTime) / 1_000_000_000.0)).replace(',', '.');

        boolean isHit = checkHit(Float.parseFloat(x), Float.parseFloat(y), r);
        Result newRow=databaseManager.createRow(Float.parseFloat(x),Float.parseFloat(y),r,formattedDateTime,msTime,isHit);
        databaseManager.add(newRow);
    }
    private boolean checkHit(float x, float y, float r){
        if (x>0 && y>0){
            return false;
        }
        if (x>=0 &&y<=0){
            return (x*x+y*y<=r*r/4);
        }
        if (x<=0 &&y>=0){
            return (y<=2*x+r);
        }
        if (x<=0 &&y<=0){
            return ((x>=-r/2) && (y<=r));
        }


        return true;
    }

}
