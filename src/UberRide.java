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


    UberRide(String startpoint, String endpoint, double price,Driver driver,Passenger passenger){
        super();
        this.startpoint = startpoint;
        this.endpoint = endpoint;
        this.price = price;
        this.rate = rate;
        this.driver = driver;
        this.passenger = passenger;
    }

    public double calculateDistance(String startingPoint, String endingPoint) {
        return 12.0;
    }
    public void assignDriver() {
        
    }
    public double calculateCost() {
        return 12.00;
    }
    public void completePayment() {

    }

    public static void MyGETRequest() throws IOException {
        URL urlForGetRequest = new URL("https://maps.googleapis.com/maps/api/distancematrix/json?origins=uct,SA&destinations=canalwalkshoppingcentre,SA&departure_time=now&key=AIzaSyCs2UIPeA_ygj6aDL45ta9ZdJu3Mo1PIOs");
        String readLine = null;
        HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
        conection.setRequestMethod("GET");
        int responseCode = conection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(
                new InputStreamReader(conection.getInputStream()));
            StringBuffer response = new StringBuffer();
            while ((readLine = in.readLine()) != null) {
                response.append(readLine);
            } in .close();
            // print result
            // System.out.println("JSON String Result " + response.toString());
            retrieveDistanceAsString(response.toString());
        } else {
            System.out.println("GET NOT WORKED");
        }
    }

    /**
     * converts jsonstring to gson object, then it returns the text length
     * can access elements using: 
     * getAsJsonObject
     * getAsJsonArray
     */
    public static void retrieveDistanceAsString(String jsonString) {
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
             System.out.println(jsonObject.get("value"));
         }
    }

    public static void main(String[] args) throws IOException {
        MyGETRequest();
    }
}