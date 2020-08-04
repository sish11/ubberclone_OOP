import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import com.google.gson.*;
import java.util.*;

// response.rows[0].elements[0].distance.text
public class UberRide extends Ride {

    //instance variables
    String startpoint;
    String endpoint;
    double price;
    double rate;
    Driver driver;
    Passenger passenger;
    double distance;


    UberRide() {}

    UberRide(String startpoint, String endpoint, Passenger passenger){
        super();
        this.startpoint = startpoint;
        this.endpoint = endpoint;
        this.price = price;
        this.rate = rate;
        this.driver = null;
        this.passenger = passenger;
    }

   

    public Driver assignDriver() {
        //connect to database and fetch list of drivers DB
        //call the function that takes X/XL - from user
            /**
             * read data from csv
             * create car object using last 4 columns
             * create driver object using first 5 columns
             * add driver to Driver[]
             */

        //call the function that return random driver

        Database DB = new Database();
        DB.getDriversArray();
        Driver[] drivers = DB.getArrayByVehicleType("XL");
        // DB.printArray(drivers);

        Random ran = new Random();
        int randomIndex = ran.nextInt(drivers.length-1);

        this.driver = drivers[randomIndex];
        
        return drivers[randomIndex];
    }
    
    public void completePayment(Driver driver, Passenger passenger) {
       /**
        * Add money to driver
        * Deduct money from passenger
        */

        
        double driverBalance = driver.getCash();
        driver.setCash(driverBalance + this.price);
        System.out.println("Adding R" + (int)this.price + " to driver account. Account bal: R" + driver.getCash());

        double passengerBalance = passenger.getCash();
        passenger.setCash(passengerBalance - this.price);
        System.out.println("Deducting R" + (int)this.price + " from passenger account. Account bal: R" + passenger.getCash());
    }

    public double calculateDistance(String startingPoint, String endingPoint) {
        double distance = 0.0;
        try {
            UberRide uberRide = new UberRide();
            distance = uberRide.MyGETRequest(startingPoint, endingPoint);
        }
        catch(IOException ex){
            System.out.println (ex.toString());
        }

        this.distance = distance/1000;
        System.out.println("The distance is: " + this.distance + " km");
        return (distance/1000);
    }
    public double calculateCost(String startingPoint, String endingPoint) {

        double cost = 0.0;
        UberRide uberRide = new UberRide();
        double distance = uberRide.calculateDistance(startingPoint, endingPoint);
        cost = distance * this.driver.getCar().getBaseRate();
        this.price = cost;
        System.out.println("The cost is: R" + (int)this.price);
        return cost;
    }
    public double MyGETRequest(String startingPoint, String endingPoint) throws IOException {
        URL urlForGetRequest = new URL("https://maps.googleapis.com/maps/api/distancematrix/json?origins=" + startingPoint +",SA&destinations=" + endingPoint + ",SA&departure_time=now&key=AIzaSyCs2UIPeA_ygj6aDL45ta9ZdJu3Mo1PIOs");
        String readLine = null;
        HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
        conection.setRequestMethod("GET");
        int responseCode = conection.getResponseCode();


        UberRide uberRide = new UberRide();
        double distance = 0.0;
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(
                new InputStreamReader(conection.getInputStream()));
            StringBuffer response = new StringBuffer();
            while ((readLine = in.readLine()) != null) {
                response.append(readLine);
            } in .close();
            // print result
            // System.out.println("JSON String Result " + response.toString());
            String distanceAsString = uberRide.retrieveDistanceAsString(response.toString());
            distance = Double.parseDouble(distanceAsString);
        } else {
            // response = error;
            System.out.println("GET NOT WORKED");
        }

        
        

        return distance;
    }
    /**
     * converts jsonstring to gson object, then it returns the text length
     * can access elements using: 
     * getAsJsonObject
     * getAsJsonArray
     */
    public String retrieveDistanceAsString(String jsonString) {
        GsonBuilder builder = new GsonBuilder(); 
        builder.setPrettyPrinting(); 
        Gson gson = builder.create(); 
        JsonObject jsonObject = gson.fromJson(jsonString, JsonObject.class); 
        JsonArray jsonArray = jsonObject.getAsJsonArray("rows");
           
        JsonElement je = null;
        Iterator<JsonElement> iterator = jsonArray.iterator();
         while(iterator.hasNext()) {
             je = iterator.next();
             jsonArray = je.getAsJsonObject().getAsJsonArray("elements");
         }

         iterator = jsonArray.iterator();
         while(iterator.hasNext()) {
             je = iterator.next();
             jsonObject = je.getAsJsonObject().get("distance").getAsJsonObject();
            //  System.out.println(jsonObject.get("value"));

            //  try {
            //     jsonObject = je.getAsJsonObject().get("distance").getAsJsonObject();
            //  }
            //  catch(Exception e) {

            //  }
         }

         return jsonObject.get("value")+"";


    }
}