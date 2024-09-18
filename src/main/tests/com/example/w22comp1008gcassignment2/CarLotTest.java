package com.example.w22comp1008gcassignment2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CarLotTest {
    private ArrayList<Car> carsList;
    private Car car;

    @BeforeEach
    void setUp() {
        carsList=new ArrayList<>();
        car=new Car("honda","cord","Images/Honda.jpg",4);
    }

    @Test
    void addCars() {
        carsList.add(car);
        assertEquals(car,carsList.get(0));
    }
}