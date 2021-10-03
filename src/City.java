import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Scanner;

public class City {
    private int cityId;
    private String cityName;

    public City(int cityId, String cityName) {
        this.cityId = cityId;
        this.cityName = cityName;
    }

    public static int getValidID(ArrayList<City> cities) {

                Scanner scanner = new Scanner(System.in);

        for (City city : cities)
            System.out.println(city);

        while (true) {
            System.out.println("Where do you want to go to? (Enter available ID): ");
            int id = scanner.nextInt();
            for (City city : cities) {
                if (city.cityId == id) {
                    return id;
                }
            }
            System.out.println("[!] Entered ID is not valid.");
        }
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return "\t ID: " + getCityId() + "     City name: " + getCityName();
    }
}
