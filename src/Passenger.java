public class Passenger extends Person {

    //instance variables
    String email;

    //constructor
    Passenger(String email, String name, String surname,String phone_number, int cash){
        super(name,surname,phone_number, cash);
        this.email = email;
    }

    //methods

    public void setEmail(String email){
        this.email  = email;
    }

    public String getEmail() {
        return this.email;
    }

    public String toString(){
        return super.toString() + " and I am a passenger";
    }

    
}