import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Demo {

    public static void main(String[] args) {

        final String dbURL = "jdbc:mysql://localhost:3306/final_project";
        final String user = "root";
        final String password = "Parole123";


        Scanner scanner = new Scanner(System.in);
        System.out.println("How many tickets would you like to book?");
        int passenger = scanner.nextInt();
        System.out.println("Proceed with " + passenger + " tickets booking");
        System.out.println("Please select ticket type from 1 to 5 for each passenger: ");

        TicketType.printInfo();

        List<TicketType> ticketTypes = new ArrayList<>();

        for (int i = 0; i < passenger; i++) {
            TicketType ticketType = null;
            while (ticketType == null) {
                int code = scanner.nextInt();
                ticketType = TicketType.getByCode(code);
                ticketTypes.add(ticketType);
            }
        }
        float price = 0.0f;

        try (Connection connection = DriverManager.getConnection(dbURL, user, password)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT price FROM Destinations");

            while (resultSet.next()) {
                price = resultSet.getFloat(7);
                String output = "Price without discount: " + price;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        float originalPrice = price;
        float totalPrice = totalPrice(originalPrice, ticketTypes);
        System.out.printf("Total price is: %.2f€" , totalPrice);
    }

    private static float totalPrice(float originalPrice, List<TicketType> ticketTypes) {
        return ticketTypes.stream()
                .map(ticketType -> discountPrice(originalPrice, ticketType.getDiscountPercentage().floatValue()))
                .reduce(0f, Float::sum);
    }

    private static float discountPrice(float originalPrice, float discountPercentage) {
        return originalPrice * (1 - (0.01f * discountPercentage));
    }

}
