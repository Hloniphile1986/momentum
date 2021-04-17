package com.momentum.momentum.persitence.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Product")
public class ProductEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue( strategy= GenerationType.AUTO )
    private Long id;
    private String name;
    private String code;
    private int points;

    public ProductEntity() {
    }

    public Long getId() {
        return id;
    }

    public ProductEntity(String name, String code, int points) {
        this.name = name;
        this.code = code;
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(final int points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "ProductEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", points=" + points +
                '}';
    }

}
