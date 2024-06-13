package com.annton.web_lab3.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "result_table") // Имя таблицы в базе данных
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "x")
    private float x;

    @Column(name = "y")
    private float y;

    @Column(name = "r")
    private float r;

    @Column(name = "is_hit")
    private boolean isHit;

    // Конструкторы
    public Result() {
    }

    public Result(float x, float y, float r,  boolean isHit) {
        this.x = x;
        this.y = y;
        this.r = r;
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



    public boolean isIsHit() {
        return isHit;
    }

    public void setHit(boolean hit) {
        isHit = hit;
    }

}
