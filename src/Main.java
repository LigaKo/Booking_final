import com.mysql.cj.jdbc.interceptors.ResultSetScannerInterceptor;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main (String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        User user = new User();

        String phoneNumber;
        String email;
        System.out.println("\n===== Welcome to bus ticket reservation system =====");

        while (true) {
            System.out.print("Enter username: ");
            int username = scanner.nextInt();

            System.out.print("Enter password: ");
            int password = scanner.nextInt();

            user.setUserID(username);
            user.setPassword(password);

            if (user.login()) {

                ArrayList<City> cities = getCities();
                int cityID = City.getValidID(cities);
                ArrayList<Destination> destinations = getAvailableBuses(cityID);

                int busID = Destination.getValidBusID(destinations);
                scanner.nextLine();

                Seats seats = new Seats();
                int seatNumber = seats.seatSelection(busID);

                System.out.print("Enter passenger's name: ");
                String name = scanner.nextLine().trim().toUpperCase();

                System.out.print("Enter passenger's surname: ");
                String surname = scanner.nextLine().trim().toUpperCase();

                boolean emailMatches = false;

                do { System.out.print("Enter passenger's email address: ");

                    email = scanner.nextLine().trim().toUpperCase();

                    Pattern pattern = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
                    Matcher matcher = pattern.matcher(email);

                    emailMatches = matcher.matches();

                    if (!emailMatches) {
                        System.out.printf("[!] Email address is not correct. \n");
                    }
                } while (!emailMatches);

                boolean phoneNumberMatches = false;
                do {
                    System.out.print("Enter passenger's phone number: ");
                    System.out.print("+371 ");
                    phoneNumber = scanner.nextLine().trim().replace(" ", "");
                    Pattern pattern = Pattern.compile("[0-9]{8}");
                    Matcher matcher = pattern.matcher(phoneNumber);

                    phoneNumberMatches = matcher.matches();

                    if (!phoneNumberMatches) {

                        System.out.printf("[!] Entered phone number %s is not correct. \n", phoneNumber);

                    }
                } while (!phoneNumberMatches);

                int ticketCode = TicketType.getValidTicketCode();
                Passengers passenger = new Passengers(name, surname, email,
                        phoneNumber, TicketType.getByCode(ticketCode));

                System.out.println("\n============= Your ticket Info =============");
                Destination destination = null;
                for (Destination destination1 : destinations)
                    if (destination1.getBusID() == busID)
                        destination = destination1;

                double discount = Double.parseDouble(destination.getPrice().replace(',', '.')) -
                        (Double.parseDouble(destination.getPrice().replace(',', '.')) *
                                passenger.getTicketType().getDiscountPercentage().doubleValue() / 100);
                System.out.println(passenger + ", Ticket Price: " + String.format("%.2f", discount) + " EUR," + " Seat: " + seatNumber);
                System.out.print("\nWould you like to confirm the booking? (Yes = 1), (No = 2): ");
                int book = scanner.nextInt();
                if (book == 1) {
                    bookTicket(passenger, destination,
                            Double.parseDouble(String.valueOf(discount)), busID, seatNumber);
                    System.out.println("Ticket booked. Thank you!");
                }
                else
                    System.out.println("You have cancelled the booking!");
                break;
            } else {
                System.out.println("[!] Username/password is incorrect, please try again");
            }
        }

    }

    private static void bookTicket(Passengers passenger, Destination destination,
                                   double price, int busID, int seatNumber) throws Exception {
        DB db = new DB();
        db.preStatement = db.connection.prepareStatement("SET GLOBAL time_zone = '+3:00';");
        db.preStatement.executeUpdate();
        db.preStatement = db.connection.prepareStatement("INSERT INTO ticket_info(name,surname,phoneNumber," +
                "email,destination,date,time,ticketType,discountAmount,ticketPrice, busID, seatNumber)VALUES" +
                "(?,?,?,?,?,?,?,?,?,?,?,?)");
        db.preStatement.setString(1, passenger.getName());
        db.preStatement.setString(2, passenger.getSurname());
        db.preStatement.setString(3, passenger.getPhoneNumber());
        db.preStatement.setString(4, passenger.getEmail());
        db.preStatement.setString(5, destination.getCityName());
        db.preStatement.setString(6, destination.getDate());
        db.preStatement.setString(7, destination.getTime());
        db.preStatement.setString(8, passenger.getTicketType().getInfo());
        db.preStatement.setDouble(9, Double.parseDouble(String.valueOf(passenger.getTicketType().getDiscountPercentage())));
        db.preStatement.setDouble(10, price);
        db.preStatement.setInt(11, busID);
        db.preStatement.setInt(12, seatNumber);
        db.preStatement.executeUpdate();
    }

    private static ArrayList<City> getCities() throws Exception {
        DB db = new DB();
        db.preStatement = db.connection.prepareStatement("SET GLOBAL time_zone = '+3:00';");
        db.preStatement.executeUpdate();
        ArrayList<City> cities = new ArrayList<>();
        db.preStatement = db.connection.prepareStatement("SELECT * FROM city");
        db.result = db.preStatement.executeQuery();
        while (db.result.next()) {
            cities.add(new City(db.result.getInt("cid"),
                    db.result.getString("name")));
        }

        return cities;
    }

    private static ArrayList<Destination> getAvailableBuses(int city) throws Exception {
        DB db = new DB();
        db.preStatement = db.connection.prepareStatement("SET GLOBAL time_zone = '+3:00';");
        db.preStatement.executeUpdate();
        ArrayList<Destination> destinations = new ArrayList<>();
        db.preStatement = db.connection.prepareStatement("SELECT * FROM destinations WHERE cityID ='" +
                city + "' AND MaximumNumberOfSeats > 0");
        db.result = db.preStatement.executeQuery();
        while (db.result.next()) {
            destinations.add(new Destination(db.result.getInt("busID"),
                    db.result.getString("destination"), db.result.getString("journeyDate"),
                    db.result.getString("journeyTime"), db.result.getString("travelTime"),
                    db.result.getInt("MaximumNumberOfSeats"), db.result.getString("price"),
                    db.result.getInt("cityID")));
        }
        return destinations;
    }
}