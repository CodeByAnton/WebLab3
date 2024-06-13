package com.annton.web_lab3.utils;

public class AreaChecker {
    public boolean checkHit(float x, float y, float r){
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
