package com.example.Battleships_Backend.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;

@Entity(name = "ships")
public class Ship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private int size;

    @Column( name = "has_sunk")
    private boolean hasSunk;

    @OneToMany(mappedBy = "ship")
    @JsonIgnoreProperties({"ships"})
    private ArrayList<Cell> cells;


//    Constructor
    public Ship(String name, int size){
        this.name = name;
        this.size = size;
        this.hasSunk = false;
        this.cells = new ArrayList<>();
    }

    public Ship(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isHasSunk() {
        return hasSunk;
    }

    public void setHasSunk(boolean hasSunk) {
        this.hasSunk = hasSunk;
    }

    public ArrayList<Cell> getCells() {
        return cells;
    }

    public void setCells(ArrayList<Cell> cells) {
        this.cells = cells;
    }
}
