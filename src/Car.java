public class Car implements Vehicle {

    //instance variables
    String numberPlate;
    String color;
    String model;
    String type;
    double base_rate;

    //constructor
    Car(String numberPlate, String color, String model, String type) {
        this.numberPlate = numberPlate;
        this.color = color;
        this.model = model;
        this.type = type;
        if(type.equals("XL")) {
            this.base_rate = 15.00;
        } else {
            this.base_rate = 10.00;
        }
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

    public String toString() {
        return this.model + " car of " + this.color + " color, with number plate: " + this.numberPlate;
    }
}