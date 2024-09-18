package com.example.w22comp1008gcassignment2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car=new Car("honda","cord","Images/Honda.jpg",4);
    }

    @Test
    void setName() {
        car.setName("bmw");
        assertEquals("bmw",car.getName());
    }

    @Test
    void setImageLocation() {
        car.setImageLocation("Images/Audi.jpg");
        assertEquals("Images/Audi.jpg",car.getImageLocation());
    }

    @Test
    void setNameEmpty() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
           car.setName("");
        });
    }

    @Test
    void setNameWithTrim() {
        car.setName("    sds     ");
        assertEquals("sds",car.getName());
    }

    @Test
    void setNameSpaces() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            car.setName("      ");
        });
    }

    @Test
    void setNameLessWords() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            car.setName("sd");
        });
    }

    @Test
    void setModel() {
        car.setModel("123");
        assertEquals("123",car.getModel());
    }

    @Test
    void setModelLessWord() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            car.setModel("12");
        });
    }

    @Test
    void setModelEmpty() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            car.setModel("");
        });
    }

    @Test
    void setModelWithTrim() {
        car.setModel("  123     ");
        assertEquals("123",car.getModel());
    }

    @Test
    void setModelWithSpaces() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            car.setModel("        ");
        });
    }

    @Test
    void setSpace() {
        car.setSpace(4);
        assertEquals(4,car.getSpace());
    }

    @Test
    void setSpaceLess() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            car.setSpace(1);
        });
    }

    @Test
    void setSpaceMore() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            car.setSpace(10);
        });
    }

    @Test
    void testToString() {
        assertEquals("Car - honda",car.toString());
    }
}
