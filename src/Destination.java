import java.util.ArrayList;
import java.util.Scanner;

public class Destination {
    private int busID;
    private String cityName;
    private String date;
    private String time;
    private String travelTime;
    private int numberOfSeats;
    private String price;
    private int cityId;

    public Destination(int busID, String cityName,
                       String date, String time, String travelTime,
                       int numberOfSeats, String price, int cityId) {
        this.busID = busID;
        this.cityName = cityName;
        this.date = date;
        this.time = time;
        this.travelTime = travelTime;
        this.numberOfSeats = numberOfSeats;
        this.price = price;
        this.cityId = cityId;
    }
    public static int getValidBusID(ArrayList<Destination> destinations){
        Scanner scanner = new Scanner(System.in);
        for (Destination destination : destinations)
            System.out.println("\t" + destination);
        while (true){
            System.out.println("Select the bus route (Enter available bus ID: ");
            int busID = scanner.nextInt();
            for (Destination destination : destinations) {
                if (destination.getBusID() == busID) {
                    return busID;
                }
            }
            System.out.println("[!] Entered bus ID is not valid.");
        }
    }
    public int getBusID() {
        return busID;
    }

    public void setBusID(int busID) {
        this.busID = busID;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(String travelTime) {
        this.travelTime = travelTime;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    @Override
    public String toString() {
        return "Bus ID: "+getBusID()+", City name: "+getCityName()+", Travel Date: "+
                getDate()+", Journey Time: "+getTime()+", Travel Time: "+getTravelTime()+", " +
                "Seats Available: "+getNumberOfSeats()+", Price: €"+getPrice().replace(',','.');
    }
}
