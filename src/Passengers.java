import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Passengers {

    public String name, surname, email, phoneNumber;
    TicketType ticketType;

    public Passengers(String name, String surname, String email, String phoneNumber, TicketType ticketType) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.ticketType = ticketType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }


    public String toString() {
        return "Name: "+getName()+", Surname: "+getSurname()+", " +
                "Email: "+getEmail()+", Phone number: "+getPhoneNumber()+", Ticket Type: "+
                getTicketType()+", Discount: "+getTicketType().getDiscountPercentage()+"%";
    }
}

