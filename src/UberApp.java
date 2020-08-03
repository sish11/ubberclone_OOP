public class UberApp {

    public static void main(String[] args) {
        System.out.println("Welcome to Uber App");

        Car bmw = new Car("KA1234", "black", "BMW X5", "XL");
        System.out.println(bmw);

        Person akhil = new Person("Akhil", "Boddu", "07838282", 123.12);
        System.out.println(akhil);

        Driver sam = new Driver(bmw, "LICENSE12345", "Sam", "Surname","0731281283", 1000);
        System.out.println(sam);

        Passenger lonwabo = new Passenger("lonwabo@gmail.com", "Lonwabo", "Mvovo","0731223283", 12000);
        System.out.println(lonwabo);
    }

}