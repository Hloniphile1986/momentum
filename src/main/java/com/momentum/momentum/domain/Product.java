package com.momentum.momentum.domain;

public class Product {
    private String name;
    private String code;
    private double points;

    public Product() {
    }

    public Product(String name, String code, double points) {
        this.code = code;
        this.name = name;
        this.points = points;
    }

    public String getCode() {
        return code;
    }

    public void setCode(final String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }


    public double getPoints() {
        return points;
    }

    public void setPoints(final double points) {
        this.points = points;
    }
}


