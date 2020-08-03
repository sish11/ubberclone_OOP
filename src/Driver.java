
/**
 * Subclass of Person (extends from Person)
* The process where one class acquires the properties (methods and fields) of another.
* 
* Method overriding: When a child class implements a method of the parent class differently. 
* OR If subclass (child class) has the same method as declared in the parent class, 
* it is known as method overriding in java.
 */

public class Driver extends Person {

    //instance variables
    Car car;
    String licenseID;
    
    //constructor
    Driver(Car car, String licenseID, String name, String surname,String phone_number, int cash){
        super(name,surname,phone_number,cash);   
        this.car = car;
        this.licenseID = licenseID;    
    }


    

    //methods

    //setters
    public void setCar(Car car){
        this.car = car;
    }

    public void setlicenseID(String licenseID){
        this.licenseID = licenseID;
    }

    public Car getCar(){
        return this.car;
    }

    public String getlicenseID(){
        return  this.licenseID;
    }

    public String toString(){
        return super.toString() + " and I am a driver";
    }
    
    
    
}