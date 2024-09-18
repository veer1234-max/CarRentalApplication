package com.example.w22comp1008gcassignment2;

import java.util.ArrayList;

public class CarLot {
    private ArrayList<Car> carCollection;

    //constructor
    public CarLot(){
        carCollection=new ArrayList<>();
    }

    //add cars to the collection
    public void addCars(Car car){
        carCollection.add(car);
    }

    public ArrayList<Car> getCars(){
        return carCollection;
    }

}
