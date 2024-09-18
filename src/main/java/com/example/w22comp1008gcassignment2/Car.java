package com.example.w22comp1008gcassignment2;

import javafx.scene.image.Image;

public class Car {
    //instance variable
    private String name,model,imageLocation;
    private int space;
    private Image carImage;
    private float rent;


    /**
     * Constructor- it takes the details of the car to rent
     * @param name-name of the car
     * @param model-model of the car
     * @param space-capacity of the car
     * @param imageLocation-takes the string arg of location
     */
    public Car(String name, String model,String imageLocation, int space) {
        if(space<=4){
            this.rent=30;
        }
        else{
            this.rent=50;
        }
        setName(name);
        setModel(model);
        setSpace(space);
        setImageLocation(imageLocation);
    }

    public String getImageLocation() {
        return imageLocation;
    }

    public void setImageLocation(String imageLocation) {
        this.imageLocation = imageLocation;
    }

    public float getRent() {
        return rent;
    }

    public void setCarImage(){
        carImage=new Image(getClass().getResource(imageLocation).toExternalForm());
    }

    public Image getCarImage(){
        return carImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name=name.trim();
        if(name.length() >=3)
            this.name = name;
        else
            throw new IllegalArgumentException("name must be 3 characters");
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        model=model.trim();
        if(model.length() >=3)
            this.model = model;
        else
            throw new IllegalArgumentException("model must be 3 characters");
    }

    public int getSpace() {
        return space;
    }

    public void setSpace(int space) {
        if(space >=2 && space<=8)
            this.space = space;
        else
            throw new IllegalArgumentException("space must be for 2 persons");
    }

    @Override
    public String toString() {
        return String.format("Car - %s",name);
    }
}
