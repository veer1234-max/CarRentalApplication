package com.example.w22comp1008gcassignment2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class CarRentalTest {
    private Car car;
    private CarRental carRental;

    @BeforeEach
    void setUp() {
        car=new Car("honda","cord","Images/Honda.jpg",4);
        carRental=new CarRental(car,true,LocalDate.parse("2022-04-13"),LocalDate.parse("2022-04-20"));
    }

    @Test
    void setCar() {
        carRental.setCar(car);
        assertEquals(car,carRental.getCar());
    }

    @Test
    void setValidLicense() {
        carRental.setValidLicense(true);
        assertEquals(true,carRental.isValidLicense());
    }

    @Test
    void setReservationDateFrom() {
        carRental.setReservationDateFrom(LocalDate.parse("2022-04-26"));
        assertEquals(LocalDate.parse("2022-04-26"),carRental.getReservationDateFrom());
    }

    @Test
    void setReservationDateFromBeforeNow() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            carRental.setReservationDateFrom(LocalDate.parse("2022-04-10"));
        });
    }

    @Test
    void setReservationDateTo() {
        carRental.setReservationDateTo(LocalDate.parse("2022-04-16"));
        assertEquals(LocalDate.parse("2022-04-16"),carRental.getReservationDateTo());
    }

    @Test
    void setReservationDateToBeforeFirstDate() {
        carRental.setReservationDateFrom(LocalDate.parse("2022-04-26"));
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            carRental.setReservationDateTo(LocalDate.parse("2022-04-16"));
        });
    }

    @Test
    void setCustomerName() {
        carRental.setCustomerName("naruto");
        assertEquals("naruto",carRental.getCustomerName());
    }

    @Test
    void setCustomerNameShort() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            carRental.setCustomerName("a");
        });
    }

    @Test
    void totalRent() {
        assertEquals(210,carRental.totalRent());
    }
}