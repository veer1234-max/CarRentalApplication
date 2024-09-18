package com.example.w22comp1008gcassignment2;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class CarViewController implements Initializable {

    @FXML
    private Label carNameHardLabel;

    @FXML
    private Label rentHardLabel;

    @FXML
    private Label spaceHardLabel;

    @FXML
    private Label modelHardLabel;

    @FXML
    private Label carNameLabel;

    @FXML
    private RadioButton falseRadioButton;

    @FXML
    private Label modelLabel;

    @FXML
    private TextField nameTextBox;

    @FXML
    private Label rentLabel;

    @FXML
    private Label spaceLabel;

    @FXML
    private RadioButton trueRadioButton;

    @FXML
    private ListView<Car> carAvaListView;

    @FXML
    private ListView<CarRental> rentedCarsListView;

    @FXML
    private ImageView myImageView;

    @FXML
    private DatePicker reserveFromDatePicker;

    @FXML
    private DatePicker reserveToDatePicker;

    Car car1=new Car("Mercedes-Benz","A Class","Images/Mercedes-Benz.jpg",4);
    Car car2=new Car("Audi","A42","Images/Audi.jpg",4);
    Car car3=new Car("Honda","Civic","Images/Honda.jpg",6);
    Car car4=new Car("Tayota","Camry","Images/Tayota.jpg",6);
    Car car5=new Car("Ford","Mustang","Images/Ford.jpg",4);

    CarLot carsAvailable=new CarLot();
    Car currentCar;
    CarRental rentACar;
    ArrayList<CarRental> rentedCars=new ArrayList<>();
    ArrayList<CarRental> checkOnCars=new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        car1.setCarImage();
        car2.setCarImage();
        car3.setCarImage();
        car4.setCarImage();
        car5.setCarImage();
        carsAvailable.addCars(car1);
        carsAvailable.addCars(car2);
        carsAvailable.addCars(car3);
        carsAvailable.addCars(car4);
        carsAvailable.addCars(car5);

        carNameHardLabel.setVisible(false);
        modelHardLabel.setVisible(false);
        spaceHardLabel.setVisible(false);
        rentHardLabel.setVisible(false);

        carAvaListView.getItems().addAll(carsAvailable.getCars());
        carAvaListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Car>() {
            @Override
            public void changed(ObservableValue<? extends Car> observableValue, Car car, Car t1) {
                currentCar=carAvaListView.getSelectionModel().getSelectedItem();
                myImageView.setImage(currentCar.getCarImage());
                carNameLabel.setText(currentCar.getName());
                modelLabel.setText(currentCar.getModel());
                rentLabel.setText(Float.toString(currentCar.getRent()));
                spaceLabel.setText(Integer.toString(currentCar.getSpace()));
                carNameHardLabel.setVisible(true);
                modelHardLabel.setVisible(true);
                spaceHardLabel.setVisible(true);
                rentHardLabel.setVisible(true);
            }
        });
    }

    @FXML
    void reserveCar() {
        int flag=0;
        boolean license=false;
        if(trueRadioButton.isSelected()){
            license=true;
        }else if(falseRadioButton.isSelected()){
            license=false;
        }
        rentACar=new CarRental(currentCar,license,reserveFromDatePicker.getValue(),reserveToDatePicker.getValue());
        rentACar.setCustomerName(nameTextBox.getText());
        if(license==true){
            if(checkOnCars.size()!=0){
                for(CarRental cars: checkOnCars) {
                    if (cars.getCar().equals(rentACar.getCar()) && ( ( cars.getReservationDateFrom().equals(rentACar.getReservationDateFrom()) && cars.getReservationDateTo().equals(rentACar.getReservationDateTo()) )
                       || ( rentACar.getReservationDateFrom().isAfter(cars.getReservationDateFrom()) && rentACar.getReservationDateTo().isBefore(cars.getReservationDateTo()) )
                       || ( rentACar.getReservationDateFrom().isAfter(cars.getReservationDateFrom()) && rentACar.getReservationDateFrom().isBefore(cars.getReservationDateTo()) )
                       || ( rentACar.getReservationDateTo().isAfter(cars.getReservationDateFrom()) && rentACar.getReservationDateTo().isBefore(cars.getReservationDateTo()) ) ) ) {
                        System.out.println("sorry the car is already booked");
                        flag=1;
                    }
                }
            }
            if(flag==0){
                rentedCars.add(rentACar);
                checkOnCars.add(rentACar);
                rentedCarsListView.getItems().addAll(rentedCars);
                rentedCars.clear();
            }


        } else{
            System.out.println("you cannot register a car because you don't have licence");
        }

    }
}
