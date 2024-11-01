package com.example.test2.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CARSq", schema = "PUBLIC")
public class Car {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "model")
    private String model;

    @Column(name = "series")
    private int series;

    public Car() {

    }

    public Car(String model,int series){
        this.model = model;
        this.series = series;
    }

    public String getModel(){
        return this.model;
    }

    public void setModel(String model){
        this.model = model;
    }

    public int getSeries(){
        return this.series;
    }

    public void setSeries(int series){
        this.series = series;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + this.id +
                "; model=\"" + this.model +
                "\"; series=" + this.series
                + "}";
    }
}
