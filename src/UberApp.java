import java.util.*;

public class UberApp {

    public static void main(String[] args) {
        System.out.println("Welcome to Uber App");

        Passenger lonwabo = new Passenger("lonwabo@gmail.com", "Lonwabo", "Mvovo","0731223283", 12000);
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your current starting location");
        String startPoint = sc.nextLine();

        System.out.println("Please enter your final destination location");
        String endPoint = sc.nextLine();

        System.out.println("Please vehicle of your choice, either XL or X");
        String vehicleType = sc.nextLine();
        
        System.out.print("Starting Point: ");
        System.out.print(startPoint);
        System.out.print("\nEnd Point: ");
        System.out.print(endPoint);
        System.out.print("\nVehicle Type: ");
        System.out.print(vehicleType);
        System.out.println("");
        


        // Car bmw = new Car("KA1234", "black", "BMW X5", "XL");
        // System.out.println(bmw.base_rate);

        // Person akhil = new Person("Akhil", "Boddu", "07838282", 123.12);
        // System.out.println(akhil);

        // Driver sam = new Driver(bmw, "LICENSE12345", "Sam", "Surname","0731281283", 1000);
        // System.out.println(sam);

        
    }

}