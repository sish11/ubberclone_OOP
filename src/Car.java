public class Car implements Vehicle {

    //instance variables
    String numberPlate;
    String color;
    String model;

    //constructor
    Car(String numberPlate, String color, String model) {
        this.numberPlate = numberPlate;
        this.color = color;
        this.model = model;
    }

    //methods
    public String getNumberPlate() {
        return this.numberPlate;
    }
    public String getColor() {
        return this.color;
    }
    public String getModel() {
        return this.model;
    }
}