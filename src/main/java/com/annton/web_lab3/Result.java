package com.annton.web_lab3;

import jakarta.persistence.*;


@Entity
@Table(name = "result_table") // Имя таблицы в базе данных
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private float x;
    private float y;
    private float r;
    private String currentTime;
    private String executionTime;
    private boolean isHit;

    // Конструкторы
    public Result() {
    }

    public Result(float x, float y, float r, String currentTime, String executionTime, boolean isHit) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.currentTime = currentTime;
        this.executionTime = executionTime;
        this.isHit = isHit;
    }

    // Геттеры и сеттеры для всех полей
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getR() {
        return r;
    }

    public void setR(float r) {
        this.r = r;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public String getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(String executionTime) {
        this.executionTime = executionTime;
    }

    public boolean isIsHit() {
        return isHit;
    }

    public void setHit(boolean hit) {
        isHit = hit;
    }

}
