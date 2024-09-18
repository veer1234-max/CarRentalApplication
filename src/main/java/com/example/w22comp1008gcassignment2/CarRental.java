package com.example.w22comp1008gcassignment2;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import static java.util.concurrent.TimeUnit.DAYS;

public class CarRental {
    private String customerName;
    private Car car;
    private boolean validLicense;
    private LocalDate reservationDateFrom, reservationDateTo;

    /**
     * This constructor reserves the car
     * @param car
     * @param validLicense
     * @param reservationDateFrom
     * @param reservationDateTo
     */
    public CarRental(Car car, boolean validLicense, LocalDate reservationDateFrom, LocalDate reservationDateTo) {
        setCar(car);
        setValidLicense(validLicense);
        setReservationDateFrom(reservationDateFrom);
        setReservationDateTo(reservationDateTo);
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public boolean isValidLicense() {
        return validLicense;
    }

    public void setValidLicense(boolean validLicense) {
        this.validLicense = validLicense;
    }

    public LocalDate getReservationDateFrom() {
        return reservationDateFrom;
    }

    public void setReservationDateFrom(LocalDate reservationDateFrom) {
        if(reservationDateFrom.isAfter(LocalDate.now())){
            this.reservationDateFrom = reservationDateFrom;
        }else{
            throw new IllegalArgumentException("the date is before the present date");
        }
    }

    public LocalDate getReservationDateTo() {
        return reservationDateTo;
    }

    public void setReservationDateTo(LocalDate reservationDateTo) {
        if(reservationDateTo.isAfter(reservationDateFrom)){
            this.reservationDateTo = reservationDateTo;
        }else{
            throw new IllegalArgumentException("the reservation date to cannot be before from date");
        }
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        if(customerName.length()>=2){
            this.customerName = customerName;
        }else{
            throw new IllegalArgumentException("the customer name cannot be less then 2 charaters");
        }
    }

    //function to calculate the total rent
    public float totalRent(){
        long noOfDaysBetween = ChronoUnit.DAYS.between(reservationDateFrom, reservationDateTo);
        return car.getRent()*(float) noOfDaysBetween;
    }

    public String toString(){
        return customerName +"( "+car.getName()+" from "+reservationDateFrom+" to "+reservationDateTo+" ) " + "rent : "+ totalRent();
    }

}
