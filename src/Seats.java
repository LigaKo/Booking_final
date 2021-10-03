import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Seats {

        public int seatSelection(int busID) {

            Scanner input = new Scanner (System.in);
            int seats = 0;

            int []seatNo = new int[21];
            Boolean isSeatSelected = false;

            while (!isSeatSelected) {

                System.out.print("BUS SEATING PLAN \n");

                for (int SeatCounter = 1; SeatCounter < seatNo.length; SeatCounter++) {
                    System.out.printf("\t" + SeatCounter);

                    if (SeatCounter == 4) {
                        System.out.println();
                    } else if (SeatCounter == 8) {
                        System.out.println();
                    } else if (SeatCounter == 12) {
                        System.out.println();
                    } else if (SeatCounter == 16) {
                        System.out.println();
                    }
                }
                ArrayList<Integer> seatsTaken = this.seatAvailability(busID);
                this.showSeatsAvailability(seatsTaken);

                System.out.println();
                System.out.print("Please select available seat: ");
                seats = input.nextInt();

                if (seats < 0 || seats > 20) {
                    System.out.println("[!] Incorrect seat number.");
                } else if (seatsTaken.contains(seats)){
                    System.out.println("[!] This seat is taken");
                }
                else {
                    isSeatSelected = true;
                }
            }

            return seats;
        }

    public ArrayList<Integer> seatAvailability (int busID) {
        ArrayList<Integer> seatsTaken = new ArrayList<>();
        DB db = new DB();

        try{
            Statement statement = db.connection.createStatement();

            String query = "SELECT seatNumber FROM ticket_info WHERE busID=" +busID;
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                int seatTaken = resultSet.getInt("seatNumber");

                seatsTaken.add(seatTaken);
            }

        }catch (SQLException e){
            System.out.println(e.getStackTrace());
        }


        return seatsTaken;
    }

    public void showSeatsAvailability(ArrayList<Integer> seatsTaken){
        System.out.print("\nSeats available: ");

        for(int seat = 1; seat <= 20; seat++){
            if (!seatsTaken.contains(seat)) {
                System.out.print(seat + " ");
            }

        }
    }
}